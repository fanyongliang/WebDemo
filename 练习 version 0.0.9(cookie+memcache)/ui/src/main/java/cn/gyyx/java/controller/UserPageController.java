/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * ������з�ҳ��ѯ�Ŀ�����
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

import cn.gyyx.java.beans.PageInfo;
import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.service.UserInfoService;

@Controller
@RequestMapping("Page")
public class UserPageController {
	/**
	 * ����UserInfoService����ʵ��
	 */
	private static UserInfoService userInfoService = new UserInfoService();
	/**
	 * ����logger����̨��־��ʾ����
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserPageController.class);
	
	/**
	 * ���з�ҳ��ѯ
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/pageIndex/{page}", method = RequestMethod.GET)
	public String find(@PathVariable int page, Model model) {
		PageInfo pageOne = new PageInfo();
		logger.info("��ǰ��Page:"+page);
		List<UserInfo> users = userInfoService.selectByPage(page);
		pageOne.setPageIndex(page);
		logger.info("���µ�Page:"+page);
		logger.info(users.toString());
		model.addAttribute("page", pageOne.getPageIndex());
		logger.info("----------��ȡpageIndex--------------:"+pageOne.getPageIndex());
		model.addAttribute("users", users);
		int num = users.size();
		logger.info("-------------�ܹ��鵽��user����--------------:"+num);
		model.addAttribute("num", num);
		int count = userInfoService.selectCount();
		logger.info("-------------�ܹ���user����--------------:"+count);
		int pages = (count%5)==0?(count/5):(count/5+1);
		logger.info("-------------�ܹ���ҳ��--------------:"+pages);
		model.addAttribute("pages", pages);
		return "list";

	}
}
