/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 声明对用户信息录入和查询的方法
-------------------------------------------------------------------------*/

package cn.gyyx.java.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.dao.MyBatisConnectionFactory;
import cn.gyyx.java.dao.UserInfoDAO;

public class UserInfoService {
	/**
	 * 声明一个SqlSessionFactory用于接收工厂方法创建的SqlSessionFactory
	 */
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 构造方法，获取工厂方法获取的SqlSessionFactory
	 */
	public UserInfoService() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	/**
	 * 将用户信息录入到数据库中，返回一个Integer值，用于记录录入的数量
	 * @param userInfo
	 * @return
	 */
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
	 * 根据用户账号查询数据库中的记录，返回一个用户实体
	 * @param info_account
	 * @return
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
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<UserInfo> selectAllUsers() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.selectAllUsers();
		} finally {
			session.close();
		}
	}
	/**
	 * 根据关键字查询数据库返回一个List集合
	 * @param key
	 * @return
	 */
	public List<UserInfo> selectByKey(String key) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.selectByKey(key);
		} finally {
			session.close();
		}
	}
	/**
	 * 根据页码查询匹配的用户数据，返回一个List集合
	 * @param page
	 * @return
	 */
	public List<UserInfo> selectByPage(int page) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.selectByPage(page);
		} finally {
			session.close();
		}
	}
	/**
	 * 查询数据库中所有记录的总条数
	 * @return
	 */
	public Integer selectCount() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInfoDAO dao = session.getMapper(UserInfoDAO.class);
			return dao.selectCount();
		} finally {
			session.close();
		}
	}

}
