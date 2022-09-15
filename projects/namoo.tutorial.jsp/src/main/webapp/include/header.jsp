<%@page import="namoo.common.factory.JdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="/user/login.jsp"></jsp:include>

<div class="header">
	<h1>Haneol's Page</h1>
	<p>Resize the browser window to see the effect.</p>
</div>


<div class="topnav">
	<a href="/user/userList.jsp">Member List</a>
	<a href="#">Link</a> 
	<a href="#">Link</a> 
	<a href="#">Link</a> 
	<a href="/user/userRegistForm.jsp" style="float: right">회원가입</a>
</div> 
