<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libraryInsert.jsp</title>
</head>
<body>
	<h3>도서 등록</h3>
	${error }

	<form action="../libraryInsert.do" method="post">
		ISBN : <input type="text" name="ISBN" > <br>
		Title : <input type="text" name="title"> <br>
		Author : <input type="text" name="author"> <br>
		Publisher : <input type="text" name="publisher"> <br>
		Published_date : <input type="date" name="published_date"> <br>
		
		<input type="submit" value="등록">
		
	</form>
</body>
</html>