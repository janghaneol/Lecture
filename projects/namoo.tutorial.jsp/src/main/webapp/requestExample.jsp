<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>리퀘스트 예제</title>
</head>
<body>
클라이언트 아이피 : <%= request.getRemoteAddr() %> <br>
클라이언트 요청 방식 : <%= request.getMethod() %> <br>
컨텍스트패스 : <%=request.getContextPath() %> <br>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
%>
<%= id %>, <%=name %>
</body>
</html>