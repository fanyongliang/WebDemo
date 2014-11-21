/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 用户登录信息实体类
-------------------------------------------------------------------------*/
package cn.gyyx.java.beans;

import java.io.Serializable;

public class UserLogin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4256290853335313756L;
	/**
	 * 用户登录信息
	 * user_account 登录账号
	 * user_password 登录密码
	 */
	private String user_account;
	private String user_password;
	/**
	 * 有参数、无参数构造方法
	 */
	public UserLogin() {
		super();
	}
	public UserLogin(String user_account, String user_password) {
		super();
		this.user_account = user_account;
		this.user_password = user_password;
	}
	/**
	 * Get Set 方法
	 * @return
	 */
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "UserLogin [user_account=" + user_account + ", user_password="
				+ user_password + "]";
	}
	
}
