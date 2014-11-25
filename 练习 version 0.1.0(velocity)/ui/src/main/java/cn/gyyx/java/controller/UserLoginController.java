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

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.beans.UserLogin;
import cn.gyyx.java.bll.ChangePasswordBLL;
import cn.gyyx.java.service.UserInfoService;

@Controller
@RequestMapping("Login")
public class UserLoginController {
	/**
	 * 创建UserInfoService对象实例
	 */
	private static UserInfoService userInfoService = new UserInfoService();
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
	 */
	@RequestMapping("/pass")
	public String pass(@ModelAttribute UserLogin userLogin, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		List<UserInfo> users = userInfoService.selectAllUsers();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			logger.info("Cookie数量:" + cookies.length);
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("accountuuid")) {
					logger.info("-------true & false-----:"
							+ cookie.getName().equals("uuid"));
					String value = cookie.getValue();
					MemcachedClientBuilder builder = new XMemcachedClientBuilder(
							"127.0.0.1:11211");
					try {
						MemcachedClient client = builder.build();
						if (client.get(value) == null) {
							logger.info("memcache中不存在信息!");
							model.addAttribute("msg", "Cookie已经过期，重新登录!");
							System.out.println("-------->msg显示了");
							return "login";
						} else {
							//
							model.addAttribute("users", users);
							model.addAttribute("account",
									userLogin.getUser_account());
							//
							int count = userInfoService.selectCount();
							logger.info("-------------总共的user数量--------------:"
									+ count);
							int pages = (count % 5) == 0 ? (count / 5)
									: (count / 5 + 1);
							logger.info("-------------总共的页数--------------:"
									+ pages);
							model.addAttribute("pages", pages);
							model.addAttribute("page", 1);
							model.addAttribute("num", 5);
							//
							return "list";
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		UserInfo checkAccount = userInfoService.selectByAccount(userLogin
				.getUser_account());
		String newPassword = ChangePasswordBLL.changePassword(userLogin
				.getUser_password());
		if (checkAccount != null
				&& checkAccount.getInfo_password().equals(newPassword)) {
			logger.info("Welcome home!The password is "
					+ checkAccount.getInfo_password().equals(newPassword));

			// cookie
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Cookie cUUID = new Cookie("accountuuid", uuid);
			cUUID.setMaxAge(100);
			response.addCookie(cUUID);
			// memcache
			MemcachedClientBuilder builder = new XMemcachedClientBuilder(
					"127.0.0.1:11211");
			try {
				MemcachedClient client = builder.build();
				client.set(uuid, 0, users);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//
			model.addAttribute("users", users);
			model.addAttribute("account", userLogin.getUser_account());
			//
			int count = userInfoService.selectCount();
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
			model.addAttribute("msg", "用户名或密码错误!");
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
