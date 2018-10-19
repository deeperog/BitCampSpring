<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>@RequestParam 애너테이션 사용</h3>
	<form action="submitReport1" method="post"	enctype="multipart/form-data">
		학번 <input type="text" name="studentNumber"> <br> 
		이름 <input type="text" name="studentName"> <br> 
		리포트 파일 <input type="file" name="report"> <br>
		 <input type="submit">
	</form>
	<h3>MultipartHttpServletRequest 사용</h3>
	<form action="submitReport2" method="post"	enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 
		리포트파일: <input	type="file" name="report" /> <br />
		 <input type="submit" />
	</form>
	<h3>커맨드 객체 사용</h3>
	<form action="submitReport3" method="post"	enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br />
		리포트파일: <input	type="file" name="report" /> <br />
		<input type="submit" />
	</form>
</body>
</html>