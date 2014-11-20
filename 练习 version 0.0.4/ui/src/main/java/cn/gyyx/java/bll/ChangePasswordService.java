package cn.gyyx.java.bll;

import cn.gyyx.core.utility.MD5;

public class ChangePasswordService {
	public static String changePassword(String password) {
		String seed = "@gyyx";
		String newPassword = MD5.encode(password) + seed;
		return MD5.encode(newPassword);
	}
}
