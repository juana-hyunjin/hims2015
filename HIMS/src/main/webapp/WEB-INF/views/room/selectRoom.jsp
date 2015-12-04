<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>호텔통합관리시스템(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/selectRoom.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script language=JavaScript src='js/selectRoom.js' charset='euc-kr'></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/roomlogo.png" style="width:23%; height:20%;">
	</div>
	<!-- 본문 영역 시작 -->
	<div class="container" align="center">
		<div class="roomSearch">
			<table id="selectFloor">
				<tr>
					<td></td>
					<td>
						<img src="images/addRoomBtn.png" width="110px" height="50px" align="right" onclick="location.href='room.addRoomView.do'">
					</td>					
				</tr>
				<tr></tr>
				<tr>
					<td><label>층</label></td>
					<td>
						<select class="form-control" id="floor" name="floor" onChange="searchRoomInfo(this.value)">
							<option selected="selected">선택</option>
							<option value="1">1F</option>
							<option value="2">2F</option>
							<option value="3">3F</option>
							<option value="4">4F</option>
						</select>
					</td>
				</tr>
			</table>
			<img id="floormap">
			<table class="table table-striped" id="resultSector" align="center">
				<thead>
					<tr>
						<th>객실번호</th>
						<th>종류</th>
						<th>정원</th>
						<th>가격</th>
						<th>침대</th>
						<th>층</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!-- 본문 영역 끝 -->
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>