<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȣ�����հ����ý���(HIMS)</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
function login() {
	var userid = document.loginform.getElementById("userid").value;
	var userpw = document.loginform.getElementById("userpw").value;
	if(userid=="" || userpw=="") {
		alert("���̵�� �н����带 �Է��ϼ���.");
		return false;
	} else {
		document.loginform.submit();
		return true;
	}
}
</script>
</head>
<body>
<div class="viewlogo"align="center">
	<img src="images/sublogo.png" align="middle" style="width:23%; height:15%;">
</div>
<%--�α��� �� ���̺�--%>
<div class="loginSector">
	<form name="loginform" action="member.login.do" method="post">
		<br/><br/>
		<input type="text" name="userid" id="userid" placeholder=" id"> <br/>
		<input type="password" name="userpw" id="userpw" placeholder=" password"> <br/><br/>
		<input type="checkbox" name="saveid" id="saveid"> ���̵� ����
		<input type="checkbox" name="savepw" id="savepw"> �н����� ���� <br/><br/><hr/><br/>
		<button type="submit"  name="action" value="login" onclick="return login()">LOGIN</button><br/><br/>
		<br/>
		<a class="joinBtn" href="member.joinView.do">ȸ������</a>
		<a class="findBtn" href="member.findIdView.do">���̵� / </a>
		<a class="findBtn" href="member.findPwView.do">��й�ȣ ã��</a>
	</form>
</div>
<footer>
<jsp:include page="../common/footer.jsp" />
</footer>
</body>
</html>