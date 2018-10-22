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
h2, td {
	padding: 10px;
}
</style>
</head>
<body>
<div id="contents">

		<h2>회원가입</h2>

		<hr>
		<form method="post">
			<input type="hidden" name="idx" value="<%= request.getParameter("idx")%>">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId" value="<%= memberInfo.getUserId()%>"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" value="<%= memberInfo.getPassword()%>"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" value="<%= memberInfo.getUserName()%>"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photoFile"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"></td>
				</tr>
			</table>

		</form>



	</div>
</body>
</html>