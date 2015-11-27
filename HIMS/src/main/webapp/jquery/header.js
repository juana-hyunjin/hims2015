$(document).ready(function(){
 
	$("ul.subnav").parent().append("<span></span>"); //드롭다운 버튼을 위한 Span태그를 subnav 셀렉터를 가지는 태그 마지막에 자바스크립트로 삽입한다. (Adds empty span tag after ul.subnav*)
 
	$("ul.topnav a.haveSub").hover(function() { //드롭다운 버튼을 눌렀을 때
 
		//Following events are applied to the subnav itself (moving subnav up and down)
		$(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click
 
		$(this).parent().hover(function() {
		}, function(){
			$(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up
		});
 
		//마우스가 메뉴에 올려지면 동작 (Hover events for the trigger)
		}).hover(function() {
			$(this).addClass("subhover"); //On hover over, add class "subhover"
		}, function(){	//마우스가 메뉴에서 벗어나면 동작
			$(this).removeClass("subhover"); //On hover out, remove class "subhover"
	});
 
});