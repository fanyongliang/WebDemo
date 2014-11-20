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
		logger.info("Welcome home!");
		String password = ChangePasswordService.changePassword(userInfo
				.getInfo_password());
		userInfo.setInfo_password(password);
		int a = userInfoService.add(userInfo);
		logger.info("add:" + a);
		model.addAttribute("account", userInfo.getInfo_account());
		return "list";
	}

	@RequestMapping("/show")
	public String show() {
		return "regist";
	}

}
