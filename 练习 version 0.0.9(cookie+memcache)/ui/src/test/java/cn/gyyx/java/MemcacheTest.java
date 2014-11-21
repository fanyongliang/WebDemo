package cn.gyyx.java;

import java.io.IOException;

import org.junit.Test;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;

public class MemcacheTest {
	 /** 
     * ��һ���Ǵ洢��key���ƣ� 
     * �ڶ�����expireʱ�䣨��λ�룩���������ʱ��,memcached����������滻��ȥ��0��ʾ���ô洢��Ĭ����һ����) 
     * ��������������ʵ�ʴ洢������ 
     */ 
	@Test
	public void memTest() throws IOException{
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				"127.0.0.1:11211");
		try {
			MemcachedClient client = builder.build();
			client.set("uuid", 0, "123456");
			String value = client.get("uuid");
			System.out.println("-Start-");
			System.out.println(value);
			client.delete("uuid");
			value = client.get("uuid");
			System.out.println(value);
			System.out.println("-End-");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
