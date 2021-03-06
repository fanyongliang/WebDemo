<%@ page language="java"
	import="java.util.*,cn.gyyx.java.beans.*,cn.gyyx.java.dao.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>注册页面</title>
<link rel="stylesheet" type="text/css"
	href="/java/resources/css/style.css" />
<script>
	function regs(click) {
		var info_account = document.getElementsByName("info_account")[0];
		var info_password = document.getElementsByName("info_password")[0];
		var info_password2 = document.getElementsByName("info_password2")[0];
		var info_name = document.getElementsByName("info_name")[0];
		var info_gender = document.getElementsByName("info_gender")[0];
		var info_card = document.getElementsByName("info_card")[0];
		var info_phone = document.getElementsByName("info_phone")[0];
		var info_email = document.getElementsByName("info_email")[0];
		var info_question = document.getElementsByName("info_question")[0];
		var info_answer = document.getElementsByName("info_answer")[0];
		var tip1 = gspan(info_account);
		var tip2 = gspan(info_password);
		var tip3 = gspan(info_password2);
		var tip4 = gspan(info_name);
		var tip5 = gspan(info_gender);
		var tip6 = gspan(info_card);
		var tip7 = gspan(info_phone);
		var tip8 = gspan(info_email);
		var tip9 = gspan(info_question);
		var tip10 = gspan(info_answer);
		//获得焦点时 提示
		info_account.onfocus = function() {
			this.select();
			tip1.innerHTML = "&nbsp;用户名的长度在3-20位之间(如,admin)";
			tip1.className = "tips1";
		};//其中select函数表示获得焦点时 全选文本
		info_password.onfocus = function() {
			this.select();
			tip2.innerHTML = "&nbsp;密码的长度必须在6-20位之间(如,admin123)";
			tip2.className = "tips1";
		};
		info_password2.onfocus = function() {
			this.select();
			tip3.innerHTML = "&nbsp;重复密码必须和密码相同(如,admin123)";
			tip3.className = "tips1";
		};
		info_name.onfocus = function() {
			this.select();
			tip4.innerHTML = "&nbsp;请填写正确的用户名(如,范永良)";
			tip4.className = "tips1";
		};
		info_gender.onfocus = function() {
			this.select();
			tip5.innerHTML = "&nbsp;请填写性别(如,男)";
			tip5.className = "tips1";
		};
		info_card.onfocus = function() {
			this.select();
			tip6.innerHTML = "&nbsp;请填写正确的15位或18位身份证号(如,620121199304241414)";
			tip6.className = "tips1";
		};
		info_phone.onfocus = function() {
			this.select();
			tip7.innerHTML = "&nbsp;请填写正确的联系电话(如,13552852610)";
			tip7.className = "tips1";
		};
		info_email.onfocus = function() {
			this.select();
			tip8.innerHTML = "&nbsp;请填写正确的E-mail(如,fanyongliang@gyyx.cn)";
			tip8.className = "tips1";
		};
		info_question.onfocus = function() {
			this.select();
			tip9.innerHTML = "&nbsp;密保问题的长度必须在6-20位之间(如,最喜欢的季节是什么)";
			tip9.className = "tips1";
		};
		info_answer.onfocus = function() {
			this.select();
			tip10.innerHTML = "&nbsp;密保答案的长度必须在2-20位之间(如,冬天)";
			tip10.className = "tips1";
		};
		info_account.onblur = function() {
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
		info_password.onblur = function() {
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
		info_password2.onblur = function() {
			var val = this.value;
			if (val == info_password.value && val.length >= 6
					&& val.length <= 20) {
				tip3.innerHTML = "&nbsp;√";
				tip3.className = "tips3";
				return true;
			} else {
				tip3.className = "tips2";
				return false;
			}
		};
		info_name.onblur = function() {
			var val = this.value;
			if (val.match(/^([\u4e00-\u9fa5]+|([a-z]+\s?)+)$/)) {
				tip4.innerHTML = "&nbsp;√";
				tip4.className = "tips3";
				return true;
			} else {
				tip4.className = "tips2";
				return false;
			}
		};
		info_gender.onblur = function() {
			var val = this.value;
			if (val == "男" || val == "女") {
				tip5.innerHTML = "&nbsp;√";
				tip5.className = "tips3";
				return true;
			} else {
				tip5.className = "tips2";
				return false;
			}
		};
		info_card.onblur = function() {
			var val = this.value;
			if (val.match(/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/)) {
				tip6.innerHTML = "&nbsp;√";
				tip6.className = "tips3";
				return true;
			} else {
				tip6.className = "tips2";
				return false;
			}
		};
		info_phone.onblur = function() {
			var val = this.value;
			if (val.match(/^0?(13|15|18)[0-9]{9}$/)) {
				tip7.innerHTML = "&nbsp;√";
				tip7.className = "tips3";
				return true;
			} else {
				tip7.className = "tips2";
				return false;
			}
		};
		info_email.onblur = function() {
			var val = this.value;
			if (val
					.match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)) {
				tip8.innerHTML = "&nbsp;√";
				tip8.className = "tips3";
				return true;
			} else {
				tip8.className = "tips2";
				return false;
			}
		};
		info_question.onblur = function() {
			var val = this.value;
			if (val.length >= 6 && val.length <= 20) {
				tip9.innerHTML = "&nbsp;√";
				tip9.className = "tips3";
				return true;
			} else {
				tip9.className = "tips2";
				return false;
			}
		};
		info_answer.onblur = function() {
			var val = this.value;
			if (val.length >= 2 && val.length <= 20) {
				tip10.innerHTML = "&nbsp;√";
				tip10.className = "tips3";
				return true;
			} else {
				tip10.className = "tips2";
				return false;
			}
		};
		if (click == "click") {
			info_account.onblur();
			info_password.onblur();
			info_password2.onblur();
			info_name.onblur();
			info_gender.onblur();
			info_card.onblur();
			info_phone.onblur();
			info_email.onblur();
			info_question.onblur();
			info_answer.onblur();
			if (info_account.onblur() && info_password.onblur()
					&& info_password2.onblur() && info_name.onblur()
					&& info_gender.onblur() && info_card.onblur()
					&& info_phone.onblur() && info_email.onblur()
					&& info_question.onblur() && info_answer.onblur()) {
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
				<h1>用户注册</h1>
				<form action="/java/Register/list" method="post" onSubmit="return regs('click')">
					<table class="form_table">
						<tr>
							<td valign="middle" align="right">用户名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_account" /><span class="tips">&nbsp;用户名不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right"></td>
							<td valign="middle" align="left"><span class="tips2">${msg}</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="info_password" /><span class="tips">&nbsp;密码不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">重复密码:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="info_password2" /><span class="tips">&nbsp;重复密码不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">真实姓名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_name" value="${name}" /><span class="tips">&nbsp;真实姓名不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">性别:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_gender" value="${gender}"/><span class="tips">&nbsp;性别不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">身份证号:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_card" value="${card}"/><span class="tips">&nbsp;身份证号不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">联系电话:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_phone" value="${phone}"/><span class="tips">&nbsp;联系电话不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">邮箱地址:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_email" value="${email}"/><span class="tips">&nbsp;邮箱地址不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">密保问题:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_question" value="${question}"/><span class="tips">&nbsp;密保问题不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">密保答案:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="info_answer" value="${answer}"/><span class="tips">&nbsp;密保答案不能为空</span></td>
						</tr>
						<tr>
							<td valign="middle" align="right"></td>
							<td valign="middle" align="left"><input type="checkbox"
								class="inputgri" name="check" checked="checked" /> 已经阅读用户注册协议</td>
						</tr>

					</table>
					<p>
						<input type="submit" class="button" value="Submit &raquo;" />
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
