<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function inputCheck(){
	//id, pw 필수입력 체크
	if(frm.id.value == "") {
		window.alert("id 입력");
		frm.id.focus();
		return false;
	}
	if(frm.pw.value == "") {
		alert("pw 입력");
		frm.pw.focus();
		return false;
	}	
	//job(select 태그) 선택되었는지 확인
	if(frm.job.value == "" ) {
	//if(frm.job.selectedIndex > 0) {
		alert("job 선택");
		frm.job.focus();
		return false;
	}	
	
	//radio, checkbox
	var gender = 
		document.querySelectorAll("[name='gender']:checked").length;
	if(gender == 0) {
		alert("성별 선택");
		return false;
	} 
	// 회원가입폼 제출
	//frm.submit();
	return true;
}
</script>
</head>
<body>
<%@include file="../menu.jsp" %>
<h3 class="page_title">내 정보 조회</h3>
	<div class="regist">
	<form method="post" name="frm" id="frm" 
	      action="memberInsertProc.jsp"
	      onsubmit="return inputCheck()">
		<div>
			<label for="id">id</label>
			<input name="id" id="id">
		</div>
		<div>
			<label for="pw">pw</label>
			<input id="pw" name="pw">
		</div>
		<div>
			<label for="gender">job</label> 
			<input type="radio" name="gender" value="남">남
			<input type="radio" name="gender" value="여">여
		</div>
		<div>
			<label for="job">id</label> 
			<select name="job" id="job">
				<option value="">선택</option>
				<option value="program">프로그래머</option>
				<option value="degin">디자이너</option>
			</select>
		</div>
		<div>
			<label for="reason">reason</label>
			<textarea id="reason" name="reason"></textarea>
		</div>
		<div>
			<label for="mailyn">hobby</label> 
			<input type="checkbox" name="mailyn">등산
		</div>
		<div>
			<button type="reset">초기화</button>
			<button>등록</button>
		</div>
	</form>
</div>
</body>
</html>