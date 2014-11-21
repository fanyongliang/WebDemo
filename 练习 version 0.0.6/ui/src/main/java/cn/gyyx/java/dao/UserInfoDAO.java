/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * �û���Ϣ�Ľӿ���
-------------------------------------------------------------------------*/

package cn.gyyx.java.dao;

import java.util.List;

import cn.gyyx.java.beans.UserInfo;

public interface UserInfoDAO {
	/**
	 * �������û�
	 * @param userInfo
	 * @return
	 */
	public int add(UserInfo userInfo);
	/**
	 * �����û���ɾ���û�
	 * @param info_id
	 * @return
	 */
	public Integer deleteByAccount(String info_account);

	public Integer update(UserInfo userInfo);

	public UserInfo selectByAccount(String info_account);

	public List<UserInfo> selectAllUsers();
	
	public List<UserInfo> selectByKey(String key);
}
