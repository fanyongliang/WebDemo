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

import cn.gyyx.java.beans.UserLogin;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("Register")
public class UserRegisterController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserRegisterController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/list")
	public String list(@ModelAttribute UserLogin userLogin,Model model) {
		logger.info("Welcome home!"+","+userLogin.getUser_account()+","+userLogin.getUser_password());
		model.addAttribute("account",userLogin.getUser_account());
		return "home";
	}
	@RequestMapping("/show")
	public String show() {
		return "regist";
	}
	

}
