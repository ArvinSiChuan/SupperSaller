// CSRF Defence header producer
function getHeaderToken() {
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	var headerToken = {};
	headerToken[header] = token;
	return headerToken;
}

function doTwinkleAnimate(target, times) {
	for(var i = 0; i < times; i++) {
		$(target).animate({
				opacity: '0.2'
			}, "slow")
			.animate({
				opacity: '1'
			}, "slow");
	}
}

function getSum(price,quality){
	var p=parseFloat(price);
	var q=parseFloat(quality);
	return p*q;
}

function ajaxError(data) {
	switch(data.status) {
		case 403:
			doAjaxLogOut();
			location.reload();
			break;
		default:
			alert('Error:'+data.status);
			break;
	}
}

function doAjaxLogOut(){
	var csrfHeader=getHeaderToken();
	$.ajax({
			url: '/SuperSaller/auth/logout/',
			type: 'POST',
			async: true,
			headers: csrfHeader,
			dataType: 'json',
			contentType: 'application/x-www-form-urlencoded;charset:utf-8;',
			data:{
				logout:true
			},
		});
}


