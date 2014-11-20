/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��18�� 
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * 
-------------------------------------------------------------------------*/

package cn.gyyx.java;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.dao.UserInfoDAO;
import cn.gyyx.java.util.MyBatisConnectionFactory;

public class MybatisConnectTest {

		@Test
		public void selectAllUser(){
			SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlAccountSessionFactory();
			SqlSession session = sessionFactory.openSession();
			UserInfoDAO userMapper = session.getMapper(UserInfoDAO.class);
			List<UserInfo> userInfo = userMapper.selectAllUsers();
			session.close();
			System.out.println(userInfo);
		}
}
