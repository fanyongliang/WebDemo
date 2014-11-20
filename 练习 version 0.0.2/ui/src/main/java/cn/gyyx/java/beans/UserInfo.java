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

public class UserInfo {
	private int info_id;
	private String info_nickname;
	private String info_gender;
	private String info_phone;
	private String info_email;
	private String info_question;
	private String info_answer;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int info_id, String info_nickname, String info_gender,
			String info_phone, String info_email, String info_question,
			String info_answer) {
		super();
		this.info_id = info_id;
		this.info_nickname = info_nickname;
		this.info_gender = info_gender;
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

	public String getInfo_nickname() {
		return info_nickname;
	}

	public void setInfo_nickname(String info_nickname) {
		this.info_nickname = info_nickname;
	}

	public String getInfo_gender() {
		return info_gender;
	}

	public void setInfo_gender(String info_gender) {
		this.info_gender = info_gender;
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
		return "UserInfo [info_id=" + info_id + ", info_nickname="
				+ info_nickname + ", info_gender=" + info_gender
				+ ", info_phone=" + info_phone + ", info_email=" + info_email
				+ ", info_question=" + info_question + ", info_answer="
				+ info_answer + "]";
	}

}
