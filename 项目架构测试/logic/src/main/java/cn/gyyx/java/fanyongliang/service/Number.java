/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月17日 上午11:39:54
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/

package cn.gyyx.java.fanyongliang.service;

import cn.gyyx.core.utility.MD5;

public class Number {

	/**
	 * 	
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a, int b) {
		return a+b;
	}
	
	/**
	 * 
	 * @param md
	 * @return
	 */
	public String toMd5(String md){
		return MD5.encode(md);
	}
}
