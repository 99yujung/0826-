<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardInsert.do" method="post"
		enctype="multipart/form-data">
		<div>
			<label>작성자</label> 
			<input type="text" name="poster" />
		</div>
		<div>
			<label>제목</label> 
			<input type="text" name="subject" />
		</div>
		<div>
			<label>내용</label>
			<textarea rows="4" cols="50" name="contents"></textarea>
		</div>
		<div>
			<label>파일</label> 
			<input type="file" name="filename" />
		</div>
		<div>
			<button>등록</button>
		</div>
	</form>
</body>
</html>