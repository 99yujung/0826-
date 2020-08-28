<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../common.css">   
<ul class="menu">
	<li><a href="../member/memberInsert.jsp">회원등록</a></li> 
	<li><a href="../member/memberAll.jsp">회원목록</a></li>
	<li><a href="../board/boardInsert.jsp">게시글등록</a></li> 
	<li><a href="../board/boardAll.jsp">게시글목록</a></li>	
</ul>
<div id="result"></div>
<script>
	url = location.pathname;
	pageName.innerHTML = url.substring(url.lastIndexOf("/")+1)
</script>