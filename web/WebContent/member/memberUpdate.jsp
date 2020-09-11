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
<% MemberVO member = (MemberVO) session.getAttribute("login"); %>
<h3 class="page_title">내 정보 조회</h3>
	<div class="regist">
	<form method="post" name="frm" id="frm" 
	      action="memberUpdate"
	      onsubmit="return inputCheck()">
		<div>
			<label for="id">id</label>
			<input name="id" id="id" value="<%=member.getId()%>" readonly="readonly">
		</div>
		<div>
			<label for="pw">pw</label>
			<input id="pw" name="pw">
			<input name="pw" id="pw" value="<%=member.getPw()%>">
		</div>
		<div>
			<label for="gender">job</label> 
			<input type="radio" name="gender" value="남"
				<%if("남".equals(member.getGender()) ){ out.print("checked='checked'");} %>>남
			<inpput type="radio" name="gender" value="여"
				<%if(member.getGender().equals("여") ){ out.print("checked='checked'");} %>>여
		</div>
		<div>
			<label for="job">직원</label> 
			<select name="job" id="job">
				<option value="">선택</option>
				<option value="program" selected="selected">프로그래머</option>
				<option value="degin"
					<%if("디자이너".equals(member.getJob()) ){ out.print("selected='selected'");} %>>디자이너
			</select>
		</div>
		<div>
			<label for="reason">reason</label>
			<textarea name="reason" id="reason"><%=member.getReason()%></textarea>
		</div>
	<div>
			<label for="hobby">취미</label>
			<input type="checkbox" name="hobby" value="read"
				<%if("독서".contains(member.getHobby()) ){ out.print("selected='selected'");} %>>독서
			<input type="checkbox" name="hobby" value="game"
				<%if("게임".contains(member.getHobby()) ){ out.print("selected='selected'");} %>>게임
			<input type="checkbox" name="hobby" value="ski"
				<%if("스키".contains(member.getHobby()) ){ out.print("selected='selected'");} %>>스키
		</div>
		<div>
			<button type="reset">초기화</button>
			<button>등록</button>
		</div>
	</form>
</div>
</body>
</html>