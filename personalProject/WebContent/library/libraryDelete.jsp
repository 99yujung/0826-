<%@page import="library.LibraryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
<h3>삭제 정보 검색</h3>
${error}
<form action="librarySearch.do" method="post">
	ISBN: <input type="text" name="ISBN" />
	<input type="hidden" name="title" value="delete" />
	<input type="submit" value="검색" />
</form>

<% LibraryVO library = (LibraryVO)request.getAttribute("library");
 if(library != null) { %>
 	<h3>검색 정보 결과</h3>
 	${library.ISBN } / ${library.title } / ${library.author } / ${library.publisher } / ${library.published_date } <p>
 	
 	<form action="libraryDelete.do" method="post">
 		<input type="hidden" name="ISBN" value="${library.ISBN}" />
 		<input type="submit" value="삭제" />
 	</form>
 	
 	<%}else{ %>
 		${result} <p>
 		
 	<%} %>
</body>
</html>