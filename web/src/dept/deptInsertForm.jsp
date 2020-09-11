<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsertForm.jsp</title>
</head>
<body>
<form action="DeptInsert">
	부서번호<input name="department_id"><br>
	부서명<input name="department_name"><br>
	지역<select name="location_id">
	<%-- --%>
	<c:forEach items="$(locationlist)" var="location">
			<option value="1400"> Texas t
			<option value="1500"> California
			<option value="1700"> Washington
			<option value="1800"> Ontario
			<option value="2500"> Oxford
		</select>
	매니저<select name="manager_id"
	option value="100> king
	
	</select>
	<button>등록</button>
</form>
</body>
</html>