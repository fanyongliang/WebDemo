<%@ page language="java"
	import="java.util.*,cn.gyyx.java.beans.*,cn.gyyx.java.dao.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'list.jsp' starting page</title>
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
				<div id="navigation">
					<p style="line-height: 0px; color: white;">&nbsp;&nbsp;欢迎你:&nbsp;${account}</p>
				</div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>Welcome!</h1>
				<div align="right">
					请输入关键字
					<input type="text" class="inputgri" name="lookingfor" />
					<input type="button" class="button" value="Go &raquo;" />
				</div>
				<br />
				<table border="1" class="table">
					<tr class="table_header">
						<td>编号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>电话</td>
						<td>邮箱</td>
						<td>操作</td>
					</tr>

					<%-- 					<%
						for (int i = 0; i < userInfo.size(); i++) {
							UserInfo user = userInfo.get(i);
					%>
					<tr class="row<%=i % 2 + 1%>">
						<td><%=user.getInfo_id()%></td>
						<td><%=user.getInfo_nickname()%></td>
						<td><%=user.getInfo_gender()%></td>
						<td><%=user.getInfo_phone()%></td>
						<td><%=user.getInfo_email()%></td>
						<td><a href="delete?id=<%=user.getInfo_id()%>"
							onclick="return confirm('确定删除?')">删除</a>&nbsp;<a
							href="update?id=<%=user.getInfo_id()%>">修改</a></td>
					</tr>
					<%
						}
					%> --%>
				</table>
				<p id="page" align="center">
					<a href="#">上一页</a>&nbsp; <a href="#">1</a>&nbsp; <a href="#">2</a>&nbsp;
					<a href="#">3</a>&nbsp; <a href="#">4</a>&nbsp; <a href="#">5</a>&nbsp;
					<a href="#">6</a>&nbsp; <a href="#">7</a>&nbsp; <a href="#">8</a>&nbsp;
					<a href="#">9</a>&nbsp; <a href="#">10</a>&nbsp; <a href="#">下一页</a>
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">FanYongliang@gyyx.cn</div>
		</div>
	</div>

</body>
</html>
