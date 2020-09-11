<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>librarySelect</title>
</head>
<body>
<h3 class="page_title">도서 정보 조회</h3>
<div><span class="label">ISBN</span><span></span></div>
<div><span class="label">Title</span><span></span></div>
<div><span class="label">Author</span><span></span></div>
<div><sapn class="label">Publisher</sapn><span></span></div>
<div><span class="label">Published_date</span><span></span></div>
<button type="button" id="btnPage">목록으로</button>
<script>
	btnPage.addEventListener("click", goPage);
	function goPage() {
		location.assign("libraryAll.jsp")
	}
</script>
</body>
</html>