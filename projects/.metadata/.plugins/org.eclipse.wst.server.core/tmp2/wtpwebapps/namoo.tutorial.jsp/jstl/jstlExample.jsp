<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 서블릿 영역 코드라 가정..
request.setAttribute("html" , "<h2>JSTL 연습 입니다.</h2>");
request.setAttribute("someValue", null);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%= request.getAttribute("html") %> <br>
${html} <br>
<c:out value="${html}" escapeXml="false"/>

${someValue} <br>

<c:out value="${someValue}" default="디폴트값"/>

</body>
</html>