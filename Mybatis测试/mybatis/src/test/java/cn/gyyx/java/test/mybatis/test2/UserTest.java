package cn.gyyx.java.test.mybatis.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.gyyx.java.test.mybatis.entity.User;
import cn.gyyx.java.test.mybatis.util.MybatisUtils;

public class UserTest {
	//@Test
	public void testInsert() {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "cn.gyyx.java.test.mybatis.test2.userMapper.addUser";
		int insert = session.insert(statement, new User(-1,"李四", 22));
		session.commit();
		session.close();
		System.out.println(insert);
	}
	//@Test
	public void testUpdate(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "cn.gyyx.java.test.mybatis.test2.userMapper.updateUser";
		int update = session.update(statement, new User(2,"王五",80));
		session.close();
		System.out.println(update);
	}
	@Test
	public void testSelectAllUsers(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "cn.gyyx.java.test.mybatis.test2.userMapper.getAllUser";
		List<User> list = session.selectList(statement);
		session.close();
		System.out.println(list);
	}
}
