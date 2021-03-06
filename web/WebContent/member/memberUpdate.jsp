<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<%MemberVO member = (MemberVO)session.getAttribute("login"); %>
	<h1 class="page_title">멤버 수정</h1>
		<div class="regist">
			<form method="post" name="frm" id="frm" action="memberUpdate"
				onsubmit="inputCheck()">
				<div>
					<label for="id">ID</label>
					<input id="id" name="id" type="text" value="<%=member.getId() %>" readonly="readonly">
				</div>
				<div>
					<label for="pw">PW</label>
					<input id="pw" name="pw" type="password" value="<%=member.getPw()%>">
				</div>
				<div>
					<label for="gender">성별</label>
					<input type="radio" name="gender" value="male" 
						<c:if test="${login.gender=='male'}">checked="checked"</c:if>	
					>남
					<input type="radio" name="gender" value="female" 
						<c:if test="${login.gender=='female'}">checked="checked"</c:if>
					>여
				</div>
				<div>
					<label for="reason">가입동기</label>
					<textarea id="reason" name="reason"><%=member.getReason()%></textarea>
				</div>
				<div>
					<label for="job">직업</label> <select name="job" id="job" size="3">
						<option value="">선택</option>
						<option value="program" 
							<%if(member.getJob().equals("program")){out.print("selected='selected'");} %>>프로그래머</option>
						<option value="design"
							<%if(member.getJob().equals("program")){out.print("selected='selected'");} %>>디자이너</option>
					</select>
				</div>
				<div>
					<label for="mailys">메일수신여부</label>
					<input type="checkbox" name="mailys" value="y">
				</div>
				<div>
					<label for="hobby">취미</label>
					<input type="checkbox" name="hobby" value="read"
					 	<%if(member.getHobby() != null && member.getHobby().contains("read")){out.print("checked='checked'");} %>>독서
					<input type="checkbox" name="hobby" value="game"
						<%if(member.getHobby() != null && member.getHobby().contains("game")){out.print("checked='checked'");} %>>게임
					<input type="checkbox" name="hobby" value="ski"
						<%if(member.getHobby() != null && member.getHobby().contains("ski")){out.print("checked='checked'");} %>>스키
				</div>
				<div>
					<button type="reset">초기화</button>
					<button>등록</button>
				</div>
			</form>
		</div>
</body>
</html>