<%@page import="namoo.common.factory.JdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- 기존의 방식일 경우 -->
<%
request.setCharacterEncoding("utf-8");
//String id =	request.getParameter("id");
//String id = request.getParameter("passwd");
//String id = request.getParameter("passwd");
//String id = request.getParameter("passwd");

//User user = new User();
//user.setId(id);
//user.setId(id);
//user.setId(id);
//user.setId(id);
//request.setAttribute("user", user);
%>
<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
	<%--  useBean의 막강한 기능
	<jsp:setProperty name="user" property="id" param="id" />
	<jsp:setProperty name="user" property="name" param="name" />
	<jsp:setProperty name="user" property="passwd" param="passwd" />
	<jsp:setProperty name="user" property="email" param="email" />
	--%>
	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>

<%
JdbcDaoFactory.getInstance().getUserDao().create(user);
%>
<jsp:forward page="userRegistResult.jsp"/>