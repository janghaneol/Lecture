<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.JdbcDaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
	<jsp:setProperty property="*" name="user" />
</jsp:useBean>
<%
String method = request.getMethod();
//로그인 처리
if (method.equalsIgnoreCase("post")) {
%>
<%
	User loginUser = JdbcDaoFactory.getInstance().getUserDao().login(user.getId(), user.getPassword());
	if (loginUser != null) {
		HttpSession loginSession = request.getSession();
		loginSession.setAttribute("loginUser", loginUser);
		response.sendRedirect("/index.jsp");
	}
}
%>
