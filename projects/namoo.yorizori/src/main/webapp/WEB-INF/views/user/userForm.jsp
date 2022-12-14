<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="w3-center">
          <h3>회원 가입</h3>
        </div>
        <div class="w3-responsive w3-card-4">
          <form class="row" id="signup" action="${ctx}/user/regist.do"
            method="post" autocomplete="off">
            <div class="mb-3">
              <label for="id" class="form-label">아이디</label> <input
                type="text" class="form-control" id="id" name="id"
                placeholder="Write Your Id" required> <input
                id="dupCheck" type="button" value="중복체크">
            </div>

            <div class="mb-3">
              <label for="passwd" class="form-label">비밀번호</label> <input
                type="password" class="form-control" id="password"
                name="passwd" placeholder="Write Your Password" required>
            </div>

            <div class="mb-3">
              <label for="name" class="form-label">이름</label> <input
                type="text" class="form-control" id="name" name="name"
                placeholder="Write Your Name" required>
            </div>

            <div class="mb-3">
              <label for="email" class="form-label">이메일</label> <input
                type="text" class="form-control" id="email" name="email"
                placeholder="name@example.com" required="required">
            </div>
            <div class="col-auto">
              <button type="submit" class="btn btn-primary mb-3">회원가입</button>
            </div>
          </form>
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
