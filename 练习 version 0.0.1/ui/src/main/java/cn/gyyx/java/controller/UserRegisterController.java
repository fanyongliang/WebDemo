/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
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
