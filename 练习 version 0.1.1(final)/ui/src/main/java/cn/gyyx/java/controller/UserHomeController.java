/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理主页
-------------------------------------------------------------------------*/

package cn.gyyx.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理系统主页
 * @author fanyongliang
 *
 */
@Controller
public class UserHomeController {

	/**
	 * 默认主页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("msg", " ");
		return "login";
	}

}
