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
div{
	padding: 30px;
}
</style>
</head>
<body>
<div>
	<form method="post">
		이름: <input type="text" name="guestName" /> <br />
		암호: <input	type="password" name="password" /> <br />
		메시지: <textarea name="message" cols="30" row="3"></textarea><br />
		<input type="submit" value="메시지 남기기" />
	</form>
</div>
</body>
</html>