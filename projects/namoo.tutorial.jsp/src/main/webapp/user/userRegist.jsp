<%@ page import="namoo.common.factory.JdbcDaoFactory"%>
<%@ page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
	<jsp:setProperty  name="user" property="*"/>
</jsp:useBean>
<%
JdbcDaoFactory.getInstance().getUserDao().create(user);
%>
<jsp:forward page="userRegistResult.jsp"/>




















