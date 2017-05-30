$(document).ready(function() {
	$("#goodNumAdd").click(function() {
		addGoodNum(this);
	});
	$("#goodNumRemove").click(function() {
		removeGoodNum(this);
	});
	$("#newGood").keyup(function() {
		qeuryGoodInfo($(this).val());
	});
});

function addGoodNum(a) {
	var goodNumEle = $(a).siblings("#goodNums");
	var originalNum = parseInt(goodNumEle.val());
	if(originalNum > 0) {
		goodNumEle.val(originalNum + 1);
	}else{
		goodNumEle.val(1);
	}
	
}

function removeGoodNum(a) {
	var goodNumEle = $(a).siblings("#goodNums");
	var originalNum = parseInt(goodNumEle.val());
	if(originalNum > 1) {
		goodNumEle.val(originalNum - 1);
	}else{
		goodNumEle.val(1);
	}

}

function qeuryGoodInfo(data) {
	var pattern=new RegExp("[^0-9]","g");
	if(pattern.exec(data)==null){
		console.log(data);
	}
	
}