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

import cn.gyyx.java.beans.PageInfo;
import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.beans.UserLogin;
import cn.gyyx.java.bll.ChangePasswordBLL;
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
		String newPassword = ChangePasswordBLL.changePassword(userLogin.getUser_password());
		if (checkAccount != null && checkAccount.getInfo_password().equals(newPassword)) {
			logger.info("Welcome home!The password is " + checkAccount.getInfo_password().equals(newPassword));
			List<UserInfo> users = userInfoService.selectAllUsers();
			model.addAttribute("users", users);
			model.addAttribute("account", userLogin.getUser_account());
			//
			int count = userInfoService.selectCount();
			logger.info("-------------总共的user数量--------------:"+count);
			int pages = (count%5)==0?(count/5):(count/5+1);
			logger.info("-------------总共的页数--------------:"+pages);
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

	@RequestMapping("/show")
	public String show() {
		return "login";
	}

}
