<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js_select</title>
</head>
<body>
<input id="txtFruit">
<button type="button" id="btnAdd" onclick="addFruit()">추가</button>
<button type="button" id="btnDel" onclick="delFruit()">삭제</button>
<select id="listFruit" size="10"></select>
<script>
//텍스트필드의 값을 select에 추가
function addFruit(){
	//option 태그 생성
	var option = document.createElement("option");
	option.text = txtFruit.value
	//select에 추가
	listFruit.add(option);
	//입력필드 초기화
	txtFruit.value = "";
}
</script>
</body>
</html>