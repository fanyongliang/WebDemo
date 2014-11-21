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