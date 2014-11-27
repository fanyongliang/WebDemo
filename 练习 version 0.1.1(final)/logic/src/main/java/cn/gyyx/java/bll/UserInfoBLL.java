/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 简单的业务逻辑，与数据库的交互
-------------------------------------------------------------------------*/

package cn.gyyx.java.bll;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import cn.gyyx.java.beans.UserInfo;
import cn.gyyx.java.dao.UserInfoDAO;

/**
 * 简单的验证，实现与UserDAO的交互
 * @author fanyongliang
 *
 */
public class UserInfoBLL {
	/**
	 * 实例化
	 */
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private static UserInfoBLL userInfoBLL = new UserInfoBLL();
	private MD5BLL md5 = new MD5BLL();

	/**
	 * 注册时检查用户名是否存在
	 * @param info_account
	 * @return
	 */
	public Boolean checkRegisterAccount(String info_account) {
		if (userInfoBLL.getUserInfoBySelect(info_account) == null) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 登录时检查用户名或密码是否正确
	 * @param userLogin_account
	 * @param userLogin_password
	 * @return
	 */
	public Boolean checkLoginAccount(String userLogin_account,
			String userLogin_password) {
		UserInfo checkAccount = userInfoBLL
				.getUserInfoBySelect(userLogin_account);
		String newPassword = md5.changePassword(userLogin_password);
		if (checkAccount != null
				&& checkAccount.getInfo_password().equals(newPassword)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 添加Memcache，保存用户信息到Memcache中
	 * @param key
	 * @param users
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 */
	public void setMem(String key, List<UserInfo> users) throws IOException,
			TimeoutException, InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				"127.0.0.1:11211");
		MemcachedClient client = builder.build();
		client.set(key, 0, users);
	}
	/**
	 * 验证Memcache，从Memcache中查询数据
	 * @param value
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 */
	public Object getMem(String value) throws IOException, TimeoutException,
			InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				"127.0.0.1:11211");
		MemcachedClient client = builder.build();
		return client.get(value);
	}

	/**
	 * 添加用户到数据库中，并对密码MD5加密
	 * @param userInfo
	 * @return
	 */
	public Integer addUserInfo(UserInfo userInfo) {
		String password = md5.changePassword(userInfo.getInfo_password());
		userInfo.setInfo_password(password);
		int num = userInfoDAO.add(userInfo);
		return num;
	}
	/**
	 * 返回通过关键字查到的所有用户信息
	 * @param key
	 * @return
	 */
	public List<UserInfo> getUserInfoByKey(String key) {
		return userInfoDAO.selectByKey(key);
	}
	/**
	 * 返回通过分页查到的所有用户信息
	 * @param page
	 * @return
	 */
	public List<UserInfo> getUserInfoByPage(int page) {
		return userInfoDAO.selectByPage(page);
	}
	/**
	 * 返回所有用户信息数
	 * @return
	 */
	public Integer getSelectCount() {
		return userInfoDAO.selectCount();
	}
	/**
	 * 返回通过用户名查找到的用户信息
	 * @param info_account
	 * @return
	 */
	public UserInfo getUserInfoBySelect(String info_account) {
		return userInfoDAO.selectByAccount(info_account);
	}
	/**
	 * 返回所有的用户信息
	 * @return
	 */
	public List<UserInfo> getSelectAll() {
		return userInfoDAO.selectAllUsers();
	}
}
