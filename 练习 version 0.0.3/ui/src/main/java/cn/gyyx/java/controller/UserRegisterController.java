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
