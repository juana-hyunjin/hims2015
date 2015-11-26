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
<link rel="stylesheet" type="text/css" href="css/selectMember.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/rsv.png" style="width:23%; height:20%;">
	</div>
	<div class="container" align="center">
		<table id="searchSector" id="searchSector" align="center">
			 <tr>
			 	<td><label>검색 분류</label></td>
				<td>
					<select class="form-control" id="category" name="category">
						<option>이름</option>
						<option>아이디</option>
						<option>휴대폰</option>
						<option>생년월일</option>
						<option>등급</option>
					</select>
				</td>
				<td align="right"><label>종류</label></td>
				<td>
					<input type="text" class="form-control" name="bookNo" id="bookNo">
				</td>
				<td>
					<button type="button" class="btn btn-default btn-md">
	          		<span class="glyphicon glyphicon-search"></span> Search 
	       		     </button>
				</td>
			</tr>
		</table>
		<table class="table table-striped" align="center" id="resultSector">
			<thead>
				<tr>
					<th>이름</th>
					<th>휴대폰</th>
					<th>생년월일</th>
					<th>아이디</th>
					<th>이메일</th>
					<th>이용횟수</th>
					<th>등급</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>주현진</td>
					<td>01047069550</td>
					<td>910823</td>
					<td>jhj910823</td>
					<td>jhj910823@naver.com</td>
					<td>3</td>
					<td>G</td>
				</tr>
				<tr>
					<td>주현진</td>
					<td>01047069550</td>
					<td>910823</td>
					<td>jhj910823</td>
					<td>jhj910823@naver.com</td>
					<td>3</td>
					<td>G</td>
				</tr>
				<tr>
					<td>주현진</td>
					<td>01047069550</td>
					<td>910823</td>
					<td>jhj910823</td>
					<td>jhj910823@naver.com</td>
					<td>3</td>
					<td>G</td>
				</tr>
				<tr>
					<td>주현진</td>
					<td>01047069550</td>
					<td>910823</td>
					<td>jhj910823</td>
					<td>jhj910823@naver.com</td>
					<td>3</td>
					<td>G</td>
				</tr>								
			</tbody>
		</table>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>