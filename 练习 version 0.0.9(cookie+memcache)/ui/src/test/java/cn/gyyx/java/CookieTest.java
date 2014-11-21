/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 测试Cookies的类
-------------------------------------------------------------------------*/
package cn.gyyx.java;

import org.junit.Test;
import javax.servlet.http.Cookie;

public class CookieTest {
	@Test
	public void createCookie() {
		String account = "admin";
		Cookie cAccount = new Cookie("account", account);
		cAccount.setMaxAge(10); 
		System.out.println(cAccount);
		
	}
}
