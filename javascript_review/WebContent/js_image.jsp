<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>js_image.jsp</title>
<style>
	img { width : 100px;}
</style>
</head>
<body>
<script>
var imgArr = ["./images/Chrysanthemum.jpg",
	          "./images/Desert.jpg",
	          "./images/Hydrangeas.jpg",
	          "./images/Jellyfish.jpg"];
for(var i=0; i<imgArr.length; i++) {
	var img = document.createElement("img");  	//태그 생성
	img.src = imgArr[i];						//src 속성 변경
	document.body.appendChild(img);				//body 에 추가
	img.onmouseover = function(){				//이벤트 지정
		this.style.width = "200px";
	}
	img.onmouseout = function(){				//이벤트 지정
		this.style.width = "100px";
	}
}
</script>
</body>
</html>