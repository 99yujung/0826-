<%@page import="library.LibraryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h3>수정 정보 검색</h3>
	${error}
	<form action="../librarySearch.do" method="post">
		Title: <input type="text" name="id" />
		<input type="hidden" name="ISBN" value="update"/>
		<input type="submit" value="검색" />
	</form>
	
	<% LibraryVO library = (LibraryVO)request.getAttribute("library");
	 if(library != null) { %>
	 <h3>회원정보 수정</h3>
	 <form action="libraryUpdate.do" method="post">
	 	Title : <input type="text" name="title" value="${library.title}"> <br>
	 	ISBN : <input type="text" name="ISBN" value="${library.ISBN}"> <br>
	 	Author : <input type="text" name="author" value="${library.author}"> <br>
	 	Publisher : <input type="text" name="publisher" value="${library.publisher}"> <br>
	 	Published_date : <input type="date" name="date" value="${library.published_date}"> <br>
	 	<input type="submit" value="수정">
	 </form>
	 
	 <%}else{ %>
	 ${result} <p>
<%} %>

</body>
</html>