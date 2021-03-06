<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Mentortee</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.min.js'/>"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
</style>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-container">
    <h3 class="w3-padding-64"><b>Mentortee<br>Sotolab</b></h3>
  </div>
  <div class="w3-bar-block">
    <a href="/app/nomagazine" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">승인 요청 매거진</a> 
    <a href="/app/magazine" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">승인 완료 매거진</a>
    <!-- 
    <a href="#showcase" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Showcase</a> 
    <a href="#services" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Services</a> 
    <a href="#designers" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Designers</a> 
    <a href="#packages" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Packages</a> 
    <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Contact</a> -->
  </div>
</nav>

<!-- 화면 작을 때 상단 메뉴. -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
  <span>Magazine</span>
</header>


<!-- 화면 작을 때 효과 -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
    <h1 class="w3-jumbo"><b>Magazine</b></h1>
    <h1 class="w3-xxxlarge w3-text-red"><b>매거진 목록</b></h1>
    <hr style="width:50px;border:5px solid red" class="w3-round">
  </div>
  
 <div class="content table-responsive table-full-width">
                        <table class="w3-table" >
                            <tr class="w3-red">
                                <th>게시글 번호</th>
                            	<th>이메일</th>
                            	<th>제목</th>
                            	<th>등록날짜</th>
                            	<th>승인</th>
                            </tr>
                            <tbody>
                            <c:forEach var="mvo" items="${mlist }">
                                <tr>
                                	<td>${mvo.b_num }</td>
                                	<td>${mvo.email }</td>
                                	<td>${mvo.title }</td>
                                	<td>${mvo.regdate }</td>
                                	<td class="auth" b_num="${mvo.b_num }">
                                	<button class="w3-btn w3-red" class="btn_auth" b_num="${mvo.b_num }">승인</button>
                                	<c:if test="${mvo.auth != false}">
                                		<script type="text/javascript">
                                			$("#btn_auth").prop("disabled",true);
                                		</script>
                                	</c:if>
                                	</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

<!-- End page content -->
</div>

<!-- W3.CSS Container -->
<div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px"><p class="w3-right">Sotolab<a href="#" title="W3.CSS" target="_blank" class="w3-hover-opacity"></a></p></div>

<script>
// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}

$(".auth").click(function(){
	var bool = confirm("해당 매거진을 승인하시겠습니가?");
	
	if(bool){
		var b_num = $(this).attr("b_num");
		$.post("/app/web/admin/auth", { "b_num": b_num})
		  .done(function( data ) { 
		    	alert("승인되었습니다.");
		  });
	}else{
		alert("노승인");
	}
});

</script>

</body>
</html>
