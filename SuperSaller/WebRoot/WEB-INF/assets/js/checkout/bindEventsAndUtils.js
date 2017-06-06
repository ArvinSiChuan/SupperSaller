var addNewGood; // 添加货物行标记

var addGoodNumBtn; // 添加货物数量标记
var removeGoodNumBtn; // 减少货物数量标记
var goodNumBox; // 修改货物的货物数量标记
var addGoodToListBtn;

var newGoodBox; // 添加货物的货物号输入框
var possibleGoodsList; // 可选货物列表
var newGoodRowPass = false;

var csrfHeader;

$(document).ready(function() {
	orderID = null;
	// get usually used elements
	addNewGood = $("#addNewGood");
	addGoodNumBtn = addNewGood
		.children("td[name='goodNums']")
		.children("input[name='goodNumAdd']");
	removeGoodNumBtn = addGoodNumBtn.siblings("input[name='goodNumRemove']");
	goodNumBox = addGoodNumBtn.siblings("input[name='goodNums']");
	newGoodBox = addNewGood
		.children("td[name='newGood']")
		.children("input[name='newGood']");
	possibleGoodsList = newGoodBox.siblings("div[name='possibleGoods']");
	addGoodToListBtn = $("#addToGoodListBtn");

	addedList = $("tbody");

	// read the csrf token
	csrfHeader = getHeaderToken();

	$("#logOut").click(function(){
		doAjaxLogOut();
	});
	
	// focus on inputbox
	foucusNewGoodBox();

	// bind click event for add and remove good nums
	addGoodNumBtn.click(function() {
		addGoodNum(goodNumBox);
		refreshSubTotal();
	});
	removeGoodNumBtn.click(function() {
		removeGoodNum(goodNumBox);
		refreshSubTotal();
	});
	goodNumBox.on('input', function() {
		goodNumBox.css("color", "black");
		refreshSubTotal();
	});

	// bind input event for newGoodBox
	newGoodBox.on('input', function() {
		checkNewGoodBox();
	});

	// bind addToGoodListBtn
	addGoodToListBtn.click(function() {
		if(newGoodRowPass) {
			addGoodToList();
			resetNewGoodRow();
		} else {
			addNewGood.children("td[name='comments']")
				.html("<span style='color:red;font-weight:bolder;'>商品添加未完成</span>");
			doTwinkleAnimate(addNewGood.children("td[name='comments']"), 3);
		}
	});

	$("#cancelOrderBtn").click(function() {

	})

	$("#beginPaymentBtn").click(function() {

	})
});