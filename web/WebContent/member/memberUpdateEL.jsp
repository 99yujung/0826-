<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateEL.jsp</title>
<script>
	function inputCheck() {
		if (frm.id.value == "") {
			window.alert("id 입력");
			frm.id.focus();
			return;
		}
		if (frm.pw.value == "") {
			window.alert("pw 입력");
			frm.pw.focus();
			return false;
		}
		//if(frm.job.value == ""){
		if (frm.job.selectedIndex == 0) { //이렇게도 가능.
			window.alert("job 선택");
			frm.job.focus();
			return false;
		}
		var gender = document.querySelectorAll("[name='gender']:checked").length;
		if (gender == 0) {
			alert("성별 적어도 하나는 선택");
			return false;
		}
		//회원가입폼 제출
		//frm.submit();
		return true;
	}
</script>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<h1 class="page_title">멤버 수정</h1>
		<div class="regist">
			<form method="post" name="frm" id="frm" action="memberUpdate"
				onsubmit="inputCheck()">
				<div>
					<label for="id">ID</label>
					<input id="id" name="id" type="text" value="${login.id }" readonly="readonly">
				</div>
				<div>
					<label for="pw">PW</label>
					<input id="pw" name="pw" type="password" value="${login.pw }">
				</div>
				<div>
					<label for="gender">성별</label>
					<input type="radio" name="gender" value="male">남
					<input type="radio" name="gender" value="female">여
				</div>
				<div>
					<label for="reason">가입동기</label>
					<textarea id="reason" name="reason">${login.reason }</textarea>
				</div>
				<div>
					<label for="job">직업</label> <select name="job" id="job" size="3">
						<option value="">선택</option>
						<option value="program">프로그래머</option>
						<option value="design">디자이너</option>
					</select>
				</div>
				<div>
					<label for="mailys">메일수신여부</label>
					<input type="checkbox" name="mailys" value="y">
				</div>
				<div>
					<label for="hobby">취미</label>
					<input type="checkbox" name="hobby" value="read">독서
					<input type="checkbox" name="hobby" value="game">게임
					<input type="checkbox" name="hobby" value="ski">스키
				</div>
				<div>
					<button type="reset">초기화</button>
					<button>등록</button>
				</div>
			</form>
		</div>
</body>
</html>