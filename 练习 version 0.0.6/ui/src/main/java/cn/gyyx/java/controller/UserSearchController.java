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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.service.UserInfoService;

@Controller
@RequestMapping("Search")
public class UserSearchController {
	private static UserInfoService userInfoService = new UserInfoService();

	private static final Logger logger = LoggerFactory
			.getLogger(UserSearchController.class);

	@RequestMapping(value = "/find/{key}", method = RequestMethod.GET)
	public String find(@PathVariable String key, Model model) {
		logger.info(key);
		//key = "'%"+key+"%'";
		List<UserInfo> users = userInfoService.selectByKey(key);
		logger.info(users.toString());
		model.addAttribute("users", users);
		return "list";

	}
}
