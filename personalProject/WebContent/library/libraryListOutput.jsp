<%@page import="library.LibraryVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

	<%
		ArrayList<LibraryVO> list = (ArrayList<LibraryVO>) request.getAttribute("list");
	if (!list.isEmpty()) {
	%>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Published_date</th>
		</tr>

		<%
			for (int i = 0; i < list.size(); i++) {
			LibraryVO library = list.get(i);
		%>

		<tr>
			<td><%=library.getISBN()%></td>
			<td><%=library.getTitle()%></td>
			<td><%=library.getAuthor()%></td>
			<td><%=library.getPublisher()%></td>
			<td><%=library.getPublished_date()%></td>
		</tr>
		<%
			}
		} else {
			out.print("<h3>등록된 도서 정보가 없습니다.</h3>");
		}
		%>
	</table>

</body>
</html>