<%@ page import="java.util.List"%>
<%@ page import="namoo.yorizori.common.factory.JdbcDaoFactory"%>
<%@ page import="namoo.yorizori.dto.user.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
HttpSession loginSession = request.getSession();
User loginUser = (User) loginSession.getAttribute("loginUser");
if (loginUser == null) {
%>
<html>
<script>
	alert("회원목록은 로그인 사용자만 사용 가능합니다.");
</script>
</html>
<%
} else {
  List<User> list = JdbcDaoFactory.getInstance().getUserDao().list();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/css/pagination.css">
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
          <h3>
            회원 목록(총
            <%=list.size()%>명)
          </h3>
        </div>

        <!-- 검색폼 -->
        <div class="search">
          <form>
            <select name="searchType">
              <option value="all">전체</option>
              <option value="id">아이디</option>
              <option value="name">이름</option>
            </select> <input type="text" name="searchValue"
              placeholder="Search.."> <input type="submit"
              value="검색">
          </form>
        </div>

        <div class="w3-responsive w3-card-4">
          <table class="w3-table w3-striped w3-bordered">
            <thead>
              <tr class="w3-theme">
                <th>번호</th>
                <th>아이디</th>
                <th>이름</th>
                <th>이메일</th>
                <th>가입일자</th>
              </tr>
            </thead>

            <tbody>
              <%
              for (int i = 0; i < list.size(); i++) {
              	User user = list.get(i);
              %>
              <tr class="w3-white">
                <td><%=i + 1%></td>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getRegdate()%></td>
              </tr>
              <%
              }
              %>
            </tbody>

          </table>
        </div>
      </div>
      <div class="pagination">
        <a href="#">&laquo;</a> <a href="#">1</a> <a class="active"
          href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a>
        <a href="#">6</a> <a href="#">7</a> <a href="#">8</a> <a
          href="#">9</a> <a href="#">10</a> <a href="#">&raquo;</a>
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
<%
}
%>
