<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<c:if test="${3>1}">
	Hello <br>
</c:if>


<c:if test="${empty param.id}">
아이디가 전달되지않았습니다.
</c:if>

${param.id}

</body>
</html>