/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月17日 下午1:44:10
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 用户的数据访问
-------------------------------------------------------------------------*/

package cn.gyyx.java.fanyongliang.dao;

import cn.gyyx.java.fanyongliang.beans.UserInfo;


public interface IUser {
	/**
	 * 使用账号查询用户
	 * @param account
	 * @return
	 */
	public UserInfo selectByAccount(String account);
}
