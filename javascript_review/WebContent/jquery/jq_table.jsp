<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//tbody의 2열의 국어 성적의 합계를 계산하여 span 태그에 출력
	
</script>
</head>
<body>
<table id="tbl">
	<thead>
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>kim</td>
			<td>90</td>
			<td>80</td>
		</tr>
		<tr>
			<td>park</td>
			<td>60</td>
			<td>100</td>
		</tr>
		<tr>
			<td>choi</td>
			<td>40</td>
			<td>100</td>
		</tr>			
	</tbody>
</table>
<div>국어합계: <span id="kor"></span></div>
</body>
</html>