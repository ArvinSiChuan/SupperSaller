var orderID;

var addedList;
var totalSum = 0;
var totalFree = 0.0;
var totalMoney = 0.0;

function addGoodToList() {
	var requestUrl = "../order/good/add/" + orderID + "/" + goodNumBox.val();
	$.ajax({
		url: requestUrl,
		type: 'PUT',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: JSON.stringify(choosenGoodData),

		success: function(data) {
			orderID = data[0].saledGood.orderID;
			refreshChoosenGoodList(data);
		},
		error: function(data) {
			ajaxError(data);
		}
	});
}

function deleteGoodFromList(currentRow, good) {
	$.ajax({
		url: "../order/good/delete",
		type: 'DELETE',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: JSON.stringify(good),

		success: function(data) {
			refreshChoosenGoodList(data);
		},
		error: function(data) {
			ajaxError(data);
		}
	});

}

function refreshChoosenGoodList(data) {
	totalSum = 0;
	totalFree = 0.0;
	totalMoney = 0.0;
	addedList.empty();
	$.each(data, function(i, good) {
		var groupID = good.saledGood.RuleID[0];
		var rowContent = getRowTemplet(good.goodID, groupID);
		var lastRowInGroup = addedList.children("tr[name='" + groupID + "']");
//		if(lastRowInGroup.length > 0) {
//			lastRowInGroup.after(rowContent);
//		} else {
			addedList.append(rowContent);
//		}
		var currentRow = $("#" + good.goodID);
		updateRow(currentRow, good, groupID);

		// bind delete event
		currentRow.children("td[name='operation']").children("input[name='deleteGoodFromList']").click(function() {
			deleteGoodFromList(currentRow, good);
		});
	});
	updateAmount();
	if(addedList.children().length > 0) {
		$("#beginPaymentBtn").attr("disabled", false);
		$("#cancelOrderBtn").attr("disabled", false);
	} else {
		$("#beginPaymentBtn").attr("disabled", true);
		$("#cancelOrderBtn").attr("disabled", true);
	}

}

function updateRow(currentRow, good, groupID) {
	var discountMoney = (good.goodPrice - good.saledGood.price) * good.saledGood.sum;
	var subTotal = good.saledGood.price * good.saledGood.sum;
	totalSum += good.saledGood.sum;
	totalFree += discountMoney;
	totalMoney += subTotal;
	var goodNumsTD = currentRow.children("td[name='goodNums']")
	currentRow.children("td[name='goodID']").html(good.goodID);
	currentRow.children("td[name='goodName']").html(good.goodName + "<br/>-----<br />" + good.goodSpecifications);
	currentRow.children("td[name='goodBrand']").html(good.goodBrand + "<br />-----<br />" + good.goodType);
	goodNumsTD.children("input[name='goodNums']").val(good.saledGood.sum);
	currentRow.children("td[name='originalPrice']").html("￥" + good.goodPrice.toFixed(2));
	currentRow.children("td[name='discountedPrice']").html("￥" + good.saledGood.price.toFixed(2));
	currentRow.children("td[name='subTotal']").html("￥" + subTotal.toFixed(2));
	currentRow.children("td[name='discountMoney']").html("￥" + discountMoney.toFixed(2));
	currentRow.children("td[name='comments']").html(groupID);
	goodNumsTD.children("input[name='goodNumAdd']").click(function() {

	});
}

function updateAmount() {
	addedList.children("tr:last").after(getTotalAmountTemplet());
	var totalRow = $("#totalAmount");

	totalRow.children("td[name='totalSum']").text(totalSum);
	totalRow.children("td[name='totalFree']").text("￥" + totalFree.toFixed(2));
	totalRow.children("td[name='totalAmountMoney']").text("￥" + totalMoney.toFixed(2));

}

function getRowTemplet(goodID, groupID) {
	return "<tr id='" + goodID + "' name='" + groupID + "' style='font-weight:bold;text-align:left;'>" +
		"<td name='goodID'></td>" +
		"<td name='goodName'></td>" +
		"<td name='goodBrand'></td>" +
		"<td name='originalPrice' style='font-size: x-large;'></td>" +
		"<td name='discountedPrice' style='font-size: x-large;'></td>" +
		"<td name='discountMoney'></td>" +
		"<td name='subTotal' style='font-size: x-large;font-weight:bold;'></td>" +
		"<td name='comments'></td>" +
		"<td name='goodNums'>" +
		"<input name='goodNumAdd' class='small fit' type='button' value=' + ' />" +
		"<input name='goodNums' type='number' min='1' value='1' style='width: 100%;margin-bottom: 0.7em;' />" +
		"<input name='goodNumRemove' class='small fit' type='button' value=' - ' />" +
		"</td>" +
		"<td name='operation'>" +
		"<input name='deleteGoodFromList' type='button' class='fit' style='background: red;' value='删除商品'/>" +
		"</td>" +
		"</tr>";
}

function getTotalAmountTemplet() {
	return "<tr id='totalAmount'>" +
		"<td colspan='1' style='font-size: x-large;font-weight:bold;'>总件数：</td>" +
		"<td name='totalSum' colspan='1' style='font-size: x-large;font-weight:bold;'></td>" +
		"<td colspan='2' style='font-size: x-large;font-weight:bold;'>总优惠：</td>" +
		"<td name='totalFree'  colspan='2' style='font-size: x-large;font-weight:bold;'></td>" +
		"<td colspan='2' style='font-size: x-large;font-weight:bold;'>总需支付：</td>" +
		"<td name='totalAmountMoney' style='font-size: xx-large;color:red;font-weight:bold;' colspan='2'></td>" +
		"</tr>";
}