/**
 * 예약번호 검색
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
			}
		});
	}
	return false;
}