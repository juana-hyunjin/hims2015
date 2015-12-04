window.onload = function() {
	$.ajax({
		url: 'event.selectTimeEvent.do',
		type: 'post',
		dataType: 'json',
		success: function(json) {
			$('#eventlist > tbody > tr').remove();
			for(var i=0; i<json.length; i++) {
				var beaconMinor = json[i].beaconMinor;
				var facName = json[i].facName;
				var eventTime = json[i].eventTime;
				var winner = json[i].winner;
				$('#eventlist').append('<tbody><tr><td>' + beaconMinor + 
						'</td><td>' + facName + '</td><td>' + eventTime + 
						'</td><td>' + winner + 
						'</td><td><button class="btn btn-default btn-md" onclick="deleteEvent()" name="deleteEvent" id="deleteEvent">delete</button></td></tr></tbody>');
			}
		}
	});
}

/**
 * 라디오버튼(time, event)선택 여부에 따라서 해당 데이터 가져오기
 */

function checkedValue(eventType) {
	if(eventType == "TIME") {
		$('#eventlist > tbody > tr').remove();
		$.ajax({
			url: 'event.selectTimeEvent.do',
			type: 'post',
			dataType: 'json',
			success: function(json) {
				$('#eventlist > tbody > tr').remove();
				for(var i=0; i<json.length; i++) {
					var beaconMinor = json[i].beaconMinor;
					var facName = json[i].facName;
					var eventTime = json[i].eventTime;
					var winner = json[i].winner;
					$('#eventlist').append('<tbody><tr><td>' + beaconMinor + 
							'</td><td>' + facName + '</td><td>' + eventTime + 
							'</td><td>' + winner + 
							'</td><td><button class="btn btn-default btn-md" onclick="deleteEvent()" name="deleteEvent" id="deleteEvent">delete</button></td></tr></tbody>');
				}
			}
		});
	}
	if(eventType == "COUNT") {
		$('#eventlist > tbody > tr').remove();
	}
}

/**
 * 이벤트를 추가하는 메서드
 */
function addEvent() {
	var beaconMinor = document.getElementById("beaconMinor").value;
	var facName = document.getElementById("facName").value;
	var hour = document.getElementById("hour").value;
	var minute = document.getElementById("minute").value;
	var winner = "";
	var eventTime = hour+":"+minute;
	if(hour == "hour" | minute == "minute") {
		alert("시간과 분을 설정해주십시오.");
		return false
	}
	if(beaconMinor == "") {
		alert("Beacon Minor를 설정해주십시오.");
		return false;
	}
	if(facName == "") {
		alert("부대시설 이름을 설정해주십시오.");
		return false;
	}
	$.ajax({
		url: 'event.addTimeEvent.do',
		type: 'post',
		dataType: 'json',
		data: {
			"beaconMinor" : beaconMinor,
			"facName" : facName,
			"eventTime" : eventTime,
			"winner" : winner
		},
		success: function(json) {
			alert(json[0].beaconMinor);
			var beaconMinor = json[0].beaconMinor;
			var facName = json[0].facName;
			var eventTime = json[0].eventTime;
			var winner = " ";
			$('#eventlist').append('<tbody><tr><td id="beaconMinor">' + json[0].beaconMinor + 
					'</td><td>' + json[0].facName + '</td><td>' + json[0].eventTime + 
					'</td><td>' + " " + 
					'</td><td><button class="btn btn-default btn-md" onclick="deleteEvent()" name="deleteEvent" id="deleteEvent">delete</button></td></tr></tbody>');
		}
	});
	location.reload();
}

/**
 * 행별로 이벤트를 삭제하는 메서드
 */
function deleteEvent() {
	var thisElement = window.event.srcElement;
	var thisTable = thisElement.parentNode.parentNode.parentNode.parentNode;
	var index = thisElement.parentNode.parentNode.rowIndex;
	var beaconMinor = thisTable.rows[index].cells[0].innerHTML;
	var eventTime = thisTable.rows[index].cells[2].innerHTML;
	$.ajax({
		url: 'event.deleteTimeEvent.do',
		type: 'post',
		dataType: 'json',
		data: {
			"beaconMinor" : beaconMinor,
			"eventTime" : eventTime
		}
	});
	location.reload();
}