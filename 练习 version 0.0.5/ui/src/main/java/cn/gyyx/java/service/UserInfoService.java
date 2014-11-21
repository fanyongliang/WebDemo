/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * 
-------------------------------------------------------------------------*/

package cn.gyyx.java.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.dao.UserInfoDAO;
import cn.gyyx.java.util.MyBatisConnectionFactory;

public class UserInfoService {
	private SqlSessionFactory sqlSessionFactory;

	public UserInfoService() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	
	public Integer add(UserInfo userInfo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.add(userInfo);
		} finally {
			session.commit();
			session.close();
		}
	}

	/**
	 * ��ѯ�û�����
	 * 
	 * @param account
	 * @return UserInfo
	 */
	public UserInfo selectByAccount(String info_account) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.selectByAccount(info_account);
		} finally {
			session.close();
		}
	}
	public List<UserInfo> selectAllUsers() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.selectAllUsers();
		} finally {
			session.close();
		}
	}

}
