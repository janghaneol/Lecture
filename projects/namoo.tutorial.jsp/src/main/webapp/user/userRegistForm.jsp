<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="module" defer src="../js/app.js"></script>
</head>
<body>
  <!-- header start -->
  <jsp:include page="/include/header.jsp" />
  <!-- header end -->

  <!-- main body start -->
  <div class="row">
    <div class="leftcolumn">
      <div class="w3-container">
        <div class="w3-center">
          <h3>회원 가입</h3>
        </div>
        <div class="w3-responsive w3-card-4">
          <form class="row" id="signup" action="userRegist.jsp"
            method="post" autocomplete="off">
            <div class="mb-3">
              <label for="id" class="form-label">아이디</label> <input
                type="text" class="form-control" id="id" name="id"
                placeholder="Write Your Id" required> 
                <p id="dupCheck"></p>
            </div>

            <div class="mb-3">
              <label for="passwd" class="form-label">비밀번호</label> <input
                type="password" class="form-control" id="password"
                name="password" placeholder="Write Your Password" required>
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
    <!-- aside start -->
    <jsp:include page="/include/aside.jsp" />
    <!-- aside end -->
  </div>
  <!-- main body end -->

  <!-- footer start -->
  <jsp:include page="/include/footer.jsp" />
  <!-- footer end -->
</body>
</html>
