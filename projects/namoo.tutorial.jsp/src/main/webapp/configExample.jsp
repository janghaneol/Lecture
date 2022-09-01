<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>config 예제</title>
</head>
<body>
<%=config.getInitParameter("user") %> <br>
<%=page %>, <br> <%=this %> <br>
<%=pageContext %>
</body>
</html>