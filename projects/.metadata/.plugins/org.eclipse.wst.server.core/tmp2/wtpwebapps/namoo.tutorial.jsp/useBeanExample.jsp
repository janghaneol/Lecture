<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.yorizori.dto.user.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="id" name="user" value="bangry"/>
	<jsp:setProperty property="name" name="user" value="김기정"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
아이디 : <jsp:getProperty property="id" name="user"/> <br>
이름 : <jsp:getProperty property="name" name="user"/>
</body>
</html>