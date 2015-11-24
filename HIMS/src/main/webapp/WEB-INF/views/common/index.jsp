<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>호텔 통합 관리 시스템(HIMS)</title>
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.carousel-inner > .item > img,
.carousel-inner > .item > a > img {
    width: 100%;
    margin: auto;
}
.content {
	align: center;
	width: auto;
	height: auto;
	margin-top: 2%;
}
.bottom {
	width: auto;
}
#myCarousel {
	width: 40%;
}
.reservation {
	float: left;
	width: 30%;
	background-color: red;
}
.business {
	float: left;
	width: 30%;
	background-color: yellow;
}
.statistics {
	float: right;
	width: 30%;
	background-color: green;
}
</style>
</head>
<body>
<!-- 헤더 영역 -->
<header>
<jsp:include page="header.jsp" />
</header>
<!-- 본문 영역 시작-->
<section>
<div class="content" align="center">
  <br>
  <div class="top">
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner" role="listbox">
	      <div class="item active">
	        <img src="images/main1.JPG" alt="one" width="650px" height="450px">
	      </div>
	
	      <div class="item">
	        <img src="images/main2.JPG" alt="two" width="650px" height="450px">
	      </div>
	    
	      <div class="item">
	        <img src="images/main3.JPG" alt="three" width="650px" height="450px">
	      </div>
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
  </div>
  <div class="bottom">
	  <div class="reservation">
	 	 <img src="images/reservation.png" width="30%" height="20%" align="left">
	  </div>
	  <div class="business">
	  	 <img src="images/business.png" width="31%" height="20%" align="left">
	  </div>
	  <div class="statistics">
	  	<img src="images/statistics.png" width="28%" height="20%" align="left">
	  </div>
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