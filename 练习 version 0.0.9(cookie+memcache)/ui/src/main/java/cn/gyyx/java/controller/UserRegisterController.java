/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * �����û�ע��Ŀ�����
-------------------------------------------------------------------------*/

package cn.gyyx.java.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.bll.ChangePasswordBLL;
import cn.gyyx.java.service.UserInfoService;

@Controller
@RequestMapping("Register")
public class UserRegisterController {
	/**
	 * ����UserInfoService����ʵ��
	 */
	private static UserInfoService userInfoService = new UserInfoService();
	/**
	 * ����logger����̨��־��ʾ����
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserRegisterController.class);
	
	/**
	 * �û�ע����֤����ȷ��ת����ҳ��
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@ModelAttribute UserInfo userInfo, Model model) {
		UserInfo checkAccount = userInfoService.selectByAccount(userInfo
				.getInfo_account());
		if (checkAccount == null) {
			logger.info("Welcome home!");
			String password = ChangePasswordBLL.changePassword(userInfo
					.getInfo_password());
			userInfo.setInfo_password(password);
			int a = userInfoService.add(userInfo);
			logger.info("add:" + a);
			return "login";
		} else {
			logger.info("�û����Ѵ���!");
			model.addAttribute("msg", "�û����Ѵ���,��������");
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
	/**
	 * ��ת��ע��ҳ��
	 * @return
	 */
	@RequestMapping("/show")
	public String show() {
		return "regist";
	}

}
