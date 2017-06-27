$(document).ready(
	function() {
		var width = screen.width / 6.84;
		if(screen.width < 201) {
			$("a").css("width", screen.width);
		} else {
			$("a").css("width", width);
		}
		
	}
);