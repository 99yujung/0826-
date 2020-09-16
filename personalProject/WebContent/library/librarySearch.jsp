<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
</head>
<body>

<h3>도서정보 검색</h3>

${error}
<form action="../librarySearch.do" method="post">
	TITLE: <input type="text" name="id"/>
	<input type="hidden" name="ISBN" value="search"/>
	<input type="submit" value="검색"/>
</form>

</body>
</html>