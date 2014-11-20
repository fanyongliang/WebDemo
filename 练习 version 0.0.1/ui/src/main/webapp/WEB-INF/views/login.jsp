<%@ page language="java"
	import="java.util.*,cn.gyyx.java.beans.*,cn.gyyx.java.dao.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="/java/resources/css/style.css" />
</head>

<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2014/11/18 <br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">FanYongliang</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>登录</h1>
				<form action="" method="post" onSubmit="return regs('click')">
					<table class="form_table">
						<tr>
							<td valign="middle" align="right">用户名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="user_account" /></td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="user_password" /></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Submit &raquo;" /> <a
							href="Register/show">注册</a>
					</p>
				</form>

			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">FanYongliang@gyyx.cn</div>
		</div>
	</div>
</body>
</html>
