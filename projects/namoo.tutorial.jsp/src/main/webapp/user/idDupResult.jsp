<%@page import="namoo.yorizori.common.factory.JdbcDaoFactory"%>
<%@page import="namoo.yorizori.dto.user.User"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
%>
<%
boolean result = JdbcDaoFactory.getInstance().getUserDao().read(id);
%>
<html lang="ko">
<head>
<meta charset="utf-8">
</head>
<body>
	<form method="post" action="idDupResult.jsp">
		<input type="text" name="id" id="id" required="required" value="<%=id%>"> 
		<input type="submit" value="중복체크">
	</form>
	<%
	if (result) {// 아이디중복
	%>
	<p style="color: red">사용할 수 없는 아이디입니다.</p>
	<%
	} else {
	%>
	<p style="color: blue">사용가능한 아이디 입니다.. </p>
	<input type="button" value="사용하기" id="confirm">
	<%
	}
	%>
	
<script>
document.querySelector("#confirm").addEventListener("click", function(event) {
	const id = document.querySelector("#id").value;
	opener.document.querySelector("#id").value=id;
	self.close();
});
</script>
</body>

</html>