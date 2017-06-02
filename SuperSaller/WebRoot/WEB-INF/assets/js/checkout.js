var addNewGood; // 添加货物行标记

var addGoodNumBtn; // 添加货物数量标记
var removeGoodNumBtn; // 减少货物数量标记
var goodNumBox; // 修改货物的货物数量标记

var newGoodBox; // 添加货物的货物号输入框
var possibleGoodsList; // 可选货物列表
var newGoodRowPass = false;

var csrfHeader;

$(document).ready(function() {
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

	// read the csrf token
	csrfHeader = getHeaderToken();

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
	$("#addToGoodListBtn").click(function() {
		if(newGoodRowPass) {
			resetNewGoodRow();
		} else {
			addNewGood.children("td[name='comments']")
				.html("<span style='color:red;font-weight:bolder;'>商品添加未完成</span>");
			doTwinkleAnimate(addNewGood.children("td[name='comments']"), 3);
		}
	});
});

// Illegal check for newGoodBox
function checkNewGoodBox() {
	var data = newGoodBox.val();
	var historyEle = newGoodBox.siblings("[name='history']");
	if(data.length == 0) {
		possibleGoodsList.empty();
		possibleGoodsList.append("<a href='#newGood' class='button small fit' onclick='foucusNewGoodBox();'>☝填写商品编码</a>");
		historyEle.val('');
	} else {
		var pattern = new RegExp("[^0-9]", "g");
		if(pattern.exec(data) == null) {
			qeuryGoodID(data);
			historyEle.val(data);
		} else {
			newGoodBox.val(historyEle.val());
			//possibleGoodsList.append("<a href='#' class='button small fit'><span style='color:red;'>✘</span>输入信息不合法</a>");
		}

	}
}

// focus for newGoodBox
function foucusNewGoodBox() {
	newGoodBox.focus();
}

function resetNewGoodRow() {
	newGoodBox.val('');
	foucusNewGoodBox();
	newGoodRowPass = false;
	addNewGood.children("td[name='comments']").empty();
	addNewGood.children("td[name='goodName']").empty();
	addNewGood.children("td[name='goodBrand']").empty();
	addNewGood.children("td[name='originalPrice']").empty();
	goodNumBox.val(1);
	addNewGood.children("td[name='discountedPrice']").empty();
	addNewGood.children("td[name='discountMoney']").empty();
	addNewGood.children("td[name='subTotal']").empty();
	addNewGood.children("td[name='comments']").empty();

}

// add one op for goodNum
function addGoodNum(ele) {
	var originalNum = parseInt(ele.val());
	if(originalNum > 0) {
		goodNumBox.val(originalNum + 1);
	} else {
		goodNumBox.val(1);
	}

}

// remove one op for goodNum
function removeGoodNum(ele) {
	var originalNum = parseInt(ele.val());
	if(originalNum > 1) {
		goodNumBox.val(originalNum - 1);
	} else {
		goodNumBox.val(1);
	}

}

// fuzzy querying goodID
function qeuryGoodID(data) {
	$.ajax({
		url: '../goods/fuzzyQueryID',
		type: 'POST',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded;charset:utf-8;',
		data: {
			goodID: data
		},

		success: function(data) {
			refreshPossibleList(data);
		},
		error: function(data) {
			alert("Network Error");
			ajaxError(data);
		}
	});
}

function refreshPossibleList(data) {
	possibleGoodsList.empty();
	$.each(data, function(i, item) {
		if(i < 5) {
			possibleGoodsList
				.append("<a href='#newGoods' class='button small fit' style='margin-top:0;' onclick='choosenGood(" + item + ");' >" + item + "</a>");
		} else {
			return false;
		}
	});
}

// op for choosen a specific good
function choosenGood(choosenData) {
	possibleGoodsList.empty();
	possibleGoodsList
		.append("<input type='button' class='button small fit' onclick='foucusNewGoodBox();' value='☝已输入商品编码'/>")
		.append("<input type='button' class='button small fit' onclick='resetNewGoodRow();' value='☝重输商品编码'/>");
	possibleGoodsList.focus();
	newGoodBox.val(choosenData);
	newGoodBox.siblings("[name='history']").val(choosenData);

	$.ajax({
		url: '../goods/query',
		type: 'POST',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded;charset:utf-8;',
		data: {
			goodID: choosenData
		},

		success: function(data) {
			updateNewGoodRow(data);
		},
		error: function(data) {
			ajaxError(data);
		}
	});
}

function updateNewGoodRow(data) {
	addNewGood.children("td[name='comments']").empty();
	newGoodRowPass = true;
	addNewGood.children("td[name='goodName']")
		.html(data.goodName + "<br />-----<br />" + data.goodSpecifications);
	addNewGood.children("td[name='goodBrand']")
		.html(data.goodProducer + "<br />-----<br />" + data.goodBrand);
	addNewGood.children("td[name='originalPrice']")
		.html("￥" + data.goodPrice);
	refreshSubTotal();
}

function refreshSubTotal() {
	var price = parseFloat(addNewGood.children("td[name='originalPrice']").html().replace('￥', ''));
	var goodNum = goodNumBox.val();
	if(isNaN(price)) {
		addNewGood.children("td[name='subTotal']")
			.html("<span style='color:red;font-weight:bolder;'>价格有误</span>");
		newGoodRowPass = false;
	} else if(isNaN(goodNum) || goodNum == '') {
		addNewGood.children("td[name='subTotal']")
			.html("<span style='color:red;font-weight:bolder;'>数量有误</span>");
		goodNumBox.css("color", "red");
		newGoodRowPass = false;
	} else {
		addNewGood.children("td[name='subTotal']")
			.html("￥" + getSum(price, goodNum).toFixed(2));
	}

}