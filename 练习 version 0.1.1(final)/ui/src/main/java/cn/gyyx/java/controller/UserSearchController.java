/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理信息检索的控制器
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
import cn.gyyx.java.bll.UserInfoBLL;

/**
 * 管理用户检索信息
 * @author user
 *
 */
@Controller
@RequestMapping("Search")
public class UserSearchController {
	/**
	 * 创建UserInfoBLL对象实例
	 */
	private UserInfoBLL userInfoBLL = new UserInfoBLL();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserSearchController.class);

	/**
	 * 根据信息内容进行检索
	 * 
	 * @param key
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/find/{key}", method = RequestMethod.GET)
	public String find(@PathVariable String key, Model model) {
		logger.info(key);
		// key = "'%"+key+"%'";
		List<UserInfo> users = userInfoBLL.getUserInfoByKey(key);
		logger.info(users.toString());
		model.addAttribute("users", users);
		return "searchList";

	}

}
