<%@ page import="namoo.yorizori.common.factory.JdbcDaoFactory"%>
<%@ page import="namoo.yorizori.dto.user.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="user" class="namoo.yorizori.dto.user.User" scope="request">
	<jsp:setProperty  name="user" property="*"/>
</jsp:useBean>
<%
JdbcDaoFactory.getInstance().getUserDao().create(user);
%>
<jsp:forward page="userRegistResult.jsp"/>




















