<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardClient.jsp</title>
<script type="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
$(function() {
	//목록조회
	function boardList() {
		$.ajax("../BoardSelectAllAjaxServ" , {
			dataType: "json",
			success: function(data) {
				for(i=0; i<datas.length; i++) {
					$("#list").append($("div").append()
							  .append(datas[i].poste)
							  .append(datas[i].sibjext=c})
							  .appendTo($("list"))
							  
				}
			}
		})
	}
})
//저장버튼
$("#btnSave").on("click", function(){
	$.ajax("../BoardInsertAjaxServ", {
		dataType: "json",
		data : $("form").serializse(),
		success : function(data) {
			$("<div>").append(data.no)
		 	.append(data.poster)
		 	.append(data.subject)
		 	.append("no", data.no)
		 	.append($("<button>").html("삭제").addClass("btnDel") )
		 	.appendTo($("#list"))
	}
});
	
//등록
function boardInsert() {
	$.ajax("/")
}
		
</script>
</head>
<body>
	<!-- 목록 -->
	<div id="list"></div>
	<form>
		<input type="text" name="poster" placeholder="작성자" /> <input
			type="text" name="subject" placeholder="제목" />
		<textarea rows="4" cols="50" name="contents" plcaeholder="내용"></textarea>
		<button type="button" id="btnSave"></button>
	</form>
</body>
</html>