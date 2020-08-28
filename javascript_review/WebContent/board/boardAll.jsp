<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardAll</title>
</head>
<body>
	<%@include file="../menu.jsp"%>     
	<h3 class="page_title">------전 체 글 조회</h3>
	<ul class="search">
		<li></li>
	    <li></li>
	    <li><button type="button">검색</button></li>
	</ul>
	<table id="board">
		<thead>
			<tr>
				<th>no</th>
				<th>poster</th>
				<th>subject</th>
				<th>contents</th>
				<th>lastpost</th>
				<th>views</th>
				<th>filename</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>0001</td>
				<td></td>
				<td><a href="boardSelect.jsp">java</a></td>
				<td></td>
				<td>2020.01.01</td>
				<td></td>
				<td>java.jpg</td>
			</tr>
			<tr>
				<td>0002</td>
				<td></td>
				<td><a href="boardSelect.jsp">database</a></td>
				<td></td>
				<td>2020.01.02</td>
				<td></td>
				<td>db.jpg</td>
			</tr>
		</tbody>
	</table>
</body>
</html>