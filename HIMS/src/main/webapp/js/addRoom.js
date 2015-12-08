function addRoom() {
	if(document.getElementById("roomNo").value=="") {
		alert('객실번호를 입력해주세요.');
		return false;
	}
	if(document.getElementById("typeName").value=="선택") {
		alert('객실종류를 선택해주세요.');
		return false;
	}
	if(document.getElementById("limitNum").value=="선택") {
		alert("객실의 정원을 지정해주세요.");
		return false;
	}
	if(document.getElementById("price").value=="") {
		alert("객실의 가격을 입력해주세요.");
		return false;
	}
	if(document.getElementById("bed").value=="") {
		alert('객실 침대의 종류와 갯수를 입력하세요.');
		return false;
	}
	if(document.getElementById("floor").value=="") {
		alert('층을 선택해주세요.');
		return false;
	}
	document.addForm.submit();
	return true;
}