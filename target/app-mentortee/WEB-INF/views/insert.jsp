<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Mentortee</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.2.1.min.js'/>"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Poppins", sans-serif
}

body {
	font-size: 16px;
}

.w3-half img {
	margin-bottom: -6px;
	margin-top: 16px;
	opacity: 0.8;
	cursor: pointer
}

.w3-half img:hover {
	opacity: 1
}
</style>
<script type="text/javascript"
	src="<c:url value='/resources/se2/js/HuskyEZCreator.js'/>"></script>
<body>

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding"
		style="z-index: 3; width: 300px; font-weight: bold;" id="mySidebar">
		<br> <a href="javascript:void(0)" onclick="w3_close()"
			class="w3-button w3-hide-large w3-display-topleft"
			style="width: 100%; font-size: 22px">Close Menu</a>
		<div class="w3-container">
			<h3 class="w3-padding-64">
				<b>Mentortee<br>Sotolab
				</b>
			</h3>
		</div>
		<div class="w3-bar-block">
			<a href="#" onclick="w3_close()"
				class="w3-bar-item w3-button w3-hover-white">글쓰기</a>
			<!-- 
    <a href="#showcase" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Showcase</a> 
    <a href="#services" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Services</a> 
    <a href="#designers" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Designers</a> 
    <a href="#packages" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Packages</a> 
    <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Contact</a> -->
		</div>
	</nav>

	<!-- 화면 작을 때 상단 메뉴. -->
	<header
		class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
		<a href="javascript:void(0)" class="w3-button w3-red w3-margin-right"
			onclick="w3_open()">☰</a> <span>Magazine</span>
	</header>


	<!-- 화면 작을 때 효과 -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 340px; margin-right: 40px">

		<!-- Header -->
		<div class="w3-container" style="margin-top: 80px" id="showcase">
			<h1 class="w3-jumbo">
				<b>Magazine 작성</b>
			</h1>
		</div>

		<!-- 여기작성 -->
		<form method="post" action='<c:url value="/board/insert"/>'
			id="target">
			<input type="hidden" value="${sessionScope.num }" name="num">
			<table class="w3-table w3-bordered">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title"
						autocomplete=off style="width: 100%;"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="ir1" id="ir1" rows="10" cols="100"
							style="width: 100%; height: 800px; display: none;"></textarea></td>
				</tr>
			</table>
			<br>
			<!-- <input type="submit" value="등록" id="reg"> -->
			<div class="w3-bar-all w3-center">
				<button type="submit" form="target" value="Submit"
					class="w3-button w3-border w3-round-large"
					style="background-color: #4C5870; margin-right: 350px;">
					<i class="fa fa-check" style="color: white;"></i> <span
						style="color: #EBEDEC;">&nbsp;등록</span>
				</button>
			</div>
		</form>
		<br>

		<!-- W3.CSS Container -->
		<div class="w3-light-grey w3-container w3-padding-32"
			style="margin-top: 75px; padding-right: 58px">
			<p class="w3-right">
				Sotolab<a href="#" title="W3.CSS" target="_blank"
					class="w3-hover-opacity"></a>
			</p>
		</div>

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
		</script>
		<script type="text/javascript">
			var oEditors = [];

			// 추가 글꼴 목록
			//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

			nhn.husky.EZCreator.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "ir1",
				sSkinURI : "/app/resources/se2/SmartEditor2Skin.html",
				htParams : {
					bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
					fOnBeforeUnload : function() {
						//alert("완료!");
					}
				}, //boolean
				fOnAppLoad : function() {
					//예제 코드
					//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
				},
				fCreator : "createSEditor2"
			});

			function pasteHTML() {
				var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
				oEditors.getById["ir1"].exec("PASTE_HTML", [ sHTML ]);
			}

			function showHTML() {
				var sHTML = oEditors.getById["ir1"].getIR();
				alert(sHTML);
			}

			//글자 바이트
			String.prototype.byteLength = function() {
				var l = 0;
				for (var idx = 0; idx < this.length; idx++) {
					var c = escape(this.charAt(idx));
					if (c.length == 1)
						l++;
					else if (c.indexOf("%u") != -1)
						l += 3;
					else if (c.indexOf("%") != -1)
						l += c.length / 3;
				}
				return l;
			};

			$('#target').submit(function(event) {

				oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됩니다.

				// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
				var content = document.getElementById("ir1").value;
				var title = document.getElementById("title").value;
				console.log("내용 : " + content);
				if (content == null || content == "<p>&nbsp;</p>") {
					alert("내용을 입력하세요!");
					event.preventDefault();
				} else if (title == null || title == "") {
					alert("제목을 입력하세요!");
					event.preventDefault();
				} else if (title.byteLength() > 100) {
					alert("제목이 너무 깁니다!");
					event.preventDefault();
				} else {
					try {
						elClickedObj.form.submit();
					} catch (e) {
					}
				}
			});

			function setDefaultFont() {
				var sDefaultFont = '궁서';
				var nFontSize = 24;
				oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
			}
		</script>
</body>
</html>