var ruleList;
$(document).ready(function() {
	ajaxUpdateRow();
	ruleList = $("tbody");
	$("#refresh").click(function() {
		ajaxUpdateRow();
	})
});

function ajaxUpdateRow() {
	var username = $("#username").text();
	var csrfHeader = getHeaderToken();
	$.ajax({
		url: '../rule/all',
		type: 'POST',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded;charset:utf-8;',
		data: {
			emID: username,
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
	thisRow.children("td[name='ruleName']").children("input").val(rule.Name);
	thisRow.children("td[name='ruleType']").find("option[value='" + rule.Type + "']").attr("selected", "selected");
	thisRow.children("td[name='ruleConditionValue']").children("input").val(rule.conditionValue);
	thisRow.children("td[name='discountRate']").children("input").val(rule.discountRate);
	thisRow.children("td[name='freeMoney']").children("input").val(rule.freeMoney);
	thisRow.children("td[name='specialMoney']").children("input").val(rule.specialPrice);
	thisRow.children("td[name='startDate']").children("input").val(getStringOfDatetime(rule.datePeriodStart));
	thisRow.children("td[name='endDate']").children("input").val(getStringOfDatetime(rule.datePeriodEnd));
	thisRow.children("td[name='startMin']").children("input").val(miniteToTime(rule.dayPeriodStart));
	thisRow.children("td[name='endMin']").children("input").val(miniteToTime(rule.dayPeriodEnd));
	thisRow.children("td[name='operation']").html("<input name='edit' style='background-color: gold;' class='button small fit' type='button' value='编辑'/><input name='delete' style='background-color:red;' class='button small fit' type='button' value='删除'/>");

	// TODO event
}

function getStringOfDatetime(datetime) {
	var dateVar = datetime.date;
	var timeVar = datetime.time;
	var dateString = dateVar.year + "-" +
		prefixInteger(dateVar.month, 2) + "-" +
		prefixInteger(dateVar.day, 2) + "T" +
		prefixInteger(timeVar.hour, 2) + ":" +
		prefixInteger(timeVar.minute, 2);
	console.log(dateString);
	return dateString;
}

function getTypeSelection(readOnly) {
	if(readOnly == undefined) {
		readOnly = "";
	} else if(readOnly) {
		readOnly = "disabled";
	}
	var selectTemplet =
		"<select " + readOnly + ">" +
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
		"<td name='ruleName'><input placehoder='规则名称' readonly='readonly'/></td>" +
		"<td name='ruleType' style='padding:0 5px 5px 0;'>" + getTypeSelection(true) + "</td>" +
		"<td name='ruleConditionValue'><input type='number' size=5 readonly='readonly'/></td>" +
		"<td name='discountRate'><input type='number' min=1 max=100 size=3 readonly/></td>" +
		"<td name='freeMoney'><input type='number' size=5 readonly='readonly'/></td>" +
		"<td name='specialMoney'><input type='number' size=5 readonly='readonly'/></td>" +
		"<td name='startDate'><input type='datetime-local' readonly='readonly'/></td>" +
		"<td name='endDate'><input type='datetime-local' readonly='readonly'/></td>" +
		"<td name='startMin'><input type='time'  readonly='readonly'/></td>" +
		"<td name='endMin'><input type='time' readonly='readonly'/></td>" +
		"<td name='operation'></td>" +
		"</tr>";
	return templet;
}

function getEmptyRowTemplet() {
	var selectTemplet =
		"<select readonly='true'>" +
		"<option value='FULLFREE'>满减</option>" +
		"<option value='FULLCOUNT'>满折</option>" +
		"<option value='FULLPRESENT'>满赠</option>" +
		"<option value='FULLVOUCHER'>满返</option>" +
		"<option value='BUYFREE'>买减</option>" +
		"<option value='BUYCOUNT'>买折</option>" +
		"<option value='BUYSPECIAL'>买特价</option>" +
		"<option value='BUYPRESENT'>买赠</option>" +
		"</select>";
	var templet =
		"<tr id='" + ruleUUID + "'>" +
		"<td name='ruleName'><input placehoder='规则名称' /></td>" +
		"<td name='ruleType'>" + selectTemplet + "</td>" +
		"<td name='ruleConditionValue'><input type='number' min=1 max=100 /></td>" +
		"<td name='discountRate'><input type='number' /></td>" +
		"<td name='freeMoney'><input type='number'/></td>" +
		"<td name='specialMoney'><input type='number' /></td>" +
		"<td name='startDate'><input type='date'/></td>" +
		"<td name='endDate'><input type='date'/></td>" +
		"<td name='startMin'><input type='number' min=0 max=1440/></td>" +
		"<td name='endMin'><input type='number' min=0 max=1440/></td>" +
		"<td name='operation'></td>" +
		"</tr>";
	return templet;

}