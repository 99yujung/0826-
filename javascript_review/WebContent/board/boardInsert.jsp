<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert</title>
</head>
<body>
<script>
function inputCheck(){
	//id, pw 필수입력 체크
	if(frm.sbj.value == "") {
		window.alert("subject 입력");
		frm.sbj.focus();
		return false;
	}
	if(frm.cont.value == "") {
		alert("contents 입력");
		frm.cont.focus();
		return false;
	}	
	//job(select 태그) 선택되었는지 확인

	
	//radio, checkbox

	// 회원가입폼 제출
	//frm.submit();
	return true;
}
</script>
</head>
<body>
<%@include file="../menu.jsp" %>
<h3 class="page_title">게시글 등록</h3>
	<div class="regist">
	<form method="post" name="frm" id="frm" 
	      action="memberInsertProc.jsp"
	      onsubmit="return inputCheck()">
		<div>
			<label for="subject">subject</label>
			<input name="sbj" id="sbj">
		</div>
		<div>
			<label for="cont">contents</label>
			<textarea id="cont" name="cont"></textarea>
		</div>

		<div>
			<button type="reset">초기화</button>
			<button>등록</button>
		</div>
	</form>
</div>
</body>
</html>