<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.user.dto.User" scope="session"/>
<!-- useBean의 scope를 session으로 설정하면 다른 브라우저에서도 접근이 가능하다. -->
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