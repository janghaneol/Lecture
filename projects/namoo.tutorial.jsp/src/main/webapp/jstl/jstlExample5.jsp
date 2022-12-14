<%@page import="namoo.user.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//서블릿 영역의 코드라 가정
List<String> teams = new ArrayList<String>();
teams.add("두산");
teams.add("롯데");
teams.add("기아");
teams.add("넥센");
teams.add("삼성");
teams.add("한화");

List<User> userList = new ArrayList<User>();
userList.add(new User("bangry", "1234", "김기정", "bangry@naver.com"));
userList.add(new User("bangry2", "1234", "김기정", "bangry@naver.com"));
userList.add(new User("bangry3", "1234", "김기정", "bangry@naver.com"));
userList.add(new User("bangry4", "1234", "김기정", "bangry@naver.com"));
userList.add(new User("bangry5", "1234", "김기정", "bangry@naver.com"));

request.setAttribute("teams", teams);
request.setAttribute("userList", userList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<table border="1">
<c:forEach var="i" begin="1" end="9">
	<tr>
	<c:forEach var="j" begin="2" end="9">
			<td>${j} * ${i} = ${j*i}</td> 
	</c:forEach>
	</tr>
</c:forEach>
</table>
<c:forEach var="k" begin="1" end="5" step="2">
	${k}
</c:forEach>
<br>
<br>

<select id="teams">
	<c:forEach var="team" items="${teams}">
	<option>${team}</option>
	</c:forEach>
</select>

<table border="1">
	<c:forEach var="user" items="${userList}" varStatus="info">
	<tr>
		<td>${info.count}</td>
		<td>${user.id}</td>
		<td>${user.password}</td>
		<td>${user.name}</td>
		<td>${user.email}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>