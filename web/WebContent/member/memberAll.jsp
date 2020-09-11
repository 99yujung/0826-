<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>

<%@include file="/common/header.jsp" %>
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
		<%
			ArrayList<MemberVO> list = 
						(ArrayList<MemberVO>)request.getAttribute("list");
			for(MemberVO member : list) {
				
			
		%>
			<tr>
				<td><a href="memberSelect.jsp"><%=member.getId()%></a></td>
				<td><%=member.getPw()%></td>
				<td><%=member.getJob()%></td>
				<td><%=member.getMailyn()%></td>
				<td><%=member.getGender()%></td>
			</tr>
		<%	}	%>
		</tbody>
	</table>
</body>
</html>