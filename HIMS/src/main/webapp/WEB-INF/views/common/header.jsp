<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab' rel='stylesheet' type='text/css'>
<title></title>
<link rel="stylesheet" type="text/css" href="css/header.css"/>
</head>
<body>
	<div class="nav">
	<div class="header">
		<div class="logo">
		<img src="images/logo1.png" width="90%" height="100%" onclick="location.href='common.index.do'">
		</div>
		<div class="header-right">
			<div class="emergency">
				<div class="searchSector">
                  <form name="searchForm" action="schedule.search.do" method="post" class="navbar-form navbar-right" role="search">
                     <div class="input-group">
                        <input type="text" class="form-control" id="condition"
                           name="condition" placeholder="재난 메세지 입력">
                          <span class="input-group-btn">
                           <a href="#" class="btn btn-info btn-md" data-toggle="modal" data-target="#searchModal" id="searchBtn" style="background-color: #CC0000; border: 1px solid #CC0000;">
         					 <span class="glyphicon glyphicon-send"></span> Send
      					   </a>
                          </span>
                     </div>
                  </form>
               </div>
			</div>
			<div class="loginBtn">
				<img src="images/join.png" width="110px" height="40px" align="right" onclick="location.href='member.joinView.do'" >
				<img src="images/login.png" width="100px" height="40px" align="right" onclick="location.href='member.loginView.do'">
			</div>
		</div>
		<div class="menubar" align="center">
		  <ul>
		     <li>Managing ▼
		     	<ul>
		     		<li><a href="member.member.do">Member</a></li>
		     		<li><a href="#">Room</a></li>
		     		<li><a href="#">Facility</a></li>
		     	</ul>
		     </li>
		     <li><a href="rsv.rsvMainView.do">Reservation</a></li>
		     <li><a href="#">Event</a></li>
		     <li><a href="#">Statistic</a></li>
		  </ul>
		</div>
	</div>
	</div>
</body>
</html>