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
<link rel="stylesheet" type="text/css" href="css/selectEvent.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script language=JavaScript src='js/selectEvent.js' charset='euc-kr'></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="viewlogo" align="center">
	<img src="images/eventlogo.png" style="width:23%; height:20%;">
	</div>
	<!-- 본문 영역 시작 -->
	<div class="container" align="center">
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
			<table id="addEventSector">
				<tr>
					<td width="100px">
							<select id="beaconMinor" name="beaconMinor" class="form-control" onChange="selectFac(this.value)">
								<option selected>선택</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
							</select>
					</td>
					<td width="200px">
						<select class="form-control" name="facName" id="facName">
							<option selected>선택</option>
						</select>
					</td>
					<td width="200px">
						<select id="hour" name="hour" style="width:70px;height:30px;" >
							<option value="hour" selected="selected">시간</option>
							<option value="00">00</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
						</select>
						<label>&nbsp;:&nbsp;</label>
						<select id="minute" name="minute" style="width:70px;height:30px;" >
							<option value="minute" selected="selected">분</option>
							<option value="00">00</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="21">31</option>
							<option value="22">32</option>
							<option value="23">33</option>
							<option value="24">34</option>
							<option value="25">35</option>
							<option value="26">36</option>
							<option value="27">37</option>
							<option value="28">38</option>
							<option value="29">39</option>
							<option value="30">40</option>
							<option value="21">41</option>
							<option value="22">42</option>
							<option value="23">43</option>
							<option value="24">44</option>
							<option value="25">45</option>
							<option value="26">46</option>
							<option value="27">47</option>
							<option value="28">48</option>
							<option value="29">49</option>
							<option value="30">50</option>
							<option value="21">51</option>
							<option value="22">52</option>
							<option value="23">53</option>
							<option value="24">54</option>
							<option value="25">55</option>
							<option value="26">56</option>
							<option value="27">57</option>
							<option value="28">58</option>
							<option value="29">59</option>
						</select>
					</td>
					<td width="100px">
						<input type="text" class="form-control" name="winner" id="winner" readOnly>
					</td>
					<td>
						<button class="btn btn-danger btn-md" name="addEvent" id="addEvent" onclick="addEvent()">추가</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 본문 영역 끝 -->
	<div class="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>