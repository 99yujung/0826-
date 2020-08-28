<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq_datatable</title>

<link rel="stylesheet" href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
	$(function(){
		$("#tbl").dataTable();
	});
</script>

</head>
<body>
<table border="1" id="tbl">
	<thead>
		<tr>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
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