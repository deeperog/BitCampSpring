<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${idz }
<form method="post">
		<input type="hidden" name="id" value="${idz}" /> 정보를 삭제하시려면 암호를 입력하세요:<br /> 암호: <input type="password" name="password" /> <br />
		<input type="submit" value="삭제하기" />
	</form>
</body>
</html>