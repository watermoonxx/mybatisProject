<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div class="outer">
	<br>
	<h2 align="center">회원가입</h2>
	<form action="insert.me" method="post">
		<table align="center">
			<tr>
				<td>* ID</td>
				<td><input type="text" name="userID" required></td>
			</tr>
			<tr>
				<td>* PWD</td>
				<td><input type="password" name="userPwd" required></td>
			</tr>
			<tr>
				<td>* Name</td>
				<td><input type="text" name="userName" required></td>
			</tr>
			<tr>
				<td>&ensp; Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>&ensp; Birthday</td>
				<td><input type="text" name="birthday" placeholder="생년월일(6자리)"></td>
			</tr>
			<tr>
				<td>&ensp; Gender</td>
				<td>
					<input type="radio" name="gender" value="M">남
					<input type="radio" name="gender" value="F">여
				</td>
			</tr>
			<tr>
				<td>&ensp; Phone</td>
				<td><input type="text" name="phone" placeholder="-포함"></td>
			</tr>
			<tr>
				<td>&ensp; Address</td>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<br>

		<div align="center" style="padding-bottom: 40px;">
			<input type="reset">&emsp;
			<input type="submit" value="회원가입">
		</div>
	</form>
</div>
</body>
</html>