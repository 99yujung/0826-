<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardSelect</title>
</head>
<body>
<h3 class="page_title">게시글 조회</h3>
<div><span class="label">제목</span><span>programming language</span></div>
<div><span class="label">내용</span><span>java, javascript, jquery</span></div>
<div><span class="label">마지막 게시글</span><span></span></div>
<div><span class="label">첨부 파일</span><span>java.jpg</span></div>
<button type="button" id="btnPage">목록으로</button>
<script>
	btnPage.addEventListener("click", goPage );
	function goPage() {
		// history.back();
		// history.go(-1); 이전페이지로 이동
		// location.href="memberAll.jsp"
		location.assign("boardAll.jsp")
	}
</script>
</body>
</html>