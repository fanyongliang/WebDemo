/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * 
-------------------------------------------------------------------------*/

package cn.gyyx.java.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.beans.IUserInfo;

public class UserInfoDAO {
	private SqlSessionFactory sqlSessionFactory;

	public UserInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	/**
	 * ��ѯ�û�����
	 * @param account
	 * @return UserInfo
	 */
	public UserInfo selectById(int info_id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserInfo dao = session.getMapper(IUserInfo.class);
			return dao.selectById(info_id);
		} finally {
			session.close();
		}
	}

}
