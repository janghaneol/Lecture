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
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="col-auto h2">요리책 등록</div>
          <!-- cookbook Form -->
          <form method="post" action="${ctx}/cookbook/register.do">
            <div class="row mb-3">
              <label for="book_name" class="col-sm-2 col-form-label">요리책명</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="book_name" name="book_name">
              </div>
            </div>
            <div class="row mb-3">
              <label for="author" class="col-sm-2 col-form-label">등록자</label>
              <div class="col-sm-10">
                <input type="text" class="form-control"
                  placeholder="${loginUser.name}" disabled>
                  <input type="hidden" name = "author_id" value="${loginUser.id}">
              </div>
            </div>

            <div class="row mb-3">
              <label for="book_desc" class="col-sm-2 col-form-label">설명</label>
              <div class="col-sm-10">
                <textarea class="form-control" id="book_desc" name="book_desc" rows="5"></textarea>
              </div>
            </div>

            <div class="row mb-3">
              <div class="col-md-4">
                <a href="${ctx}/cookbook/cookbookList.jsp" class="btn btn-primary">목록</a>
              </div>
              
              <div class="col-md-4 offset-md-4" style="text-align: right;">
                <button type="submit" class="btn btn-primary">등록</button>
              </div>
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
