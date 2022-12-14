<%@page import="namoo.yorizori.dto.user.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="${ctx}/index.do">요리조리 쿡북</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		
			<ul class="navbar-nav me-auto mb-1 mb-lg-0 ms-lg-3">
				<li class="nav-item"><a class="nav-link" href="${ctx}/cookbook/register.do">요리책등록</a></li>
				<li class="nav-item"><a class="nav-link" href="${ctx}/cookbook/list.do">요리책목록</a></li>
				<li class="nav-item"><a class="nav-link" href="${ctx}/movie/reserve/list.do">레시피등록</a></li>
				<li class="nav-item"><a class="nav-link" href="${ctx}/movie/reserve/list.do">상영예정작</a></li>
			</ul>
			
			
			<c:choose>
				<c:when test="${empty loginUser}">
				<div class="container">
				<form class="row row-cols-lg-auto g-3 align-items-center" method="post" action="${ctx}/user/login.do">
					<div class="col-12">
					<input class="id" name="id" type="text" value="${empty cookie.saveId ? '': cookie.saveId.value }" placeholder="아이디">
					</div>
					<div class="col-12">
					<input class="password" name="passwd" type="password" placeholder="비밀번호"> 
					</div>
					<div class="col-12">
					<input class="form-check-input" type="checkbox" value="save" name="saveid" id="flexCheckChecked" ${empty cookie.saveId ? '' : 'checked'}>
					</div> 
					<div class="col-12">
					<label class="form-check-label" for="flexCheckChecked"> ID 저장 </label>
					</div>
					<div class="col-12">
					<button type="submit" class="btn btn-primary">로그인</button>
					</div>
					<div class="col-12">
					<a href="user/signup.do" class="btn btn-warning">회원가입</a>
					</div>
				</form>
				</div>
				</c:when>
				<c:otherwise>
			<form action="${ctx}/user/login.do" method="get">
			<p>${loginUser.name}님 반갑습니다.
			<button type="submit" class = "btn btn-primary">로그아웃</button>
			</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>