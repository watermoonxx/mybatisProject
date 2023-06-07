<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.login-area a {
	text-decoration: none;
	color: #1f1e1e;
	font-size: 12px;
}

.nav-area {
	background-color: #3c90e2;
	color: #ffffff;
	height: 50px;
}

.menu {
	display: table-cell;
	width: 250px;
	height: 50px;
	vertical-align: middle;
	font-size: 20px;
	font-weight: bold;
}

.menu:hover {
	background-color: #49545d;
}

.outer {
	width: 900px;
	background-color: #3c90e2;
	color: #1f1e1e;
	margin: auto;
	margin-top: 50px;
}
</style>

</head>
<body>
	<h1 align="center" style="color: steelblue">Welcome to MyBatis World</h1>
	<div class="login-area" align="right">
		<c:choose>
			<c:when test="${ empty loginUser }">
				<!-- 1. 로그인 전 -->
				<form action="login.me" method="post">  
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userID" required></td>
							<td rowspan="2"><input type="submit" value="로그인" style="height:50px;"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="userPwd" required></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
                                <a href="enrollForm.me">회원가입</a><br>
                                <a href="">아이디/비밀번호 찾기</a>
                            </td>
						</tr>
					</table>

				</form>
			</c:when>

			<c:otherwise>
				<!-- 2. 로그인 후 -->
				<div>
					<table>
						<tr>
							<td colspan="2">
								<h3>${loginUser.userName}님 환영합니다.</h3>
							</td>
						</tr>
						<tr>
							<td><a href="">마이페이지</a></td>
							<td><a href="logout.me">로그아웃</a></td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<br>

	<div class="nav-area" align="center">
		<div class="menu">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='list.bo?nowPage=1'">게시판</div>
		<div class="menu">etc.</div>
	</div>

</body>
</html>