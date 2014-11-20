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

public class UserInfo {
	private int info_id;
	private String info_account;
	private String info_password;
	private String info_name;
	private String info_gender;
	private String info_card;
	private String info_phone;
	private String info_email;
	private String info_question;
	private String info_answer;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int info_id, String info_account, String info_password,
			String info_name, String info_gender, String info_card,
			String info_phone, String info_email, String info_question,
			String info_answer) {
		super();
		this.info_id = info_id;
		this.info_account = info_account;
		this.info_password = info_password;
		this.info_name = info_name;
		this.info_gender = info_gender;
		this.info_card = info_card;
		this.info_phone = info_phone;
		this.info_email = info_email;
		this.info_question = info_question;
		this.info_answer = info_answer;
	}

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public String getInfo_account() {
		return info_account;
	}

	public void setInfo_account(String info_account) {
		this.info_account = info_account;
	}

	public String getInfo_password() {
		return info_password;
	}

	public void setInfo_password(String info_password) {
		this.info_password = info_password;
	}

	public String getInfo_name() {
		return info_name;
	}

	public void setInfo_name(String info_name) {
		this.info_name = info_name;
	}

	public String getInfo_gender() {
		return info_gender;
	}

	public void setInfo_gender(String info_gender) {
		this.info_gender = info_gender;
	}

	public String getInfo_card() {
		return info_card;
	}

	public void setInfo_card(String info_card) {
		this.info_card = info_card;
	}

	public String getInfo_phone() {
		return info_phone;
	}

	public void setInfo_phone(String info_phone) {
		this.info_phone = info_phone;
	}

	public String getInfo_email() {
		return info_email;
	}

	public void setInfo_email(String info_email) {
		this.info_email = info_email;
	}

	public String getInfo_question() {
		return info_question;
	}

	public void setInfo_question(String info_question) {
		this.info_question = info_question;
	}

	public String getInfo_answer() {
		return info_answer;
	}

	public void setInfo_answer(String info_answer) {
		this.info_answer = info_answer;
	}

	@Override
	public String toString() {
		return "UserInfo [info_id=" + info_id + ", info_account="
				+ info_account + ", info_password=" + info_password
				+ ", info_name=" + info_name + ", info_gender=" + info_gender
				+ ", info_card=" + info_card + ", info_phone=" + info_phone
				+ ", info_email=" + info_email + ", info_question="
				+ info_question + ", info_answer=" + info_answer + "]";
	}

}
