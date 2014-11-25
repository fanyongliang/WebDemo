/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 创建SpringMVC项目时生成的控制器,用来测试
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
	 * 创建一个用于显示控制台日志信息的logger对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserHomeController.class);

	/**
	 * SpringMVC自带测试例子
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
	 * 自己用来测试的例子
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
