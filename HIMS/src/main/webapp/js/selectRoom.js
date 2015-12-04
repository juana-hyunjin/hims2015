/**
 * 층 선택시 예약가능한 객실번호 옵션에 추가
 * @param floorNum
 */
function searchRoomInfo(floorNum) {
	var floor = floorNum;
	$('#floormap').attr('src', '');
	$('#floormap').attr('width', '0');
	$('#floormap').attr('height', '0');
	$.ajax({
		url: 'room.searchRoomlist.do',
		type: 'post',
		dataType: 'json',
		data: {
			"floor" : floor
		},
		success: function(json) {
			$('#resultSector > tbody > tr').remove();
			if(floorNum==4) {
				$('#floormap').attr('src', 'images/map4f.png');
				$('#floormap').attr('width', '100%');
				$('#floormap').attr('height', '50%');
			}
			var table = document.getElementById("resultSector");
			for(var i=0; i<json.length; i++) {
				var roomNo = json[i].roomNo;
				var typeName = json[i].typeName;
				var price = json[i].price;
				var limitNum = json[i].limitNum;
				var bed = json[i].bed;
				var floor = floorNum;
				$('#resultSector').append('<tr> <td>'+ roomNo +'</td> <td>'+ typeName +'</td><td>'+ limitNum +'</td> <td>'+ price +'</td> <td>'+ bed +'</td> <td>'+ floor +'</td> </tr>');
			}
		}
	});
}