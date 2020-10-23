<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<ul>
	<c:if test="${empty sessionScope.id}">
		<li><a href="/web/member/login.jsp">로그인</a></li>
	</c:if>
	<c:if test="${not empty sessionScope.id}">
		<li>${sessionScope.id}님<a href="/web/member/logout">로그아웃</a></li>
		<li><a href="/web/member/memberUpdate">내정보 수정</a></li>
	</c:if>
		<li><a href="/web/dept/deptInsert">부서등록폼</a></li>
		<li><a href="<%=application.getContextPath()%>/dept/deptSelectAll">부서전체조회</a></li>
		<li><a href="<%=application.getContextPath()%>/member/memberInsert.do">멤버 등록</a></li>
		<li><a href="<%=application.getContextPath()%>/member/memberSelectAll.do">멤버 전체조회</a></li>
		<li><a href="<%=application.getContextPath()%>/member/memberSelect.do">멤버 단건조회</a></li>
		<li><a href="<%=application.getContextPath()%>/member/memberStat.do">멤버 상태</a></li>
		<li><a href="<%=application.getContextPath()%>/board/boardSelectAll.do">보드 전체조회</a></li>
		<li><a href="<%=application.getContextPath()%>/board/boardInsert.do">보드 등록</a></li>
		<hr>
		<li><a href="/web/dept/employeeInsert">사원등록폼</a></li>
	</ul>
</body>
</body>
</html>