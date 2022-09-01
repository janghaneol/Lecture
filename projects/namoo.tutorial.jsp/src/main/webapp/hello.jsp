<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- 서비스메소드의 인스턴스메소드들은 상단에 선언 --%>
<%!String message;
	private int count;%>

<%-- JSP 주석 처리방법 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>오늘부터 JSP입니다.</title>
</head>
<body>

	<h2>JSP 동작원리 수업</h2>

	<%
	String message;
	Calendar today = Calendar.getInstance();
	String ymd = String.format("%1$tF %1$tT", today);
	%>
	<%=ymd%>
	<br> 당신은
	<%=++count%>번째 방문자 입니다.


	<table border='1'>
		<%
		for (int i = 1; i < 10; i++) {
			out.println("<tr>");
			for (int j = 2; j < 10; j++) {
				out.println("<td>" + j + " * " + i + " = " + (i * j) + " </td>");
			}
			out.println("</tr>");
		}
		%>
	</table>

	<table border='1'>
		<%
		for (int i = 1; i < 10; i++) {
		%>
		<tr>
			<%
			for (int j = 2; j < 10; j++) {
			%>
			<td><%=j%> * <%=i%> = <%=(i * j)%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>