
window.onload = function () {
	$('#resultSpace').hide();
}

/**
 * 층 선택시 사용중인 객실을 표현하는 메서드
 * @param floorNum
 */
function selectFloor(floorNum) {
	var floor = floorNum;
	$('#resultSector > tbody > tr').remove();
	$('#monitorSector > img').hide();
	$('#floormap').attr('src', '');
	$('#floormap').attr('width', '0');
	$('#floormap').attr('height', '0');
	$.ajax({
		url: 'room.monitoring.do',
		type: 'post',
		dataType: 'json',
		data: {
			"floor" : floor
		},
		success: function(json) {
			if(floorNum == 1) {
				$('#monitorSector').css('background-image', 'url(images/map1f.png)');
				$('#monitorSector').css('background-size', '100% 100%');
			} else if (floorNum == 2) {
				$('#monitorSector').css('background-image', 'url(images/map2f.png)');
				$('#monitorSector').css('background-size', '100% 100%');
			} else if (floorNum == 3) {
				$('#monitorSector').css('background-image', 'url(images/map3f.png)');
				$('#monitorSector').css('background-size', '100% 100%');
			} else if (floorNum == 4) {
				$('#monitorSector').css('background-image', 'url(images/4fmap.png)');
				$('#monitorSector').css('background-size', '100% 100%');
				$('#monitorSector > img').show();
			}
			for(var i=0; i<json.length; i++) {
				if(json[i].availability == "X") {
					if(json[i].roomNo == '401') {
						$('#floormap1').attr('src', 'images/401f.JPG');
						$('#floormap1').attr('width', '45px');
						$('#floormap1').attr('height', '150px');
						$('#floormap1').css('position', 'absolute');
						$('#floormap1').css('top', '662px');
						$('#floormap1').css('left', '605px');
					}
					if(json[i].roomNo == '402') {
						$('#floormap2').attr('src', 'images/402f.JPG');
						$('#floormap2').attr('width', '45px');
						$('#floormap2').attr('height', '100px');
						$('#floormap2').css('position', 'absolute');
						$('#floormap2').css('top', '567px');
						$('#floormap2').css('left', '605px');						
					}
					if(json[i].roomNo == '403') {
						$('#floormap3').attr('src', 'images/403f.JPG');
						$('#floormap3').attr('width', '45px');
						$('#floormap3').attr('height', '175px');
						$('#floormap3').css('position', 'absolute');
						$('#floormap3').css('top', '390px');
						$('#floormap3').css('left', '605px');				
					}
					if(json[i].roomNo == '404') {
						$('#floormap4').attr('src', 'images/404f.JPG');
						$('#floormap4').attr('width', '80px');
						$('#floormap4').attr('height', '270px');
						$('#floormap4').css('position', 'absolute');
						$('#floormap4').css('top', '390px');
						$('#floormap4').css('left', '797px');						
					}
					if(json[i].roomNo == '405') {
						$('#floormap5').attr('src', 'images/405f.JPG');
						$('#floormap5').attr('width', '110px');
						$('#floormap5').attr('height', '94px');
						$('#floormap5').css('position', 'absolute');
						$('#floormap5').css('top', '715px');
						$('#floormap5').css('left', '881px');						
					}
					if(json[i].roomNo == '406') {
						$('#floormap6').attr('src', 'images/406f.JPG');
						$('#floormap6').attr('width', '110px');
						$('#floormap6').attr('height', '270px');
						$('#floormap6').css('position', 'absolute');
						$('#floormap6').css('top', '390px');
						$('#floormap6').css('left', '880px');						
					}
					if(json[i].roomNo == '407') {
						$('#floormap7').attr('src', 'images/407f.JPG');
						$('#floormap7').attr('width', '90px');
						$('#floormap7').attr('height', '94px');
						$('#floormap7').css('position', 'absolute');
						$('#floormap7').css('top', '715px');
						$('#floormap7').css('left', '995px');						
					}
					if(json[i].roomNo == '408') {
						$('#floormap8').attr('src', 'images/408f.JPG');
						$('#floormap8').attr('width', '105px');
						$('#floormap8').attr('height', '270px');
						$('#floormap8').css('position', 'absolute');
						$('#floormap8').css('top', '390px');
						$('#floormap8').css('left', '990px');						
					}
					if(json[i].roomNo == '409') {
						$('#floormap9').attr('src', 'images/409f.JPG');
						$('#floormap9').attr('width', '120px');
						$('#floormap9').attr('height', '90px');
						$('#floormap9').css('position', 'absolute');
						$('#floormap9').css('top', '575px');
						$('#floormap9').css('left', '1118px');						
					}
					if(json[i].roomNo == '410') {
						$('#floormap10').attr('src', 'images/410f.JPG');
						$('#floormap10').attr('width', '120px');
						$('#floormap10').attr('height', '95px');
						$('#floormap10').css('position', 'absolute');
						$('#floormap10').css('top', '480px');
						$('#floormap10').css('left', '1118px');						
					}
					if(json[i].roomNo == '411') {
						$('#floormap11').attr('src', 'images/411f.JPG');
						$('#floormap11').attr('width', '120px');
						$('#floormap11').attr('height', '89px');
						$('#floormap11').css('position', 'absolute');
						$('#floormap11').css('top', '391px');
						$('#floormap11').css('left', '1118px');			
					}
				}
			}
			
		}
	});
}

/**
 * 사용중인 객실의 예약정보를 출력하는 기능의 메서드
 */
function monitoringInfo(){
	var floor = document.getElementById("floor").value;
	$.ajax({
		url: 'room.monitoringInfo.do',
		type: 'post',
		dataType: 'json',
		data: {
			"floor" : floor
		},
		success: function(json) {
			$('#resultSector > tbody > tr').remove();
			$('#resultSpace').show();
			for(var i=0; i<json.length; i++) {
				var roomNo = json[i].roomNo;
				var username = json[i].username;
				var userid = json[i].userid;
				var chkin = json[i].chkInDate;
				var chkout = json[i].chkOutDate;
				$('#resultSector').append('<tr> <td>'+ roomNo +'</td> <td>' + username + '</td><td>' + userid +'</td><td>'+ chkin +'</td></tr>');
			}
		}
	});
}