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
	<div class="container container-table">
    	<div class="row vertical-center-row">
        <div class="text-center col-md-4 col-md-offset-4">
        <h2>외부 크롤링 서비스를 이용한 CGV 상영예정작</h2>
        		<c:forEach var="movie" items="${list}" varStatus="status">
					<tr>
					<td>${status.count}</td>
					<td>${movie.title}</td>
					<td>${movie.rate}</td>
					</tr>
        		</c:forEach>
        		<a href="http://localhost/${ctx}" class="btn btn-primary">홈으로</a>
        </div>
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
