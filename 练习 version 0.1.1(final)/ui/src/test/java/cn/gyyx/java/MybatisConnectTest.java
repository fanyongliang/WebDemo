/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 测试Mybatis的类
-------------------------------------------------------------------------*/

package cn.gyyx.java;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.dao.MyBatisConnectionFactory;
import cn.gyyx.java.dao.IUserInfoDAO;

public class MybatisConnectTest {
		/**
		 * 测试方法selectAllUsers()
		 */
		@Test
		public void selectAllUser(){
			SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlAccountSessionFactory();
			SqlSession session = sessionFactory.openSession();
			IUserInfoDAO userMapper = session.getMapper(IUserInfoDAO.class);
			List<UserInfo> userInfo = userMapper.selectAllUsers();
			session.close();
			System.out.println(userInfo);
		}
}
