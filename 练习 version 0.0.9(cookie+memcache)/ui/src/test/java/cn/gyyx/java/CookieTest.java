/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * ����Cookies����
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
