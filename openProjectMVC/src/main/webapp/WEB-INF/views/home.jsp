<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<html>
<head>
<title>Home</title>
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
	<h1>
		<a href="<%=request.getContextPath()%>/guest/list">GuestBook List</a>
		<br /> <a href="<%=request.getContextPath()%>/guest/write">write
			message</a>
	</h1>
</div>

</body>
</html>
