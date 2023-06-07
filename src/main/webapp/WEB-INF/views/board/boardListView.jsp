<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer a {
	color: #ffffff;
	text-decoration: none;
}


#list-area {
	border: 1px solid #ffffff;
	text-align: center;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div class="outer" align="center">
		<br>
		<h2 align="center">게시판</h2>
		<br>
		<div id="search-area">
			<form action="" method="get">
				<select name="keyField">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select> 
				<input type="text" name="keyword" value=""> 
				<input type="submit" value="검색"> 
				<input type="hidden" name="nowPage" value="1">
			</form>
		</div>
		<br>

		<table id="list-area" border="1">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${list}" varStatus="s">
					<tr>
						<%-- <td>${b.boardNo}</td> --%>
						<td>${pi.totalRecord-((pi.nowPage-1)*pi.numPerPage)-s.index}</td>
						<td><a href="detail.bo?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
						<td>${b.boardWriter}</td>
						<td>${b.count}</td>
						<td>${b.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>

		<div id="paging-area">
			<c:if test="${pi.nowPage ne 1}">
				<a href="list.bo?nowPage=${pi.nowPage-1}">[이전]</a>
			</c:if>
			<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
				<a href="list.bo?nowPage=${p}">[${p}]</a>
			</c:forEach>
			<c:if test="${pi.nowPage ne pi.totalPage}">
				<a href="list.bo?nowPage=${pi.nowPage + 1}">[다음]</a>
			</c:if>
		</div>
		<br>
	</div>
</body>
</html>