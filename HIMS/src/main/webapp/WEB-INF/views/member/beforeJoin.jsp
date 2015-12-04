<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>호텔통합관리시스템(HIMS)</title>
<link rel="stylesheet" type="text/css" href="css/beforeJoin.css">
<script src='jquery/jquery.min.js'></script>
<script>
function exeAction(actionUrl) {
	var check = document.getElementById("joinOption1").getAttribute('name');
	var check2 = document.getElementById("joinOption2").getAttribute('name');
	if(actionUrl == "member.joinNext.do") {
		if(check == 'N') {
			alert("서비스 이용약관에 대한 동의는 필수사항 입니다.");
			return false;
		} else if(check2 == "N") {
			alert("개인정보 수집에 대한 동의는 필수사항 입니다.")
			return false;
		}
		location.href="member.joinNext.do";
	} else  {
		location.href="common.index.do";
	}
}

function checkOption() {
	var id = document.getElementById("joinOption1");
	var image = document.getElementById("imgOption1");
	var check = image.getAttribute('src');
	
	if(check == "images/beforeClick.png") {
		id.setAttribute('name', 'Y');
		image.setAttribute('src', "images/afterClick.png");	
	} else {
		id.setAttribute('name', 'N');
		image.setAttribute('src', "images/beforeClick.png");	
	}
}

function checkOption2() {
	var id = document.getElementById("joinOption2");
	var image = document.getElementById("imgOption2");
	var check = image.getAttribute('src');
	
	if(check == "images/beforeClick.png") {
		id.setAttribute('name', 'Y');
		image.setAttribute('src', "images/afterClick.png");	
	} else {
		id.setAttribute('name', 'N');
		image.setAttribute('src', "images/beforeClick.png");	
	}
}
</script>
</head>
<body>
	<jsp:include page="../common/strangerHeader.jsp" />	
	<div class="viewlogo"align="center">
		<img src="images/sublogo.png" align="middle" style="width:23%; height:15%;">
	</div>
	<div class="joinSector">
		<div class="joinInfo">
		<label align="left">서비스 이용약관</label><br/><br/>
		이 약관은 (주)Whatsup(이하 "회사")에서 제공하는 서비스 "Whatsup"의 이용과 관련하여 회사와 고객간의 권리, 의무 및 
		기타 필요한 제반 사항을 정하고 있습니다. 서비스를 이용하시기 전에 이 약관을 주의깊게 읽어 보시기 바라며, 
		자세한 내용은 이 곳을 클릭해 확인하여 주시기 바랍니다.<br/>
		</div><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="checkOption()" class="bt-agree" name="N" id="joinOption1">동의합니다.(필수항목)</a>
		<img src="images/beforeClick.png" onclick="checkOption()" id="imgOption1"><br/>
		<div class="joinInfo">
		<hr/><br/>
		<label>개인정보 취급방침</label><br/><br/>
		(주)Whatsup(이하 "회사")는 원활한 서비스의 이용을 위하여 다음과 같이 이용자의 개인정보를 수집, 
		이용함에 있어 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 개인정보 보호법 등 관련법령에 따라 개인정보 수집 및 
		이용에 관하여 동의를 받고 있습니다. 자세한 내용은 이 곳을 클릭해 확인하여 주시기 바랍니다.<br/>
		</div><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="checkOption2()" class="bt-agree" name="N" id="joinOption2">동의합니다.(필수항목)</a>
		<img src="images/beforeClick.png" onclick="checkOption2()" id="imgOption2"><br/><br/>
	</div>
	<div class="btnSector">
		<button class="join-prev" onclick="return exeAction('member.joinPrev.do')">가입취소</button>
		<button class="join-next" onclick="return exeAction('member.joinNext.do')">다음</button>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>