/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/

package cn.gyyx.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.beans.UserLogin;
import cn.gyyx.java.bll.ChangePasswordService;
import cn.gyyx.java.service.UserInfoService;

@Controller
@RequestMapping("Login")
public class UserLoginController {
	private static UserInfoService userInfoService = new UserInfoService();

	private static final Logger logger = LoggerFactory
			.getLogger(UserLoginController.class);

	@RequestMapping("/pass")
	public String pass(@ModelAttribute UserLogin userLogin, Model model) {
		UserInfo checkAccount = userInfoService.selectByAccount(userLogin
				.getUser_account());
		String newPassword = ChangePasswordService.changePassword(userLogin.getUser_password());
		if (checkAccount != null && checkAccount.getInfo_password().equals(newPassword)) {
			logger.info("Welcome home!The password is " + checkAccount.getInfo_password().equals(newPassword));
			List<UserInfo> users = userInfoService.selectAllUsers();
			model.addAttribute("users", users);
			model.addAttribute("account", userLogin.getUser_account());
			return "list";
		} else {
			logger.info("用户名或密码错误!");
			model.addAttribute("msg", "用户名或密码错误!");
			return "login";
		}
	}

	@RequestMapping("/show")
	public String show() {
		return "login";
	}

}
