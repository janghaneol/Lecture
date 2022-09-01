<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
pageContext.setAttribute("id", "bangry");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>pageContext 예제</title>
</head>
<body>
<%=pageContext.getAttribute("id") %>
<%=application.getAttribute("global") %>
</body>
</html>