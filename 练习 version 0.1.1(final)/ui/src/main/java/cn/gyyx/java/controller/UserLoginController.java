/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理用户登录的控制器
-------------------------------------------------------------------------*/

package cn.gyyx.java.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.beans.UserLogin;
import cn.gyyx.java.bll.UserInfoBLL;
/**
 * 管理用户登录
 * @author fanyongliang
 *
 */
@Controller
@RequestMapping("Login")
public class UserLoginController {
	/**
	 * 创建UserInfoBLL对象实例
	 */
	private UserInfoBLL userInfoBLL = new UserInfoBLL();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserLoginController.class);

	/**
	 * 验证用户登录
	 * 
	 * @param userLogin
	 * @param model
	 * @return
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws IOException
	 */
	@RequestMapping("/pass")
	public String pass(@ModelAttribute UserLogin userLogin, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, TimeoutException, InterruptedException,
			MemcachedException {
		List<UserInfo> users = userInfoBLL.getSelectAll();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			logger.info("Cookie数量:" + cookies.length);
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("accountuuid")) {
					logger.info("-------true & false-----:"
							+ cookie.getName().equals("accountuuid"));
					String value = cookie.getValue();
					if (userInfoBLL.getMem(value) == null) {
						logger.info("memcache中不存在信息!");
						model.addAttribute("msg", "memcache中不存在信息!");
						return "login";
					} else {
						//
						model.addAttribute("users", users);
						//
						int count = userInfoBLL.getSelectCount();
						logger.info("-------------总共的user数量--------------:"
								+ count);
						int pages = (count % 5) == 0 ? (count / 5)
								: (count / 5 + 1);
						logger.info("-------------总共的页数--------------:" + pages);
						model.addAttribute("pages", pages);
						model.addAttribute("page", 1);
						model.addAttribute("num", 5);
						//
						return "list";
					}
				} else {
					logger.info("Cookie不存在或者已经过期!");
					model.addAttribute("msg", "Cookie不存在或者已经过期!");
					return "login";
				}
			}
		}
		String userLogin_account = userLogin.getUser_account();
		String userLogin_password = userLogin.getUser_password();
		if (userInfoBLL.checkLoginAccount(userLogin_account,
				userLogin_password) == true) {
			// cookie
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Cookie cUUID = new Cookie("accountuuid", uuid);
			cUUID.setMaxAge(100);
			response.addCookie(cUUID);
			// memcache
			userInfoBLL.setMem(uuid, users);
			//
			model.addAttribute("users", users);
			//
			int count = userInfoBLL.getSelectCount();
			logger.info("-------------总共的user数量--111-----------:" + count);
			int pages = (count % 5) == 0 ? (count / 5) : (count / 5 + 1);
			logger.info("-------------总共的页数----111----------:" + pages);
			model.addAttribute("pages", pages);
			model.addAttribute("page", 1);
			model.addAttribute("num", 5);
			//
			return "list";
		} else {
			logger.info("用户名或密码错误!");
			model.addAttribute("msg", "请重新登录!");
			return "login";
		}
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/show")
	public String show() {
		return "login";
	}

}
