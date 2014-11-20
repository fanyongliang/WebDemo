package cn.gyyx.text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("/test1")
	public String test1(HttpServletRequest request) {
		String name = request.getParameter("name");
		logger.info("test1 name:" + name);
		return "home";
	}

	@RequestMapping("/test2")
	public String test2(String name, Date birthDate) {
		logger.info("test2 birthDate:" + birthDate);
		return "home";
	}

	@RequestMapping("/test3")
	public String test3(UserBean user) {
		logger.info(user.toString());
		return "home";
	}

	@RequestMapping("/test4")
	public String test4(String[] name) {
		for (String n : name) {
			logger.info(n);
		}
		return "home";
	}
	/* ---------------------------------------- */
	@RequestMapping("/test5")
	@ResponseBody
	public UserBean test5(HttpServletResponse response) {
		UserBean user = new UserBean();
		user.setAge(17);
		response.setStatus(202);
		return user;
	}
	/* ---------------------------------------- */
	@RequestMapping("/test6")
	public ModelAndView test6() {
		UserBean user = new UserBean();
		user.setAge(17);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("u", user);
		return new ModelAndView("home", map);
	}
	
	@RequestMapping("/test7")
	public String test7(Map<String, Object> map) {
		UserBean user = new UserBean();
		user.setAge(17);
		map.put("u", user);
		return "home";
	}
	
	@RequestMapping("/test8")
	public String test8(Model model){
		UserBean user = new UserBean();
		user.setAge(17);
		model.addAttribute("u",user);
		return "home";
	}
	/* ---------------------------------------- */
	@RequestMapping("/test9")
	public String test9(){
		return "redirect:http://www.gyyx.cn";
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-mm-dd"), true));
	}
}
