<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empAll</title>
</head>
<body>
<h3>사원 목록</h3>
<a href="#">king</a><br>
<a href="#">steven</a><br>
<a href="#">scott</a><br>
<script>
	var atag = document.getElementsByTagName("a");
	for(i=0; i<atag.length; i++) {
		atag[i].addEventListener("click", choose);
	}
	
	function choose() {
		opener.document.getElementById("manager_id").value = 
							 window.event.target.innerHTML
		window.close();
	}
</script>
</body>
</html>