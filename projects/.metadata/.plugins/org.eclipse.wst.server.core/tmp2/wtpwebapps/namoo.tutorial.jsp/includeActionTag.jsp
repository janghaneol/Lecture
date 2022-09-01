<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	메인부분입니다. <br>

------------------------------------------- <br>
<jsp:include page="/include/footer.jsp">
	<jsp:param value="someData" name="some"/>
</jsp:include>


</body>
</html>