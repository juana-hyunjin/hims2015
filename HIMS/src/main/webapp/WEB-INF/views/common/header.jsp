<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/earlyaccess/kopubbatang.css' rel='stylesheet' type='text/css'>
<title></title>
<link rel="stylesheet" type="text/css" href="css/header.css"/>
<script type="text/javascript" src="./jquery.js"></script>
<script src='jquery/header.js'></script>
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
		  <ul class="topnav">
		     <li><a href="rsv.rsvMainView.do">예약관리</a></li>
		     <li>
		     	<a class="haveSub" href="#">시설관리&nbsp;<img src="images/submenu.png" width="20px" height="17px"> 
		     	</a>
		     	<ul class="subnav">
		     		<li><a href="room.room.do">객실관리</a></li>
		     		<li><a href="#">부대시설관리</a></li>
		     	</ul>
		     </li>
		     <li><a href="member.member.do">회원관리</a></li>
		     <li><a href="#">이벤트관리</a></li>
		     <li><a href="#">통계</a></li>
		  </ul>
		</div>
	</div>
	</div>
</body>
</html>