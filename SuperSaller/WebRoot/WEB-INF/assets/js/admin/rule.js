var ruleList;
$(document).ready(function() {
	ruleList = $("tbody");
	$("#refresh").click(function() {
		ajaxUpdateRow();
	});
	ajaxUpdateRow();
});

function ajaxUpdateRow() {
	ruleList.html(
		"<td colspan='9' style='text-align: center;vertical-align: middle;'>" +
		"请稍后，数据加载中..." +
		"</td>");
	var username = $("#username").text();
	var csrfHeader = getHeaderToken();
	var requestURL = "../rule/" + username + "/all";
	$.ajax({
		url: requestURL,
		type: 'POST',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded;charset:utf-8;',
		data: {

		},
		success: function(rules) {
			updateRules(rules);
		},
		error: function(data) {
			ajaxError(data);
		}
	});
}

function updateRules(rules) {
	ruleList.empty();
	$.each(rules, function(i, rule) {
		var lastRow = ruleList.children("tr:last");
		var rowContent = getRowTemplet(rule.UUID);
		if(lastRow.length > 0) {
			lastRow.after(rowContent);
		} else {
			ruleList.append(rowContent);
		}
		setValueAndEvent(rule);
	});
}

function setValueAndEvent(rule) {
	var thisRow = $("#" + rule.UUID);
	thisRow.children("td[name='ruleNameType']").children("input").val(rule.Name);
	thisRow.children("td[name='ruleNameType']").find("option[value='" + rule.Type + "']").attr("selected", "selected");
	thisRow.children("td[name='ruleConditionValue']").children("input").val(rule.conditionValue);
	thisRow.children("td[name='discountRate']").children("input").val(rule.discountRate);
	thisRow.children("td[name='freeMoney']").children("input").val(rule.freeMoney);
	thisRow.children("td[name='specialMoney']").children("input").val(rule.specialPrice);
	var effectiveDate = thisRow.children("td[name='effectiveDate']");
	effectiveDate.children("input[name='start']").val(getStringOfDatetime(rule.datePeriodStart));
	effectiveDate.children("input[name='end']").val(getStringOfDatetime(rule.datePeriodEnd));
	var dayPeriod = thisRow.children("td[name='dayPeriod']");
	dayPeriod.children("input[name='start']").val(miniteToTime(rule.dayPeriodStart));
	dayPeriod.children("input[name='end']").val(miniteToTime(rule.dayPeriodEnd));
	thisRow.children("td[name='operation']").html("<input name='edit' style='background-color: gold;' class='button small fit' type='button' value='编辑'/><input name='delete' style='background-color:red;' class='button small fit' type='button' value='删除'/>");
	// READONLY
	thisRow.find("input").attr("readonly", "readonly");
	thisRow.find("select").attr("disabled", "disabled");
	// TODO event
	thisRow.find("input[name='edit']").click(function() {
		if($("#" + rule.UUID + "edit").length <= 0) {
			thisRow.after("<tr id='" + rule.UUID + "edit'><td colspan='10'>在此显示编辑信息<input type='button' value='隐藏编辑' onclick='$(&apos;#" + rule.UUID + "edit&apos;).remove();'/></td></tr>");
		}
	});
}

function getStringOfDatetime(datetime) {
	var dateVar = datetime.date;
	var timeVar = datetime.time;
	var dateString = dateVar.year + "-" +
		prefixInteger(dateVar.month, 2) + "-" +
		prefixInteger(dateVar.day, 2) + "T" +
		prefixInteger(timeVar.hour, 2) + ":" +
		prefixInteger(timeVar.minute, 2);
	return dateString;
}

function getTypeSelection() {
	var selectTemplet =
		"<select >" +
		"<option value='FULLFREE'>满减</option>" +
		"<option value='FULLCOUNT'>满折</option>" +
		"<option value='FULLPRESENT'>满赠</option>" +
		"<option value='FULLVOUCHER'>满返</option>" +
		"<option value='BUYFREE'>买减</option>" +
		"<option value='BUYCOUNT'>买折</option>" +
		"<option value='BUYSPECIAL'>买特价</option>" +
		"<option value='BUYPRESENT'>买赠</option>" +
		"</select>";
	return selectTemplet;
}

function getRowTemplet(ruleUUID) {
	var templet =
		"<tr id='" + ruleUUID + "'>" +
		"<td name='ruleNameType'>" +
		"<input placehoder='规则名称' /> " +
		getTypeSelection(true) +
		"</td>" +
		"<td name='ruleConditionValue'>" +
		"<input type='number' size=4 />" +
		"</td>" +
		"<td name='discountRate'>" +
		"<input type='number' min=1 max=100 size=3 />" +
		"</td>" +
		"<td name='freeMoney'>" +
		"<input type='number' size=3 />" +
		"</td>" +
		"<td name='specialMoney'>" +
		"<input type='number' size=3 /></td>" +
		"<td name='effectiveDate'>" +
		"<input name='start' type='datetime-local' />" +
		"<br />↓<br />" +
		"<input name='end' type='datetime-local' />" +
		"</td>" +
		"<td name='dayPeriod'>" +
		"<input name='start' type='time'  />" +
		"<br />↓<br />" +
		"<input name='end' type='time'/></td>" +
		"<td name='weekPeriod'>NOT SUPPORT YET</td>" +
		"<td name='operation'></td>" +
		"</tr>";
	return templet;
}