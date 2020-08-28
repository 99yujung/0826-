<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch</title>
<script>

function loadDoc() {
	// 1.XHR 객체 생성
	var xhttp = new XMLHttpRequest();
  	// 2. 콜백 함수
	xhttp.onreadystatechange = function() {
    if (this.readyState == 4) {
      	if(this.readyState == 4) {
    	//json
    	var obj = JSON.parse( this.responseText );
    	
    	
      	for(i=0; i<obj.length; i++){
      		document.getElementById("result").innerHTML += obj[i].name + "<br>";
      		}
      	} else {
      		document.getElementById("result").innerHTML = xhttp.status + " , "
      													  xhttp.statusText;
      	}
    } else {
    	document.getElementById("result").innerHTML = "처리중";
    }
    	// document.getElementById("result").innerHTML += obj.name + obj.job + "<br>";
    	
      	// this.responseText;
    
  };
  // 3. 요청 준비
  	var dt = document.getElementById("name").value;
	var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=";
  	xhttp.open("GET", "./")
	// 4. 요청 시작  xhttp.open("GET", "./server/memberinfo.jsp", true);
  
  xhttp.send();
}

</script>
</head>
<body>
<input type="text">
<input type="text" id="name">
<button type="button" onclick="loadDoc()">검색</button>
<div id="result"></div>
</body>
</html>