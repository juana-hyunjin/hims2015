<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȣ�����հ����ý���(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/monitoring.css">
<script language=JavaScript src='js/monitoring.js' charset='euc-kr'></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/monitoringlogo.png" style="width:23%; height:20%;">
	</div>
	<!-- ���� ���� ���� -->
	<div class="container" align="center">
			<div class="roomSearch">
			<table id="selectFloor">
				<tr>
					<td><label>��</label></td>
					<td>
						<select class="form-control" id="floor" name="floor" onChange="selectFloor(this.value)">
							<option selected="selected">����</option>
							<option value="1">1F</option>
							<option value="2">2F</option>
							<option value="3">3F</option>
							<option value="4">4F</option>
						</select>
					</td>
					<td width="80px" align="right">
						<button class="btn btn-danger btn-md" onClick="monitoringInfo()">���������� ��ȸ</button>
					</td>
				</tr>
			</table>
			<div id="monitorSector">
				<img id="floormap1">
				<img id="floormap2">
				<img id="floormap3">
				<img id="floormap4">
				<img id="floormap5">
				<img id="floormap6">
				<img id="floormap7">
				<img id="floormap8">
				<img id="floormap9">
				<img id="floormap10">
				<img id="floormap11">
			</div>
			</div>
		<div id="resultSpace">
			<table class="table table-striped" id="resultSector" align="center">
				<thead>
					<tr>
						<th>���ǹ�ȣ</th>
						<th>����� �̸�</th>
						<th>����� ���̵�</th>
						<th>üũ�� ��¥</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!-- ���� ���� �� -->
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>