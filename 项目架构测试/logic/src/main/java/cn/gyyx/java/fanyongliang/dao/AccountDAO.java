/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月17日 下午1:45:27
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 账号数据访问接口
-------------------------------------------------------------------------*/

package cn.gyyx.java.fanyongliang.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.java.fanyongliang.beans.UserInfo;

public class AccountDAO {
	private SqlSessionFactory sqlSessionFactory;

	public AccountDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	/**
	 * 使用账号查询用户数据
	 * @param account
	 * @return UserInfo
	 */
	public UserInfo getUserInfo(String account) {
		SqlSession session = sqlSessionFactory.openSession();
		//session.getConfiguration().addMapper(IUser.class);
		try {
			IUser userDAO = session.getMapper(IUser.class);
			return userDAO.selectByAccount(account);
		} finally {
			session.close();
		}
	}

}
