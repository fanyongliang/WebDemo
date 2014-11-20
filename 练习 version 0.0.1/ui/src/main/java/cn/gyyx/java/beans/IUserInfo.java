/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 用户信息的接口类
-------------------------------------------------------------------------*/

package cn.gyyx.java.beans;

import java.util.List;

public interface IUserInfo {
	/*
	 * 声明添加用户信息方法
	 */
	public int add(UserInfo userInfo);

	public int deleteById(int info_id);

	public int update(UserInfo userInfo);

	public UserInfo selectById(int info_id);

	public List<UserInfo> selectAllUsers();
}
