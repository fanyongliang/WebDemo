/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/

package cn.gyyx.java.beans;

public class UserLogin {
	private int user_id;
	private String user_account;
	private String user_password;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(int user_id, String user_account, String user_password) {
		super();
		this.user_id = user_id;
		this.user_account = user_account;
		this.user_password = user_password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

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
		return "UserLogin [user_id=" + user_id + ", user_account="
				+ user_account + ", user_password=" + user_password + "]";
	}

}
