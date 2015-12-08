<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȣ�����հ����ý���(HIMS)</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<script language=JavaScript src='js/rsvMain.js' charset='euc-kr'></script>
<script language=JavaScript src='js/selectEvent.js' charset='euc-kr'></script>
</head>
<body>
<!-- ��� ���� -->
<header>
<jsp:include page="header.jsp" />
</header>
<!-- ���� ���� ����-->
<c:if test="${grade eq 'M'}">
	<c:if test="${howmanyAP > 0}">
		<script>
			alert('������ �ڰ��� ��û�� ȸ���� '+ ${howmanyAP} +'�� �ֽ��ϴ�.');
		</script>
	</c:if>
</c:if>
<div class="content" align="center">
  <div class="bottom">
  	<!-- ���ο� ���Ԥ��� ���������� ���� -->
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
				<td align="left" width="70px"><label>�����ȣ&nbsp;&nbsp;</label></td>
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
			<tr><td><label>�̸�</label></td></tr>
			<tr><td><input type="text" id="username" name="username" readOnly></td></tr>
			<tr><td><label>�޴���</label></td></tr>
			<tr><td><input type="text" id="mobile" name="mobile" readOnly></td></tr>
			<tr><td><label>�� ����</label></td></tr>
			<tr><td><input type="text" id="kind" name="kind" readOnly></td></tr>
			<tr><td><label>üũ��</label></td></tr>
			<tr><td><input type="text" id="checkin" name="checkin" readOnly></td></tr>
			<tr><td><label>üũ�ƿ�</label></td></tr>
			<tr><td><input type="text" id="checkout" name="checkout" readOnly></td></tr>
			<tr><td><label>�ο���</label></td></tr>
			<tr><td><input type="text" id="headCount" name="headCount" readOnly></td></tr>
			<tr><td><label>�޸�</label></td></tr>
			<tr><td><input type="text" class="form-control" id="memo" name="memo" readOnly></td></tr>
			<tr><td><label>��</label></td></tr>
			<tr><td>
				<select class="form-control" id="floor" name="floor" disabled onChange="roomSearch(this.value)">
					<option selected="selected">����</option>
					<option value="1">1F</option>
					<option value="2">2F</option>
					<option value="3">3F</option>
					<option value="4">4F</option>
				</select>
			</td></tr>
			<tr><td><label>ȣ��</label></td></tr>
			<tr><td>
				<select class="form-control" id="room" name="room" disabled>
					<option selected="selected" disabled>����</option>
				</select>
			</td></tr>
			<tr height="50px"><td>
				<button id="assignBtn" type="submit" class="btn btn-danger btn-md" onclick="return assignRoom()">�����ϱ�</button>
				<button id="chkoutBtn" class="btn btn-success btn-md" onclick="checkoutRoom()">üũ�ƿ�</button>
			</td></tr>
			<tr>
				<td colspan="3" align="left"><label class="assignMsg" id="assignMsg"> &nbsp; </label></td>
			</tr>
		</table>
	</form>
	</div>
  </div>
  <!-- ���ο� ���Ե� ���������� �� -->
  <!-- ���ο� ���Ե� �̺�Ʈ ���� ��� ���� -->
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
						<th width="100px">����</th>
						<th width="200px">�δ�ü�</th>
						<th width="200px">�ð�</th>
						<th width="100px">��÷��</th>
						<th></th>
					</tr>
				</thead>
			</table>
		</div>
		<!-- ȸ�� �Ұ� -->
		<div id="ourBusiness">
		  <div id="imagelogo2">
		  	<img src="images/business.png" width="30%" height="8%" align="left">
		  </div>			
		  <img src="images/hotelpics.jpg" width="60%" hegith="50%">
		</div>
   </div>
  <!-- ���ο� ���Ե� �̺�Ʈ ���� ��� �� -->
</div>
</div>
</section>
<!-- //���� ���� �� -->
<!-- Ǫ�� ���� -->
<footer>
<jsp:include page="footer.jsp" />
</footer>
</body>
</html>