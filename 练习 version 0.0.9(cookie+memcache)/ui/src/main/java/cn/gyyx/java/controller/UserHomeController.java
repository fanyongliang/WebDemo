/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * ����SpringMVC��Ŀʱ���ɵĿ�����,��������
-------------------------------------------------------------------------*/

package cn.gyyx.java.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gyyx.java.beans.UserInfo;

@Controller
public class UserHomeController {
	/**
	 * ����һ��������ʾ����̨��־��Ϣ��logger����
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserHomeController.class);

	/**
	 * SpringMVC�Դ���������
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "regist";
	}
	
	/**
	 * �Լ��������Ե�����
	 * @param model
	 * @return
	 */
	@RequestMapping("/test8")
	public String test8(Model model) {
//		UserInfo userInfo = new UserInfo();
//		userInfo.getInfo_id();
//		model.addAttribute("u", userInfo);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setInfo_account("account");
		model.addAttribute(userInfo);
		return "home";
	}

}
