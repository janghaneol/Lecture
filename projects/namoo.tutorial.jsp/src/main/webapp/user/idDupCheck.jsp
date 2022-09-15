<%@page import="java.util.Map"%>
<%@page import="namoo.common.factory.JdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
BufferedReader in = request.getReader();
Gson gson = new Gson();
User user = gson.fromJson(in, User.class);
User responUser = JdbcDaoFactory.getInstance().getUserDao().read(user.getId());


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

</body>
</html>