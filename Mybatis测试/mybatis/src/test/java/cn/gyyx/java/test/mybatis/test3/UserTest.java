package cn.gyyx.java.test.mybatis.test3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.gyyx.java.test.mybatis.entity.User;
import cn.gyyx.java.test.mybatis.util.MybatisUtils;

public class UserTest {
	@Test
	public void selectAllUser(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> user = userMapper.selectAllUsers();
		session.close();
		System.out.println(user);
	}
}
