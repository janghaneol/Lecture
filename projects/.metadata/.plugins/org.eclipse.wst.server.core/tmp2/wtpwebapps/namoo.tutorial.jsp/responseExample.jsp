<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>리스폰스 예제</title>
</head>
<body>
<%
//response.sendRedirect("hello.jsp");
response.sendError(HttpServletResponse.SC_NOT_FOUND);  //404 error
%>
정상처리되었습니다
</body>
</html>