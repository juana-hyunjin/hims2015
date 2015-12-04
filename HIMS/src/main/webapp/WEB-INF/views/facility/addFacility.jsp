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
<link rel="stylesheet" type="text/css" href="css/addFacility.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/faclogo.png" style="width:23%; height:20%;">
	</div>
	<!-- 본문 영역 시작 -->
	<div class="container" align="center">
		<div class="addSector">
		<hr width="600px">
			<form id="addForm" method="post" action="room.addRoom.do" enctype="multipart/form-data">
				<table id="addFac" class="addFac" align="center">
					<tr>
						<td width="100px"><label>이름</label></td>
						<td><input type="text" class="form-control" name="roomNo" id="roomNo"></td>
					</tr>
					<tr>
						<td><label>정보</label></td>
						<td><textarea class="form-control" name="info" id="info"></textarea></td>
					</tr>
					<tr>
						<td><label>객실 사진</label></td>
						<td><input class="form-control" id="files-upload" type="file" multiple></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button type="submit" id="regBtn" class="btn btn-danger btn-lg">등록</button>
							<button type="reset" id="resetBtn" class="btn btn-default btn-lg">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- 본문 영역 끝 -->
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>