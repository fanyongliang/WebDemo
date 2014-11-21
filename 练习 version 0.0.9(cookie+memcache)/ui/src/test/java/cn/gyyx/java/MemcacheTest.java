package cn.gyyx.java;

import java.io.IOException;

import org.junit.Test;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;

public class MemcacheTest {
	 /** 
     * 第一个是存储的key名称， 
     * 第二个是expire时间（单位秒），超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月) 
     * 第三个参数就是实际存储的数据 
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
