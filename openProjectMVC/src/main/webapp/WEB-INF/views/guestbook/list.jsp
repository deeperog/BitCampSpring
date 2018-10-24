<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

ul, li {
	border: 1px solid #EEEEEE;
}
div{
	padding: 30px;
}


</style>
</head>
<body>

<div>
	<c:if test="${viewData.isEmpty()}">
 		작성된 방명록 메시지가 없습니다.
 	</c:if>

	<c:if test="${!viewData.isEmpty()}">
		<ul>
			<c:forEach var="message" items="${viewData.messageList}">
				<li>${message.id} <br /> ${message.guestName} <br />
					${message.message} <br /> <a href="view/${message.id}">상세보기</a> <a
					href="delete?id=${message.id}">[삭제하기]</a>
				</li>
			</c:forEach>
		</ul>

		<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
			<a href="list?page=${num}">[${num}]</a>
		</c:forEach>
	</c:if>
	<br />
	<a href="<%=request.getContextPath()%>/guest/home">방명록 메인으로 가기</a>
	</div>
</body>
</html>