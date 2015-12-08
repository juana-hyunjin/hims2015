<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ȣ�����հ����ý���(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/addRoom.css">
<script language=JavaScript>
function addRoom() {
	if(document.getElementById("roomNo").value=="") {
		alert('���ǹ�ȣ�� �Է����ּ���.');
		return false;
	}
	if(document.getElementById("typeName").value=="����") {
		alert('���������� �������ּ���.');
		return false;
	}
	if(document.getElementById("limitNum").value=="����") {
		alert("������ ������ �������ּ���.");
		return false;
	}
	if(document.getElementById("price").value=="") {
		alert("������ ������ �Է����ּ���.");
		return false;
	}
	if(document.getElementById("bed").value=="") {
		alert('���� ħ���� ������ ������ �Է��ϼ���.');
		return false;
	}v5
	if(document.getElementById("floor").value=="") {
		alert('���� �������ּ���.');
		return false;
	}
	document.addForm.submit();
	return true;
}
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/roomlogo.png" style="width:23%; height:20%;">
	</div>
	<!-- ���� ���� ���� -->
	<div class="container" align="center">
		<div class="addSector">
		<hr width="600px">
			<form id="addForm" method="post" action="room.addRoom.do" enctype="multipart/form-data">
				<table id="addRoom" class="addRoom" align="center">
					<tr>
						<td width="100px"><label>���ǹ�ȣ</label></td>
						<td><input type="text" class="form-control" name="roomNo" id="roomNo"></td>
					</tr>
					<tr>
						<td><label>����</label></td>
						<td>
							<select class="form-control" id="typeName" name="typeName">
								<option selected="selected">����</option>
								<option value="1">Single Room</option>
								<option value="2">Twin Room</option>
								<option value="3">Double Room</option>
								<option value="4">Delux Room</option>
								<option value="5">Suite Room</option>
								<option value="6">President Room</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>����</label></td>
						<td>
							<select class="form-control" id="limitNum" name="limitNum">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="n">10�� �ʰ�</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>����</label></td>
						<td><input type="text" class="form-control" name="price" id="price"></td>
						<td align="left" width="150px"><p>ex) 120,000</p></td>
					</tr>
					<tr>
						<td><label>ħ��</label></td>
						<td><input type="text" class="form-control" name="bed" id="bed"></td>
					</tr>
					<tr>
						<td><label>��</label></td>
						<td>
							<select class="form-control" id="floor" name="floor">
								<option value="1">1F</option>
								<option value="2">2F</option>
								<option value="3">3F</option>
								<option value="4">4F</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>���� ����</label></td>
						<td>
			                <input type="file" id="file" name="file">
				        </td>
				</table>
				<div id="forButton" align="center">
					<button type="submit" id="regBtn" class="btn btn-danger btn-md" onclick="return addRoom()">���</button>
					<button type="reset" id="resetBtn" class="btn btn-default btn-md">���</button>
				</div>
			</form>
		</div>
	</div>
	<!-- ���� ���� �� -->
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>