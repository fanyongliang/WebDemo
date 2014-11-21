/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * �����û���¼�Ŀ�����
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
	 * ����UserInfoService����ʵ��
	 */
	private static UserInfoService userInfoService = new UserInfoService();
	/**
	 * ����logger����̨��־��ʾ����
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserLoginController.class);

	/**
	 * ��֤�û���¼
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
		logger.info("Cookie����:" + cookies.length);
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
						logger.info("memcache�в�������Ϣ!");
						model.addAttribute("msg", "Cookie�Ѿ����ڣ����µ�¼!");
						return "login";
					} else {
						//
						model.addAttribute("users", users);
						model.addAttribute("account",
								userLogin.getUser_account());
						//
						int count = userInfoService.selectCount();
						logger.info("-------------�ܹ���user����--------------:"
								+ count);
						int pages = (count % 5) == 0 ? (count / 5)
								: (count / 5 + 1);
						logger.info("-------------�ܹ���ҳ��--------------:" + pages);
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
			logger.info("-------------�ܹ���user����--111-----------:" + count);
			int pages = (count % 5) == 0 ? (count / 5) : (count / 5 + 1);
			logger.info("-------------�ܹ���ҳ��----111----------:" + pages);
			model.addAttribute("pages", pages);
			model.addAttribute("page", 1);
			model.addAttribute("num", 5);
			//
			return "list";
		} else {
			logger.info("�û������������!");
			model.addAttribute("msg", "�û������������!");
			return "login";
		}
	}

	/**
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/show")
	public String show() {
		return "login";
	}

}
