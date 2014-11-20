/*------------------------------------------------------------------------- 
 * ��Ȩ���У������������߿Ƽ��������ι�˾ 
 * ���ߣ�fanyongliang
 * ��ϵ��ʽ��fanyongliang@gyyx.cn 
 * ����ʱ�䣺 2014��11��17�� ����1:27:06
 * �汾�ţ�v1.0 
 * ������Ҫ��;������ 
 * Mybatis���ݿ����ӹ�����
-------------------------------------------------------------------------*/

package cn.gyyx.java.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlAccountSessionFactory;
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
	 * ��ȡ���ݿ⹤��ʵ��
	 * @return ����ʵ��
	 */
	public static SqlSessionFactory getSqlAccountSessionFactory(){
		return sqlAccountSessionFactory;
	}
}
