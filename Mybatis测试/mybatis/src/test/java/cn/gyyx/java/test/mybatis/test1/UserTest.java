package cn.gyyx.java.test.mybatis.test1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.gyyx.java.test.mybatis.entity.User;
import cn.gyyx.java.test.mybatis.util.MybatisUtils;

public class UserTest {
	@Test
	public void getUser() {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		// 映射 sql 的标识字符串
		String statement = "cn.gyyx.java.test.mybatis.test1.userMapper"
				+ ".getUser";
		// 执行查询返回一个唯一 user 对象的 sql
		User user = session.selectOne(statement, 1);
		session.close();
		System.out.println(user);
	}
}