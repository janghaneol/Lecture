<%@page import="namoo.yorizori.dto.cookbook.Cookbook"%>
<%@page import="namoo.yorizori.common.factory.ServiceFactoryImpl"%>
<%@page import="namoo.yorizori.service.cookbook.CookbookServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="namoo.yorizori.dto.user.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>요리조리.com</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="${ctx}/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${ctx}/css/styles.css" rel="stylesheet" />

</head>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	
	<!-- Section-->
  	<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
      <div class="row">
        <div class="col h2">
        <c:if test="${loginUser != null }"> 
          요리~조리~ <a href="${ctx}/cookbook/register.do" class="btn btn-md btn-primary">요리책 등록</a>
        </c:if>
        </div>
      </div>
      <div class="row" style="height: 15px">
        <p class="col">
          요리조리는 함께 참여하여 만들어가는 요리책 서비스 입니다.<br> 요리조리와 함께 나만의 레시피를 요리
          매니아들과 공유해 보세요.
        </p>
      </div>
    </div>
 		
    <div class="container px-4 px-lg-5 mt-5">
      <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
     	
        <!-- 요리책 목록 -->
        <form method="get" action="${ctx}/cookbook/list.do">
        
        <c:forEach var="list" items="${list}">
        <div class="col mb-5">
          <div class="card h-70">
            <!-- book details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- book name-->
                <h5 class="fw-bolder"> ${list.book_name} </h5>
                <!-- author-->
                ${list.author_id}
              </div>
            </div>
            <!-- Product actions-->
            <div
              class="card-footer p-4 pt-0 border-top-0 bg-transparent">
              <div class="text-center">
                <a class="btn btn-outline-dark mt-auto" href="#">레시피 목록조회</a>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        </form>
        
       </div>
     </div>

  </section>
  
	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
