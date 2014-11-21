/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理进行分页查询的控制器
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
	 * 创建UserInfoService对象实例
	 */
	private static UserInfoService userInfoService = new UserInfoService();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserPageController.class);
	
	/**
	 * 进行分页查询
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/pageIndex/{page}", method = RequestMethod.GET)
	public String find(@PathVariable int page, Model model) {
		PageInfo pageOne = new PageInfo();
		logger.info("当前的Page:"+page);
		List<UserInfo> users = userInfoService.selectByPage(page);
		pageOne.setPageIndex(page);
		logger.info("更新的Page:"+page);
		logger.info(users.toString());
		model.addAttribute("page", pageOne.getPageIndex());
		logger.info("----------获取pageIndex--------------:"+pageOne.getPageIndex());
		model.addAttribute("users", users);
		int num = users.size();
		logger.info("-------------总共查到的user数量--------------:"+num);
		model.addAttribute("num", num);
		int count = userInfoService.selectCount();
		logger.info("-------------总共的user数量--------------:"+count);
		int pages = (count%5)==0?(count/5):(count/5+1);
		logger.info("-------------总共的页数--------------:"+pages);
		model.addAttribute("pages", pages);
		return "list";

	}
}
