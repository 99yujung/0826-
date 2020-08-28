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
var imgArr = ["../images/Chrysanthemum.jpg",
	          "../images/Desert.jpg",
	          "../images/Hydrangeas.jpg",
	          "../images/Jellyfish.jpg"];
for(var i=0; i<imgArr.length; i++) {
	var img = document.createElement("img");  	//태그 생성
	img.src = imgArr[i];						//src 속성 변경
	document.body.appendChild(img);				//body 에 추가
/*	img.addEventListener ("mouseover", function(){				//이벤트 지정
		this.style.width = "200px";
	});
	img.addEventListener ("mouseout", function(){				//이벤트 지정
		this.style.width = "100px";
	});
	*/
	//width=200px, 100px
}
$('.bxslider').bxSlider({
	  auto: true,
	  autoControls: true,
	  stopAutoOnClick: true,
	  pager: true,
	  slideWidth: 600
	});
</script>
</body>
</html>