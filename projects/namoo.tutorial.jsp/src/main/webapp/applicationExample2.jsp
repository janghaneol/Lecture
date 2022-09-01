<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>application 예제</title>
<!-- 모든 서블릿이나 jsp가 공유하는 어플리케이션 -->
</head>
<body>
<%=application.getAttribute("global") %>
</body>
</html>