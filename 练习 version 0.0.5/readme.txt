version 0.0.1 
-----------------------------------------------------------
·创建SpringMVC项目
·	--cn.gyyx.java.beans
		--IUserInfo.java
		--IUserLogin.java
		--UserInfo.java
		--UserLogin.java
·	--cn.gyyx.java.controller
		--HomeController.java
		--UserRegisterController.java
·	--cn.gyyx.java.dao
		--MyBatisConnectionFactory.java
		--UserInfoDAO.java
·在resources资源目录下
	--mybatis
		--Config.xml
		--UserInfoMapper.xml
		--UserLoginMapper.xml
	--db.properties
·测试Mybatis数据库连接
	--MybatisConnectTest.java
·添加jsp页面
	--webapp
		--WEB-INF
			--views
				--error.jsp
				--home.jsp
				--login.jsp
				--regist.jsp
version 0.0.2 
-----------------------------------------------------------
·加入login的js验证
	--用户名不能为空
		--用户名的长度在3-20位之间
	--密码不能为空
		--密码的长度必须在6-20位之间
·加入regist的js验证
	--用户名不能为空
		--用户名的长度在3-20位之间
	--密码不能为空
		--密码的长度必须在6-20位之间
	--重复密码不能为空
		--重复密码必须和密码相同
version 0.0.3 
-----------------------------------------------------------
·	--cn.gyyx.java.beans
		--UserInfo.java
·	--cn.gyyx.java.bll
		--ChangePasswordService.java
·	--cn.gyyx.java.controller
		--HomeController.java
		--UserRegisterController.java
·	--cn.gyyx.java.dao
		--UserInfoDAO.java
·	--cn.gyyx.java.service
		--UserInfoService.java
·	--cn.gyyx.java.util
·		--MyBatisConnectionFactory.java
·删除Mybatis的Mapper映射文件UserLoginMapper.xml
·修改实体类UserInfo.java
	--private int info_id;
	--private String info_account;
	--private String info_password;
	--private String info_name;
	--private String info_gender;
	--private String info_card;
	--private String info_phone;
	--private String info_email;
	--private String info_question;
	--private String info_answer;
·修改注册页面信息，注册信息内容增加，并添加相应的js验证

version 0.0.4 
-----------------------------------------------------------
·添加JSTL标准标签库C标签
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
·在list页面使用c标签的forEach来对找到的数据遍历显示
	<c:forEach var="user" items="${users}"></c:forEach>
·编号user.info_id
·姓名user.info_name
·性别user.info_gender
·电话user.info_phone
·邮箱user.info_email
	<tr class="row1">
		<td>${user.info_id}</td>
		<td>${user.info_name}</td>
		<td>${user.info_gender}</td>
		<td>${user.info_phone}</td>
		<td>${user.info_email}</td>
	</tr>
·使用c:forEach取代java代码块的for循环

version 0.0.5 
-----------------------------------------------------------
·	--cn.gyyx.java.beans
		--UserInfo.java
		--UserLogin.java
·	--cn.gyyx.java.bll
		--ChangePasswordService.java
·	--cn.gyyx.java.controller
		--HomeController.java
		--UserRegisterController.java
		--UserLoginController.java
·	--cn.gyyx.java.dao
		--UserInfoDAO.java
·	--cn.gyyx.java.service
		--UserInfoService.java
·	--cn.gyyx.java.util
·添加注册时用户名验证，用户名重复时会跳转到注册页面，用户名、密码、重复密码的内容会清空，其他信息的内容保留。
·注册成功后返回登录页面。
·增加实体类UserLogin
·增加用户登录验证，对输入的密码+seed进行MD5加密，与数据库中的密码做比较，用户名不存在时会跳转到登录页面，用户名不为空且密码相符会跳转到list页面
·list页面增加一栏card内容，显示用户的身份证号码
·list页面增加一栏account内容，显示用户的账号信息
·修改info_id属性类型为Integer
·注册界面添加返回登录界面链接