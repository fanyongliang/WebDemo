/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 用户信息的接口类
-------------------------------------------------------------------------*/

package cn.gyyx.java.dao;

import java.util.List;

import cn.gyyx.java.beans.UserInfo;

public interface UserInfoDAO {
	/**
	 * 增加新用户
	 * @param userInfo
	 * @return
	 */
	public int add(UserInfo userInfo);
	/**
	 * 根据用户名删除用户
	 * @param info_id
	 * @return
	 */
	public Integer deleteByAccount(String info_account);

	public Integer update(UserInfo userInfo);

	public UserInfo selectByAccount(String info_account);

	public List<UserInfo> selectAllUsers();
	
	public List<UserInfo> selectByKey(String key);
}
