<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
HttpSession  loginSession = request.getSession();
User loginUser = (User)loginSession.getAttribute("loginUser");
System.out.println("aside: " + loginUser);
%>


<div class="rightcolumn">
	<div class="card">
		<div>
			<%
				if(loginUser == null){
				System.out.println(loginUser);
			%>
			<form action="/user/login.jsp" method="post">
				<input type="text" id="id" name="id" placeholder="ID"> 
				<input type="password" id="password" name="password" placeholder="Password"> 
				<input type="submit" value="Login">
			</form>
			<%
			} else {
			%>
			<p>
			<%=loginUser.getName()%>님 반갑습니다. <br>
			(가입일자 : <%=loginUser.getRegdate()%>) <br>
			</p>
			<form action="/user/login.jsp" method="get">
			<input type="submit" value ="로그아웃">
			</form>
			
			
			
			<%
			}
			%>
			
			
		</div>
	</div>

	<div class="card">
		<h3>Popular Post</h3>
		<div class="fakeimg">
			<p>Image</p>
		</div>
		<div class="fakeimg">
			<p>Image</p>
		</div>
		<div class="fakeimg">
			<p>Image</p>
		</div>
	</div>
	<div class="card">
		<h3>Follow Me</h3>
		<p>Some text..</p>
	</div>
</div>