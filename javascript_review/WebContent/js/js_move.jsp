<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>js_move</title>
<style>
	img { width: 50px;
		  top: 100px;
		  left: 100px;
		  position: relative;}
</style>

</head>
<body>
<img src="../images/Koala.jpg" id="img1">
<script>
	document.addEventListener("mousemove", function(){
		console.log(event.button);
		//if(event.button == 0) {
		img1.style.left = event.clientX + "px";
		img1.style.top = event.clientY + "px";
		//}
	})
	document.addEventListener("keydown", function(){
		if(event.keyCode == 37) {
			img1.style.left = ( parseInt(img1.style.left) - 10 ) +"px";
		}
	)};
</script>
</body>
</html>