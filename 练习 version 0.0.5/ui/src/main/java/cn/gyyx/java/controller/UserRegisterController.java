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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.bll.ChangePasswordService;
import cn.gyyx.java.service.UserInfoService;

@Controller
@RequestMapping("Register")
public class UserRegisterController {
	private static UserInfoService userInfoService = new UserInfoService();

	private static final Logger logger = LoggerFactory
			.getLogger(UserRegisterController.class);

	@RequestMapping("/list")
	public String list(@ModelAttribute UserInfo userInfo, Model model) {
		UserInfo checkAccount = userInfoService.selectByAccount(userInfo
				.getInfo_account());
		if (checkAccount == null) {
			logger.info("Welcome home!");
			String password = ChangePasswordService.changePassword(userInfo
					.getInfo_password());
			userInfo.setInfo_password(password);
			int a = userInfoService.add(userInfo);
			logger.info("add:" + a);
			return "login";
		} else {
			logger.info("用户名已存在!");
			model.addAttribute("msg", "用户名已存在,重新输入");
			model.addAttribute("name",userInfo.getInfo_name() );
			model.addAttribute("gender", userInfo.getInfo_gender());
			model.addAttribute("card", userInfo.getInfo_card());
			model.addAttribute("phone", userInfo.getInfo_phone());
			model.addAttribute("email", userInfo.getInfo_email());
			model.addAttribute("question", userInfo.getInfo_question());
			model.addAttribute("answer", userInfo.getInfo_answer());
			return "regist";
		}
	}

	@RequestMapping("/show")
	public String show() {
		return "regist";
	}

}
