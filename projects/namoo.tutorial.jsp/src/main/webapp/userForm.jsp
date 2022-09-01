<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>
	<div class="container-md">
		<form class="row" method="post" action="userRegist.jsp">
			<div class="mb-3">
				<label for="id" class="form-label">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="Id">
			</div>

			<div class="mb-3">
				<label for="passwd" class="form-label">비밀번호</label> 
				<input type="password" class="form-control" id="passwd" name="password" placeholder="Password">
			</div>

			<div class="mb-3">
				<label for="name" class="form-label">이름</label> 
				<input type="text" class="form-control" id="name" name="name" placeholder="Name">
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">이메일</label> 
				<input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary mb-3">회원가입</button>
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>