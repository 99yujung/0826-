<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libraryInsert</title>
<script>
	function inputCheck() {
		// 필수 입력 ISBN
		if (frm.ISBN.value == "") {
			window.alert("ISBN 입력");
			frm.ISBN.focus();
			return false;
		}
		if (frm.title.value == "") {
			alert("title 입력");
			frm.title.focus();
			return false;
		}
		if (frm.author.value == "") {
			alert("author 입력");
			frm.author.focus();
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h3 class="page_title">도서 정보 조회</h3>
	<div class="regist">
		<form method="post" name="frm" id="frm" action="libraryInsert.do"
			onsubmit="return inputCheck()">
			<div>
				<label for="ISBN">ISBN</label> <input name="ISBN" id="ISBN">
			</div>
			<div>
				<label for="title">title</label> <input id="title" name="title">
			</div>
			<div>
				<label for="author">author</label> <input id="author" name="author">
			</div>
			<div>
				<label for="publisher">publisher</label> <input id="publisher"
					name="publisher">
			</div>
			<div>
				<label for="published_date">published date</label> <input
					type="date" id="published_date" name="published_date">
			</div>
			<!-- book_size column 삭제 -->
			<div>
				<button type="reset">초기화</button>
				<button>등록</button>
			</div>
		</form>
	</div>
</body>
</html>