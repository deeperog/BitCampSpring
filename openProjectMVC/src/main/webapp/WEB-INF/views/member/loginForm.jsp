<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div id="contents">
		<h2>로그인</h2>
		<hr>
		<form method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userId" value="${cookie.id.value}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>				
					<td><input type="submit" value="로그인"></td>
					<td><input type="checkbox" id="check" name="check"
						<c:if test="${cookie.id.value !=null }">
					 checked
					</c:if>><label for="check">아이디 기억하기</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>