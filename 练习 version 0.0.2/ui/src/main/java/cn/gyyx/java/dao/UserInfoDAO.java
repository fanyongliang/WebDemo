/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
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
	 * 查询用户数据
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
