var orderID;
function addGoodToList(){
	var requestUrl="../order/add/"+orderID+"/"+goodNumBox.val();
	console.log(orderID);
	$.ajax({
		url: requestUrl,
		type: 'PUT',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/json;charset:utf-8;',
		data: JSON.stringify(choosenGoodData),

		success: function(data) {
			console.log(data[0].saledGood.orderID);
			orderID=data[0].saledGood.orderID;
		},
		error: function(data) {
			ajaxError(data);
		}
	});
}

function refreshChoosenGoodList(){
	
}
