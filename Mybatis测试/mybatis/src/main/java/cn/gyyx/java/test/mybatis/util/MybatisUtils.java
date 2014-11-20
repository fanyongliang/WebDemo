package cn.gyyx.java.test.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.gyyx.java.test.mybatis.test1.UserTest;

public class MybatisUtils {

	public static SqlSessionFactory getSessionFactory() {
		String resource = "conf.xml";
		// 加载 mybatis 的配置文件（它也加载关联的映射文件）
		InputStream is = UserTest.class.getClassLoader().getResourceAsStream(
				resource);
		// 构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		return sessionFactory;
	}
}
