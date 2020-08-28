<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js/js_event</title>
<style>
	.price {display: none;}
</style>
<script>
window.addEventListener("load", init);
function init() {
	//클래스가 title인 태그 찾아서
	var titles = document.getElementsByClassName("title");
	for( i=0; i<titles.length; i++) {
		titles[i].addEventListener("mouseenter", function() {
			var price = this.parentNode.getElementsByClassName("price")[0]; // **
			price.style.display="inline";
		});
	//mouseleave
//	for (i=0; i<btns.length; i++) {
		
//		btns[i].addEventListener("load", function() {
//			var price = this.parentNode.getElementsByClassName("price")[0]; // **
//			price.style.display="inline";
//		});
		// 그룹 이벤트
		tbl.addEventListener("click", function() {
			console.dir(event.target)		//버튼
			console.dir(this)				//table
			alert(event.target.parentNode.parentNode
					   .getElementsByTagName("td")[0].innerHTML)
		});
//	}	
	}
}
</script>
</head>
<body>
<table border="1" id=tbl>
	<tbody>
	<div>
		<span class="title">스프링</span>
		<span class=price>5000</span>
	</div>
	<div>
		<span class="title">자바</span>
		<span class=price>4000</span>
	</div>
	<div>
		<span class="title">자바스크립트</span>
		<span class=price>3000</span>
	</div>
	</tbody>
</table>
</body>
</html>