/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 密码加密
-------------------------------------------------------------------------*/
package cn.gyyx.java.bll;

import cn.gyyx.core.utility.MD5;

/**
 * 密码加密实现类
 * @author fanyongliang
 *
 */
public class MD5BLL {
	/**
	 * 实现对传来的密码进行MD5加密
	 * 
	 * @param password
	 * @return
	 */
	public String changePassword(String password) {
		String seed = "@gyyx";
		String newPassword = MD5.encode(password) + seed;
		return MD5.encode(newPassword);
	}
}
