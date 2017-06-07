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

function getSum(price, quality) {
	var p = parseFloat(price);
	var q = parseFloat(quality);
	return p * q;
}

function ajaxError(data) {
	switch(data.status) {
		case 403:
			alert('身份认证已过期，即将进行重新认证！');
			doAjaxLogOut();
			break;
		default:
			alert('Error:' + data.status);
			break;
	}
}

function doAjaxLogOut() {
	var csrfHeader = getHeaderToken();
	$.ajax({
		url: '/SuperSaller/auth/logout/',
		type: 'POST',
		async: true,
		headers: csrfHeader,
		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded;charset:utf-8;',
		data: {
			logout: true
		},
		success: function() {
			console.log("*******************************s");
			location.reload();
		},
		error: function() {
			console.log("*******************************e");
			location.reload();
		}
	});
}

function prefixInteger(num, length) {
	return(Array(length).join('0') + num).slice(-length);
}

function miniteToTime(min){
	return prefixInteger(Math.floor(min/60),2)+":"+prefixInteger(min%60,2);
}
