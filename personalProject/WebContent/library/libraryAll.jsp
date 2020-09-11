<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libraryAll</title>
</head>
<body>
	<h3 class="page_title">도서 전체 조회</h3>
	<ul class="search">
		<li>ISBN</li>
		<li>Title</li>
		<button type="button">검색</button>
	</ul>
	<table id="library">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Author</th>
				<th>Publisher</th>
				<th>Published_date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>9781936661596</td>
				<td>hunger games</td>
				<td>Collins, Suzanne</td>
				<td>Unknown</td>
				<td>2012.01.01</td>
			</tr>
		</tbody>
	</table>
</body>
</html>