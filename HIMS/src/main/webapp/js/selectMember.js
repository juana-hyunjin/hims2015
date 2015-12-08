window.onload = function() {
	$('#resultSector').hide();
}

/**
 * ī�װ����� ȸ���� �˻��ϴ� ���
 */
function selectMember() {
	var category = document.getElementById("category").value;
	var data = document.getElementById("searchData").value;
	if(category == "����") {
		alert('�˻��� ������ �������ּ���');
		return false;
	}
	$.ajax({
		url: 'member.infoSearch.do',
		type: 'post',
		dataType: 'json',
		data: {
			"category": category,
			"searchData": data
		},
		success: function(json) {
			$('#resultSector').show();
			$('#resultSector > tbody> tr').remove();
			for(var i=0; i<json.length; i++) {
				var username = json[i].username;
				var mobile = json[i].mobile;
				var birth = json[i].birth;
				var userid = json[i].userid;
				var email = json[i].email;
				var useCount = json[i].useCount;
				var grade = json[i].grade;
				$('#resultSector').append('<tr><td>' + username + 
						'</td><td>' + mobile + '</td><td>' + birth + 
						'</td><td>' + userid + 
						'</td><td>'+ email + '</td><td>' + useCount + '</td><td>' + grade +'</td></tr>');
			}
		}
	});
}

/**
 * ���� ������ ī�װ��� �����ϴ� �޼���
 * @param category
 */
function changeLabel(category) {
	$('#dataCategory').html(category);
}