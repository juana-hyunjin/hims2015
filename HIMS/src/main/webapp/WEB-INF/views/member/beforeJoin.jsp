<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȣ�����հ����ý���(HIMS)</title>
<link rel="stylesheet" type="text/css" href="css/beforeJoin.css">
<script src='jquery/jquery.min.js'></script>
<script>
function exeAction(actionUrl) {
	var check = document.getElementById("joinOption1").getAttribute('name');
	var check2 = document.getElementById("joinOption2").getAttribute('name');
	if(actionUrl == "member.joinNext.do") {
		if(check == 'N') {
			alert("���� �̿����� ���� ���Ǵ� �ʼ����� �Դϴ�.");
			return false;
		} else if(check2 == "N") {
			alert("�������� ������ ���� ���Ǵ� �ʼ����� �Դϴ�.")
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
		<label align="left">���� �̿���</label><br/><br/>
		�� ����� (��)Whatsup(���� "ȸ��")���� �����ϴ� ���� "Whatsup"�� �̿�� �����Ͽ� ȸ��� ������ �Ǹ�, �ǹ� �� 
		��Ÿ �ʿ��� ���� ������ ���ϰ� �ֽ��ϴ�. ���񽺸� �̿��Ͻñ� ���� �� ����� ���Ǳ�� �о� ���ñ� �ٶ��, 
		�ڼ��� ������ �� ���� Ŭ���� Ȯ���Ͽ� �ֽñ� �ٶ��ϴ�.<br/>
		</div><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="checkOption()" class="bt-agree" name="N" id="joinOption1">�����մϴ�.(�ʼ��׸�)</a>
		<img src="images/beforeClick.png" onclick="checkOption()" id="imgOption1"><br/>
		<div class="joinInfo">
		<hr/><br/>
		<label>�������� ��޹�ħ</label><br/><br/>
		(��)Whatsup(���� "ȸ��")�� ��Ȱ�� ������ �̿��� ���Ͽ� ������ ���� �̿����� ���������� ����, 
		�̿��Կ� �־� ������Ÿ� �̿����� �� ������ȣ � ���� ����, �������� ��ȣ�� �� ���ù��ɿ� ���� �������� ���� �� 
		�̿뿡 ���Ͽ� ���Ǹ� �ް� �ֽ��ϴ�. �ڼ��� ������ �� ���� Ŭ���� Ȯ���Ͽ� �ֽñ� �ٶ��ϴ�.<br/>
		</div><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="checkOption2()" class="bt-agree" name="N" id="joinOption2">�����մϴ�.(�ʼ��׸�)</a>
		<img src="images/beforeClick.png" onclick="checkOption2()" id="imgOption2"><br/><br/>
	</div>
	<div class="btnSector">
		<button class="join-prev" onclick="return exeAction('member.joinPrev.do')">�������</button>
		<button class="join-next" onclick="return exeAction('member.joinNext.do')">����</button>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>