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
<link rel="stylesheet" type="text/css" href="css/selectFacility.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/faclogo.png" style="width:23%; height:20%;">
	</div>
	<!-- 본문 영역 시작 -->
	<div class="container">
		<div class="facSearch">
			<img src="images/addFacBtn.png" width="110px" height="50px" align="right" onclick="location.href='facility.addFacView.do'">
			<table class="table table-striped" id="resultSector" align="center">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>정보</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>버거킹</td>
						<td>스노우치즈와퍼 짱짱</td>
					</tr>
					<tr>
						<td>1</td>
						<td>버거킹</td>
						<td>스노우치즈와퍼 짱짱</td>
					</tr>
					<tr>
						<td>1</td>
						<td>버거킹</td>
						<td>스노우치즈와퍼 짱짱</td>
					</tr>
					<tr>
						<td>1</td>
						<td>버거킹</td>
						<td>스노우치즈와퍼 짱짱</td>
					</tr>
					<tr>
						<td>1</td>
						<td>버거킹</td>
						<td>스노우치즈와퍼 짱짱</td>
					</tr>
				</tbody>
			</table>			
		</div>
	</div>
	<!-- 본문 영역 끝 -->
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>