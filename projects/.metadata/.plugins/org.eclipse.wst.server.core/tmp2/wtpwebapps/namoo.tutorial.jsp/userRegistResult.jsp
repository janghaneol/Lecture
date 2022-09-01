<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.yorizori.dto.user.User" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>회원 가입을 축하합니다. 가입 결과는 아래와 같습니다</h2>
<ul>
	<li> 이름 : <jsp:getProperty property="name" name="user" /></li>
	<li> 아이디 : <jsp:getProperty property="id" name="user" /></li>
	<li> 이메일 : <jsp:getProperty property="email" name="user" /></li>
</ul>

</body>
</html>