<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="html" value="<h2>JSTL연습입니다.</h2>"></c:set>
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