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
