/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * �û���Ϣ�Ľӿ���
-------------------------------------------------------------------------*/

package cn.gyyx.java.beans;

import java.util.List;

public interface IUserInfo {
	/*
	 * ��������û���Ϣ����
	 */
	public int add(UserInfo userInfo);

	public int deleteById(int info_id);

	public int update(UserInfo userInfo);

	public UserInfo selectById(int info_id);

	public List<UserInfo> selectAllUsers();
}
