<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>
	<%@include file="../menu.jsp"%>
	<h3 class="page_title">회원 전체조회</h3>
	<ul class="search">
		<li>메일수신여부</li>
	    <li>성별</li>
	    <li><button type="button">검색</button></li>
	</ul>
	<table id="members">
		<thead>
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>job</th>
				<th>mailyn</th>
				<th>gender</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><a href="memberSelect.jsp">chichi</a></td>
				<td>1111</td>
				<td>프로그래머</td>
				<td>yes</td>
				<td>여</td>
			</tr>
			<tr>
				<td><a href="memberSelect.jsp">Eve</a></td>
				<td>2222</td>
				<td>디자이너</td>
				<td>no</td>
				<td>남</td>
			</tr>
			<tr>
				<td>tom</td>
				<td>2222</td>
				<td>디자이너</td>
				<td>no</td>
				<td>남</td>
			</tr>
		</tbody>
	</table>
</body>
</html>