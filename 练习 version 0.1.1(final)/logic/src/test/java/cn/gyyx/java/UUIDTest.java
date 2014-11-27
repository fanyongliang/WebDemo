/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * UUID测试类
-------------------------------------------------------------------------*/
package cn.gyyx.java;

import java.util.UUID;

import org.junit.Test;
/**
 * UUID测试类
 * @author fanyongliang
 *
 */
public class UUIDTest {
	/**
	 * 测试生成UUID值
	 */
	@Test
	public void test() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(uuid);
	}
}
