/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
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
