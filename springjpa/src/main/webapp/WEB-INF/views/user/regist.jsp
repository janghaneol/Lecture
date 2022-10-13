<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원 등록</title>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous" />
<style>
@media ( min-width : 1200px) {
	.container {
		max-width: 970px;
	}
}
</style>
</head>
<body>
  <div class="container">
    <div class="py-5 text-center">
      <h2>회원 등록</h2>
    </div>
    <form action="/users/regist" method="post">
      <div>
        <label for="userid">아이디</label> <input type="text" id="id"
          name="id" class="form-control">
      </div>
      <div>
        <label for="userpw">비밀번호</label> <input type="password"
          id="passwd" name="passwd" class="form-control">
      </div>
      <div>
        <label for="name">이름</label> <input type="text" id="name"
          name="name" class="form-control">
      </div>
      <div>
        <label for="email">이메일</label> <input type="email" id="email"
          name="email" class="form-control">
      </div>
      <hr class="my-4">
      <div class="row">
        <div class="col">
          <button class="w-100 btn btn-primary btn-lg"
            type="submit">회원 등록</button>
        </div>
        <div class="col">
          <button class="w-100 btn btn-secondary btn-lg" onclick=""
            type="reset">취소</button>
        </div>
      </div>
    </form>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</body>
</html>