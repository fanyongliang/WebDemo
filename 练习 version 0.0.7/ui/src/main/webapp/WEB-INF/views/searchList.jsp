<%@ page language="java"
	import="java.util.*,cn.gyyx.java.beans.*,cn.gyyx.java.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>主页</title>
<link rel="stylesheet" type="text/css"
	href="/java/resources/css/style.css" />
<script type="text/javascript">
function search(){
	var keyword = document.getElementById("key").value;
	if(keyword == ""){
		alert("请输入要查找的内容！");
	}else{
		window.location.href ='<%=application.getContextPath()%>/Search/find/' + keyword;
	}
}
</script>
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
				<h1>已查询到的结果</h1>
				<div align="right">
					请输入关键字查询 <input id="key" type="text" class="inputgri" name="search" />
					<input type="button" class="button" value="Go &raquo;"
						onclick="search()" />
				</div>
				<br />
				<table border="1" class="table">
					<tr class="table_header">
						<td>编号</td>
						<td>账号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>身份证</td>
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
						<td><%=user.getInfo_name()%></td>
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

					<c:forEach var="user" items="${users}">
						<tr class="row1">
							<td>${user.info_id}</td>
							<td>${user.info_account}</td>
							<td>${user.info_name}</td>
							<td>${user.info_gender}</td>
							<td>${user.info_card}</td>
							<td>${user.info_phone}</td>
							<td>${user.info_email}</td>
							<td><a href="#" onclick="">详细信息</a></td>
						</tr>
					</c:forEach>
				</table>
				<p><a href="javascript:history.go(-1)" >返回主页</a>
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">FanYongliang@gyyx.cn</div>
		</div>
	</div>

</body>
</html>
