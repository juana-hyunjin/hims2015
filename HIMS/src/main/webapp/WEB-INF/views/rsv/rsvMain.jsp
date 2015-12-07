<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>호텔통합관리시스템(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/rsvMain.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script language=JavaScript src='js/rsvMain.js' charset='euc-kr'></script>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<div class="viewlogo" align="center">
	<img src="images/rsv.png" style="width:23%; height:20%;">
</div>
<!-- 본문영역 시작 -->
<div class="content" align="center">
	<form id="searchForm" name="searchForm" action="rsv.search.do" method="post">
		<table>
			<tr>
				<td align="right"><label>예약번호</label></td>
				<td width="300px"><input type="text" class="form-control" name="bookNo" id="bookNo"></td>
				<td align="left">
					<button type="button" class="btn btn-default btn-md" onclick="return exeAction('rsv.search.do')">
	          		<span class="glyphicon glyphicon-search"></span> Search 
	       		     </button>
				</td>
			</tr>
		</table>
	</form>
		<hr width="700px">
	<form id="resultForm" name="resultForm" action="rsv.rsvMainView.do" method="post">
		<table class="resultSector" id="searchData" name="searchData">
			<tr>
				<td><label>이름</label></td>
				<td><input type="text" id="username" name="username" readOnly></td>
				<td><label>휴대폰</label></td>
				<td><input type="text" id="mobile" name="mobile" readOnly></td>
				<td><label>방 종류</label></td>
				<td><input type="text" id="kind" name="kind" readOnly></td>
			</tr>
			<tr>
				<td><label>체크인</label></td>
				<td><input type="text" id="checkin" name="checkin" readOnly></td>
				<td><label>체크아웃</label></td>
				<td><input type="text" id="checkout" name="checkout" readOnly></td>
				<td><label>인원수</label></td>
				<td><input type="text" id="headCount" name="headCount" readOnly></td>
			</tr>
			<tr>
				<td><label>메모</label></td>
				<td colspan="3"><input type="text" class="form-control" id="memo" name="memo" readOnly></td>
			</tr>
			<tr id="assignYN" >
				<td><label>층</label></td>
				<td>
					<select class="form-control" id="floor" name="floor" disabled onChange="roomSearch(this.value)">
						<option selected="selected">선택</option>
						<option value="1">1F</option>
						<option value="2">2F</option>
						<option value="3">3F</option>
						<option value="4">4F</option>
					</select>
				</td>
				<td><label>호수</label></td>
				<td>
					<select class="form-control" id="room" name="room" disabled>
						<option selected="selected" disabled>선택</option>
					</select>
				</td>
				<td colspan="2" align="left">
					<button id="assignBtn" type="submit" class="btn btn-danger btn-md" onclick="return assignRoom()">배정하기</button>
					<button id="chkoutBtn" class="btn btn-success btn-md" onclick="checkoutRoom()">체크아웃</button>
				</td>
			</tr>
			<tr>
				<td></td>
				<td colspan="3" align="left"><label class="assignMsg" id="assignMsg"> &nbsp; </label></td>
			</tr>
		</table>
	</form>
</div>
<!-- 본문 영역 끝 -->
<jsp:include page="../common/footer.jsp" />
</body>
</html>