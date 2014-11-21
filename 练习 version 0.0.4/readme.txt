version 0.0.1 
-----------------------------------------------------------
������SpringMVC��Ŀ
��	--cn.gyyx.java.beans
		--IUserInfo.java
		--IUserLogin.java
		--UserInfo.java
		--UserLogin.java
��	--cn.gyyx.java.controller
		--HomeController.java
		--UserRegisterController.java
��	--cn.gyyx.java.dao
		--MyBatisConnectionFactory.java
		--UserInfoDAO.java
����resources��ԴĿ¼��
	--mybatis
		--Config.xml
		--UserInfoMapper.xml
		--UserLoginMapper.xml
	--db.properties
������Mybatis���ݿ�����
	--MybatisConnectTest.java
�����jspҳ��
	--webapp
		--WEB-INF
			--views
				--error.jsp
				--home.jsp
				--login.jsp
				--regist.jsp
version 0.0.2 
-----------------------------------------------------------
������login��js��֤
	--�û�������Ϊ��
		--�û����ĳ�����3-20λ֮��
	--���벻��Ϊ��
		--����ĳ��ȱ�����6-20λ֮��
������regist��js��֤
	--�û�������Ϊ��
		--�û����ĳ�����3-20λ֮��
	--���벻��Ϊ��
		--����ĳ��ȱ�����6-20λ֮��
	--�ظ����벻��Ϊ��
		--�ظ���������������ͬ
version 0.0.3 
-----------------------------------------------------------
��	--cn.gyyx.java.beans
		--UserInfo.java
��	--cn.gyyx.java.bll
		--ChangePasswordService.java
��	--cn.gyyx.java.controller
		--HomeController.java
		--UserRegisterController.java
��	--cn.gyyx.java.dao
		--UserInfoDAO.java
��	--cn.gyyx.java.service
		--UserInfoService.java
��	--cn.gyyx.java.util
��		--MyBatisConnectionFactory.java
��ɾ��Mybatis��Mapperӳ���ļ�UserLoginMapper.xml
���޸�ʵ����UserInfo.java
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
���޸�ע��ҳ����Ϣ��ע����Ϣ�������ӣ��������Ӧ��js��֤

version 0.0.4 
-----------------------------------------------------------
�����JSTL��׼��ǩ��C��ǩ
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
����listҳ��ʹ��c��ǩ��forEach�����ҵ������ݱ�����ʾ
	<c:forEach var="user" items="${users}"></c:forEach>
�����user.info_id
������user.info_name
���Ա�user.info_gender
���绰user.info_phone
������user.info_email
	<tr class="row1">
		<td>${user.info_id}</td>
		<td>${user.info_name}</td>
		<td>${user.info_gender}</td>
		<td>${user.info_phone}</td>
		<td>${user.info_email}</td>
	</tr>
��ʹ��c:forEachȡ��java������forѭ��
