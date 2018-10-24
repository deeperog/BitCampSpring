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

div {
	padding: 30px;
}
</style>
</head>
<body>
	<div>
		<form method="post">
			<input type="hidden" name="id" value="${id}" /> 메시지를 삭제하시려면 암호를
			입력하세요:<br /> 암호: <input type="password" name="password" /> <br />
				<input type="submit" value="메시지 삭제하기" />
		</form>
	</div>
</body>
</html>