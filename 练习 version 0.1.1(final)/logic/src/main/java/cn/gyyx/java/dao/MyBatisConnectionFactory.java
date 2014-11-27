/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * Mybatis创建SqlSession工厂类
-------------------------------------------------------------------------*/

package cn.gyyx.java.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * SqlSessionFactory工厂类
 * @author fanyongliang
 *
 */
public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlAccountSessionFactory;
	/**
	 * 单例
	 * 静态语句块实现创建SqlSession工厂
	 */
	static {
		try {
			String resource = "mybatis/Config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlAccountSessionFactory == null) {
				sqlAccountSessionFactory = new SqlSessionFactoryBuilder()
						.build(reader, "account");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	/**
	 * 静态方法获取创建好的SqlSession工厂
	 * @return
	 */
	public static SqlSessionFactory getSqlAccountSessionFactory(){
		return sqlAccountSessionFactory;
	}
}
