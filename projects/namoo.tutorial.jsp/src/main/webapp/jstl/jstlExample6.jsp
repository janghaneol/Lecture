<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="daum" value="http://www.daum.net">
	<c:param name="id" value="bangry"></c:param>
	<c:param name="name" value="김기정"></c:param>
	<c:param name="email" value="asdasd"></c:param>
</c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<a href="${daum}">다음</a>
</body>
</html>