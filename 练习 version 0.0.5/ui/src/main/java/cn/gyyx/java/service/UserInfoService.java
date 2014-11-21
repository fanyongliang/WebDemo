/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
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
	 * 查询用户数据
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
