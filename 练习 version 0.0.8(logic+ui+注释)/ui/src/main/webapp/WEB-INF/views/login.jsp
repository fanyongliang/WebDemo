<%@ page language="java"
	import="java.util.*,cn.gyyx.java.beans.*,cn.gyyx.java.dao.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>登录页面</title>
<link rel="stylesheet" type="text/css"
	href="/java/resources/css/style.css" />
<script>
	function regs(click) {
		var user_account = document.getElementsByName("user_account")[0];
		var user_password = document.getElementsByName("user_password")[0];
		var tip1 = gspan(user_account);
		var tip2 = gspan(user_password);
		//获得焦点时 提示
		user_account.onfocus = function() {
			this.select();
			tip1.innerHTML = "&nbsp;用户名的长度在3-20位之间";
			tip1.className = "tips1";
		};//其中select函数表示获得焦点时 全选文本
		user_password.onfocus = function() {
			this.select();
			tip2.innerHTML = "&nbsp;密码的长度必须在6-20位之间";
			tip2.className = "tips1";
		};
		user_account.onblur = function() {
			var val = this.value;
			if (val.length >= 3 && val.length <= 20) {
				tip1.innerHTML = "&nbsp;√";
				tip1.className = "tips3";
				return true;
			} else {
				tip1.className = "tips2";
				return false;
			}
		};
		user_password.onblur = function() {
			var val = this.value;
			if (val.length >= 6 && val.length <= 20) {
				tip2.innerHTML = "&nbsp;√";
				tip2.className = "tips3";
				return true;
			} else {
				tip2.className = "tips2";
				return false;
			}
		};
		if (click == "click") {
			user_account.onblur();
			user_password.onblur();
			if (user_account.onblur() && user_password.onblur()) {
				return true;
			} else {
				return false;
			}
		}

	}
	//获取obj后面元素span 用来提示信息；
	function gspan(obj) {
		if (obj.nextSibling.nodeName != "SPAN") {
			gspan(obj.nextSibling);
		} else {
			return obj.nextSibling;
		}
	}
	onload = regs;//页面加载完发生（或者执行）
</script>
<style>
span {
	font-size: 14px
}

.tips {
	color: #999999
}

.tips1 {
	color: #0000FF
}

.tips2 {
	color: red
}

.tips3 {
	color: green
}
</style>
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
				<form action="/java/Login/pass" method="post" onSubmit="return regs('click')">
					<table class="form_table">
						<tr>
							<td valign="middle" align="right">用户名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="user_account" /><span class="tips">&nbsp;用户名不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right"></td>
							<td valign="middle" align="left"><span class="tips2">${msg}</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="user_password" /><span class="tips">&nbsp;密码不能为空</span></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Submit &raquo;" /> <a
							href="/java/Register/show">注册</a>
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
