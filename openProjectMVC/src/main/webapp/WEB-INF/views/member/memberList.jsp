<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2 {
	padding: 10px;
}
table {
	margin-top: 10px;
}
td {
	padding: 10px 20px;
}
</style>
</head>
<body>

	<div id="contents">
		<h2>회원리스트</h2>

		<hr>

		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>사진</td>
				<td>관리</td>
			</tr>
			
			<c:forEach items="${list}" var="list">
	
			<tr>
				<td>${list.userId}</td>
				<td>${list.password}</td>
				<td>${list.userName}</td>
				<td>${list.userPhoto}</td>
				<td><a href="update/${list.userId}">수정</a>
					<a href="delete/${list.userId}">삭제</a></td>
			</tr>
			</c:forEach>
			
		</table>


	</div>

</body>
</html>