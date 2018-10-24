<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="title">OpenProject</h1>

<ul id="gnb">
	<li><a href="<%= request.getContextPath() %>/">메인</a></li>
	<li><a href="<%= request.getContextPath() %>/member/memberReg">회원가입</a></li>
	
	<c:choose>
		<c:when test="${loginInfo == null}">
			<li><a href="<%= request.getContextPath() %>/member/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<%= request.getContextPath() %>/member/logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>	
	
	
	<%-- <c:choose>
		<c:when test="${sessionScope.userId == null}">
			<li><a href="<%= request.getContextPath() %>/member/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<%= request.getContextPath() %>/logout.jsp">로그아웃</a></li>
		</c:otherwise>
	</c:choose>	 --%>
	
	<li><a href="<%= request.getContextPath() %>/member/mypage">마이페이지</a></li>
	<li><a href="<%= request.getContextPath() %>/member/memberList">회원 리스트</a></li>
	<li><a href="<%= request.getContextPath() %>/guest/home">방명록</a></li>
</ul>