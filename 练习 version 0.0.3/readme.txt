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