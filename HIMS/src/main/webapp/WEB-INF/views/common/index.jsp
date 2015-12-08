<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>호텔통합관리시스템(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<script language=JavaScript src='js/rsvMain.js' charset='euc-kr'></script>
<script language=JavaScript src='js/selectEvent.js' charset='euc-kr'></script>
</head>
<body>
<!-- 헤더 영역 -->
<header>
<jsp:include page="header.jsp" />
</header>
<!-- 본문 영역 시작-->
<c:if test="${grade eq 'M'}">
	<c:if test="${howmanyAP > 0}">
		<script>
			alert('관리자 자격을 신청한 회원이 '+ ${howmanyAP} +'명 있습니다.');
		</script>
	</c:if>
</c:if>
<div class="content" align="center">
  <div class="bottom">
  	<!-- 메인에 삽입ㅇ된 예약관리기능 시작 -->
	  <div class="reservation">
	  <div id="imagelogo">
	 	 <img src="images/reservation.png" width="40%" height="20%" align="left">
	 	 <img src="images/more.png" width="50px" height="40px" align="left" onclick="location.href='rsv.rsvMainView.do'">
	  </div>
	  <br><br><br>
	  <div id="subRsv">	 
	  	<form id="searchForm" name="searchForm" action="rsv.search.do" method="post">
		<table id="searchSector" align="left">
			<tr>
				<td align="left" width="70px"><label>예약번호&nbsp;&nbsp;</label></td>
				<td  width="200px"><input type="text" class="form-control" name="bookNo" id="bookNo"></td>
				<td>&nbsp;&nbsp;</td>
				<td>
					<button type="button" class="btn btn-default btn-md" onclick="return exeAction('rsv.search.do')">
	          		<span class="glyphicon glyphicon-search"></span> Search 
	       		     </button>
				</td>
			</tr>
		</table>
	</form>
		<hr width="1150px">
	<form id="resultForm" name="resultForm" action="rsv.rsvMainView.do" method="post">
		<table class="resultSector" id="searchData" name="searchData">
			<tr><td><label>이름</label></td></tr>
			<tr><td><input type="text" id="username" name="username" readOnly></td></tr>
			<tr><td><label>휴대폰</label></td></tr>
			<tr><td><input type="text" id="mobile" name="mobile" readOnly></td></tr>
			<tr><td><label>방 종류</label></td></tr>
			<tr><td><input type="text" id="kind" name="kind" readOnly></td></tr>
			<tr><td><label>체크인</label></td></tr>
			<tr><td><input type="text" id="checkin" name="checkin" readOnly></td></tr>
			<tr><td><label>체크아웃</label></td></tr>
			<tr><td><input type="text" id="checkout" name="checkout" readOnly></td></tr>
			<tr><td><label>인원수</label></td></tr>
			<tr><td><input type="text" id="headCount" name="headCount" readOnly></td></tr>
			<tr><td><label>메모</label></td></tr>
			<tr><td><input type="text" class="form-control" id="memo" name="memo" readOnly></td></tr>
			<tr><td><label>층</label></td></tr>
			<tr><td>
				<select class="form-control" id="floor" name="floor" disabled onChange="roomSearch(this.value)">
					<option selected="selected">선택</option>
					<option value="1">1F</option>
					<option value="2">2F</option>
					<option value="3">3F</option>
					<option value="4">4F</option>
				</select>
			</td></tr>
			<tr><td><label>호수</label></td></tr>
			<tr><td>
				<select class="form-control" id="room" name="room" disabled>
					<option selected="selected" disabled>선택</option>
				</select>
			</td></tr>
			<tr height="50px"><td>
				<button id="assignBtn" type="submit" class="btn btn-danger btn-md" onclick="return assignRoom()">배정하기</button>
				<button id="chkoutBtn" class="btn btn-success btn-md" onclick="checkoutRoom()">체크아웃</button>
			</td></tr>
			<tr>
				<td colspan="3" align="left"><label class="assignMsg" id="assignMsg"> &nbsp; </label></td>
			</tr>
		</table>
	</form>
	</div>
  </div>
  <!-- 메인에 삽입된 예약관리기능 끝 -->
  <!-- 메인에 삽입된 이벤트 관리 기능 시작 -->
   <div class="event">
	  <div id="imagelogo2">
	  	<img src="images/eventlist.png" width="25%" height="8%" align="left">
	 	 <img src="images/more.png" width="50px" height="40px" align="left" onclick="location.href='event.selectEvent.do'">
	  </div>
	  	<br><br><br>
	  		<div class="eventSearch">
			<div class="selectType">
				<label>
				<input type="radio" class="radiobox" name="selectType" 
						value="TIME" onChange="checkedValue(this.value)" checked>
				 TIME EVENT
				 </label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<label>
				<input type="radio" class="radiobox"  name="selectType" 
						value="COUNT" onChange="checkedValue(this.value)"> 
				COUNT EVENT
				</label>
			</div>
			<table id="eventlist">
				<thead>
					<tr>
						<th width="100px">비콘</th>
						<th width="200px">부대시설</th>
						<th width="200px">시간</th>
						<th width="100px">당첨자</th>
						<th></th>
					</tr>
				</thead>
			</table>
		</div>
		<!-- 회사 소개 -->
		<div id="ourBusiness">
		  <div id="imagelogo2">
		  	<img src="images/business.png" width="30%" height="8%" align="left">
		  </div>			
		  <img src="images/hotelpics.jpg" width="60%" hegith="50%">
		</div>
   </div>
  <!-- 메인에 삽입된 이벤트 관리 기능 끝 -->
</div>
</div>
</section>
<!-- //본문 영역 끝 -->
<!-- 푸터 영역 -->
<footer>
<jsp:include page="footer.jsp" />
</footer>
</body>
</html>