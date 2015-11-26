<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȣ�����հ����ý���(HIMS))</title>
<link rel="stylesheet" type="text/css" href="css/join.css"/>
<!-- ������ ��ȿ���˻� -->
<script src='js/join.js'></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="joinSector">
		<form id="joinform" name="joinform" action="member.join.do" method="post">
			<br />
			<div class="joinElement">
				<label>���̵�</label><br/><br>
				<input type="text" name="userid" id="userid" placeholder="���̵� �Է��� �ּ���.">
				<button onclick="return exeAction('member.checkId.do')">�ߺ�üũ</button><br/>
				<label class="check" name="check1" id="check1"> &nbsp; </label>
			</div>
			<br />
			<div class="joinElement">
				<label>�� ��</label><br/><br>
				<input type="text" name="name" id="name" placeholder="�̸��� �Է��� �ּ���.">
				<label class="check" name="check2" id="check2"> &nbsp; </label>
			</div>
			<br />
			<div class="joinElement">
				<label>��й�ȣ</label><br/><br>
				<input type="password" name="userpw" id="userpw" placeholder="��й�ȣ�� �Է����ּ���.(4�� �̻�)">
				<br/><br/> 
				<input type="password" name="checkuserpw" id="checkuserpw" placeholder="��й�ȣ�� �ѹ� �� �Է����ּ���."><br />
				<br/>
			</div>
			<div class="joinElement">
				<label>�������</label><br/><br>
				<input type="text" name="birth" id="birth" maxlength="6" onkeyup="checkNumber(document.joinform.birth)" placeholder="��������� �Է����ּ���. (6�ڸ�)">
				<br/><br/> 
			</div>
			<div class="joinElement2">
				<label>��ȭ��ȣ</label><br/><br/> 
				<select name=mobile1 style="width: 60px" id="mobile1" onchange="nextfocus(this.value);">
					<option selected="selected">����</option>
					<option>010</option>
					<option>011</option>
					<option>018</option>
					<option>017</option>
					<option>016</option>
				</select> <input type="text" maxlength="4" size="20" name="mobile2"
					id="mobile2" onfocus="warning();"
					onkeyup="checkNumberAndShift(document.joinform.mobile2, 4, document.joinform.mobile3)">
				<input type="text" maxlength="4" size="20" name="mobile3"
					id="mobile3"
					onkeyup="checkNumberAndShift(document.joinform.mobile3, 4, document.joinform.email);"><br />
				<br/>
			</div>
			<div class="joinElement2">
				<label>�̸���</label><br/><br>
				<input type="text" class="email" name="email1" id="email1"> 
				<input type="text" class="email" name="email2" id="email2"> 
				<select id="email3" name="email3" class="email3" onclick="clickEmail()">
					<option value="">�����Է�</option>
					<option value="@gmail.com">@gmail.com</option>
					<option value="@naver.com">@naver.com</option>
					<option value="@hanmail.net">@hanmail.net</option>
					<option value="@hotmail.com">@hotmail.com</option>
					<option value="@nate.com">@nate.com</option>
				</select><br />
				<br/>
			</div>
			<div class="btnSector">
				<button class="join-prev" onclick="return exeAction2('member.joinPrev.do')">�������</button>
				<button class="join-next" type="submit" onclick="return formValid()">ȸ������</button>
			</div>
		</form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>