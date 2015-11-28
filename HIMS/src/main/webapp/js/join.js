/**
 * 회원가입 데이터 유효성 검사
 */
function exeAction(actionUrl) {
	var actionForm = document.getElementById("joinform");
	var userid = document.getElementById("userid").value;
	if (actionUrl == "member.checkid.do") {
		$.ajax({
			url : 'member.checkid.do',
			dataType : 'json',
			type : 'post',
			data : {
				"userid" : userid
			},
			success : function(check) {
				if (check['result'] == true) {
					$('#check1').attr('style', 'color:red');
					$('#check1').attr('style', 'font-size:8px');
					$('#check1').html("이미 사용하고 있는 아이디 입니다.");
				} else if (check['result'] == false) {
					$('#check1').attr('style', 'border:none');
					$('#check1').attr('style', 'color:green');
					$('#check1').html("사용 가능한 아이디 입니다.");
				}
			}
		});
	}
	return false;
}


function exeAction2(actionUrl) {
	var check = document.getElementById("joinOption1").getAttribute('name');
	var check2 = document.getElementById("joinOption2").getAttribute('name');
	if(actionUrl == "member.joinNext.do") {
		location.href="member.join.do";
	} else  {
		location.href="common.index.do";
	}
}

function clickEmail() {
	var email2 = document.getElementById("email2");
	var selectEmail = document.getElementById("email3").value;
	email2.setAttribute('value', selectEmail);
}


function nextfocus(takeMobile){
	if(takeMobile != "선택"){
		document.signUpForm.mobile2.focus();
		return false;
	}
}

function nextfocus2() {
	var mobile2 = document.joinform.mobile2.value;
	if(event.keyCode < 48 || event.keyCode > 57) {
		document.joinform.mobile2.value = mobile2.substring(0, mobile2.length-1);
		mobile2 = document.joinform.mobile2.value;
	}
	if(mobile2.length == 4) {
		document.joinform.mobile3.focus();
		return false;
	}
}

function checkNumber(srcElement) {
	var element = srcElement.value;
	
	if(event.keyCode < 48 || event.keyCode > 57){
		srcElement.value = element.substring(0, element.length-1);
		element = srcElement.value;
	}
}

function checkNumberAndShift(srcElement, count, nextElement) {
	var element = srcElement.value;
	var nextElement = nextElement;

	if(event.keyCode < 48 || event.keyCode > 57){
		srcElement.value = element.substring(0, element.length-1);
		element = srcElement.value;
	}

	if(element.length == count){
		nextElement.focus();
		return false;
	}
}

function warning(){
	var mobile1 = document.joinform.mobile1.value;
	if(mobile1=="선택"){
		alert('앞번호 선택하신 후 선택가능합니다.');
		document.joinform.mobile1.focus();
		return false;
	}
}	

function formValid() {
	var userid = document.joinform.userid.value;
	if (userid.length == "") {
		alert("아이디를 입력해주세요");
		document.joinform.userid.focus();
		return false;
	}
	var userpw = document.joinform.userpw.value;
	if (userpw.length < 4) {
		alert("비밀번호 4자 이상 입력해주세요");
		document.joinform.userpw.focus();
		return false;
	}
	var checkuserpw = document.joinform.checkuserpw.value;
	if (checkuserpw != userpw) {
		alert("비밀번호 재입력값이 비밀번호와 일치하지 않습니다.");
		document.joinform.checkuserpw.focus();
		return false;
	}
	var name = document.joinform.name.value;
	if (name.length == "") {
		alert("이름을 입력하세요");
		document.joinform.name.focus();
		return false;
	}
	var mobile2 = document.joinform.mobile2.value;
	if (mobile2.length < 3 || mobile2.length > 4) {
		alert("전화번호는 3자~4자 이내로 입력해주세요");
		document.joinform.mobile2.focus();
		return false;
	}
	var mobile3 = document.joinform.mobile3.value;
	if (mobile3.length < 4) {
		alert("전화번호는 4자리로 입력해 주세요");
		document.joinform.mobile3.focus();
		return false;
	}
	var email1 = document.joinform.email1.value;
	if (email1.length == "") {
		alert("메일을 입력하세요");
		document.joinform.email1.focus();
		return false;
	}
	var email2 = document.joinform.email2.value;
	if (email2.length == "") {
		alert("메일을 입력하세요");
		document.joinform.email2.focus();
		return false;
	}
	var answer = document.joinform.answer.value;
	if (answer.length == "") {
		alert("답변을 입력하세요");
		document.joinform.answer.focus();
		return false;
	}
}