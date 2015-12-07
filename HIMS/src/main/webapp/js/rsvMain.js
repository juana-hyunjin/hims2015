/**
 * 예약번호로 해당하는 데이터 검색
 * @param actionUrl
 * @returns {Boolean}
 */
function exeAction(actionUrl) {
	var actionForm = document.getElementById("searchForm");
	var bookNo = document.getElementById("bookNo").value;
	if(actionUrl == "rsv.search.do") {
		$.ajax({
			url: 'rsv.search.do',
			type: 'post',
			dataType : 'json',
			data: {
				"bookNo" : bookNo
			},
			success: function(json) {
				document.getElementById("username").value = json[0].username;
				document.getElementById("mobile").value = json[0].mobile;
				document.getElementById("kind").value = json[0].typeName;
				document.getElementById("checkin").value = json[0].chkInDate;
				document.getElementById("checkout").value = json[0].chkOutDate;
				document.getElementById("headCount").value = json[0].headCount;
				document.getElementById("memo").value = json[0].memo;
				document.getElementById("floor").disabled = false;
				if(json[0].username == "") {
					alert('해당 예약번호가 존재하지 않습니다.');
				}
				/* 방배정 여부확인 */
				if(json[0].roomNo!=0) {
					document.getElementById("floor").disabled = true;
					document.getElementById("room").disabled = true;
					$('#assignBtn').hide();
					$('#assignMsg').attr('style', 'font-size:18px');
					$('#assignMsg').attr('style', 'border: none');
					$('#assignMsg').attr('style', 'color: red');
					$('#assignMsg').html("This customer is already assigned to room No. " + json[0].roomNo + " :)");
					
				} else {
					$('#assignBtn').show();
					$('#assignMsg').html(" ");
				}  
			}
		});
	}

	return false;
}

/**
 * 층 선택시 예약가능한 객실번호 옵션에 추가
 * @param floorNum
 */
function roomSearch(floorNum) {
	var actionForm = document.getElementById("searchForm");
	var floor = floorNum;
	var bookNo = document.getElementById("bookNo").value;
	var room = document.getElementById("room");
	while(room.length>0) {
		for(var i=0; i<room.length; i++) {
			room.remove(i);
		}
	}
	$.ajax({
		url: 'rsv.searchAvailRoom.do',
		type: 'post',
		dataType: 'json',
		data: {
			"bookNo" : bookNo,
			"floor" : floor
		},
		success: function(json) {
			document.getElementById("room").disabled = false;
			var room = document.getElementById("room");
			for(var i=0; i<json.length; i++) {
				var newOp = document.createElement('option');
				newOp.text = json[i].roomNo;
				newOp.value = json[i].roomNo;
				room.options.add(newOp);
			}
		}
	});
}

/**
 * 선택한 객실번호로 방 배정하는 메서드
 */
function assignRoom() {
	var actionForm = document.getElementById("resultForm");
	var roomNo = document.getElementById("room").value;
	var bookNo = document.getElementById("bookNo").value;
	$.ajax({
		url: 'rsv.assignRoom.do',
		type: 'post',
		dataType: 'json',
		data: {
			"bookNo" : bookNo,
			"roomNo" : roomNo
		},
		success: function() {
			document.resultForm.submit();
			return true;
		}
	});
	
}

/**
 * 체크아웃을 처리하는 함수
 */
function checkoutRoom() {
	var bookNo = document.getElementById("bookNo").value;
	$.ajax({
		url: 'rsv.checkout.do',
		type: 'post',
		dataType: 'json',
		data: {
			"bookNo" : bookNo
		}
	});
	alert('Check out complete.');
}

