// © BEN EVANS 2012
// Nothing new here I don't suppose but please don't pinch it without 
// giving me some recognition by leaving this here :) Thank you.


///////////////////////////// MOBILE NAV /////////////////////////////////




fmobile = function () {

	if ($(bw).height() > $(bw).width()) {

		$(bw).addClass("mobile");

		var bookheight = $(bw).height() / 1.2;
		var bookwidth = bookheight / 1.414285714;

		function windowleft() {
			leftamount = ("translateX( -" + bookwidth + "px)");
			$(bw + "#book").css("transform", leftamount);
			$(bw + "#book .left").css("z-index", "-1");
			$(bw + "#book .right").css("z-index", "+1");
		}

		function windowright() {
			rightamount = ("translateX(0px)");
			$(bw + "#book").css("transform", rightamount);
			$(bw + "#book .left").css("z-index", "+1");
			$(bw + "#book .right").css("z-index", "-1");
		}


		$(window).load(windowleft);
		$(bw + "#next, #navforward, #navlast").click(windowright);
		$(bw + "#previous, #navback, #navfirst").click(windowleft);
		$(bw + "#mobforward").click(windowleft);
		$(bw + "#mobback").click(windowright);

		$(bw + "#mobforward").click(function () {
			$(this).hide();
			$(bw + "#navforward").show();
			return false;
		});

		$(bw + "#navforward").click(function () {
			$(this).hide();
			$(bw + "#mobforward").show();
		});

		$(bw + "#mobback").click(function () {
			$(this).hide();
			$(bw + "#navback").show();
			return false;
		});

		$(bw + "#navback").click(function () {
			$(this).hide();
			$(bw + "#mobback").show();
		});

		//////////////////////////////  v EXPLODE v /////////////////////////////////

		$(bw + '#explode a').click(function (windowright) {

			ripsound.play();
			var explodeheight = $(bw + "#book .page").width() / 2 * 1.414285714;
			$(bw + "ul#booktopbar").slideUp("fast");
			$(bw + "#unexplode").delay(500).slideDown("fast");
			$(bw + "#book, #book .page").addClass("exploded");
			$(bw + "#book .page > ul > li").each(function () {
				if ($(this).children("div").length > 0) {
					$(this).css("height", explodeheight + "px");
				}
				else {
					$(this).css("height", "0");
				}
			});
			$(bw + "#book").css("transform", "translateX(0px)");
			$(bw).css("overflow", "visible");
			$(bw).removeClass("nonexploded");
		});


		//////////////////////////////  ^ EXPLODE ^ /////////////////////////////////

	}
	else {
		$(bw).removeClass("mobile");
	}
}

$(document).ready(fmobile);
$(window).resize(fmobile);


////////////////////////////// Drag Page /////////////////////////////////




///////////////////////////////////////////// TOUCHSCREEN ///////////////////////////////////////////////////

$.fn.touch = function () {

	var start = function (event) {

		var orig = event.originalEvent;
		var pos = $(this).position();

		downx = orig.changedTouches[0].pageX - pos.left;

	}

	var move = function (event) {

		event.preventDefault();
	}

	var end = function (event) {

		var orig = event.originalEvent;
		var pos = $(this).position();

		newx = orig.changedTouches[0].pageX - pos.left;

		if (newx < downx) {
			if ($(bw + "#navforward").hasClass("move")) {
				$(bw + "#navforward.move").click();
				$(bw + "#navforward.move, #mobforward.move").removeClass("move").addClass("dontmove");
			}
			else {
				$(bw + "#mobforward.dontmove").click();
				$(bw + "#mobforward.dontmove, #navforward.dontmove").addClass("move").removeClass("dontmove");
			}
		}
		if (newx > downx) {
			if ($(bw + "#navback").hasClass("move")) {
				$(bw + "#navback.move").click();
				$(bw + "#navback.move, #mobback.move").removeClass("move").addClass("dontmove");
			}
			else {
				$(bw + "#mobback.dontmove").click();
				$(bw + "#mobback.dontmove, #navback.dontmove").addClass("move").removeClass("dontmove");
			}
		}
	}

	this.bind("touchstart", start);
	this.bind("touchmove", move);
	this.bind("touchend", end);

};

$(bw).touch();

///////////////////////////////////////////// MOUSE ///////////////////////////////////////////////////


$(bw).mousedown(function (event) {
	downx = event.pageX;
	//				$('#bookpagezoom div').html("<p>" + downx + "</p>");
})
$(bw).mouseup(function (event) {
	//		$('#bookpagezoom div').html("<p>" + downx + " - " + event.pageX + "</p>");

	if (event.pageX < downx) {



		if ($(bw + "#navforward").hasClass("move")) {
			$(bw + "#navforward.move").click();
			$(bw + "#navforward.move, #mobforward.move").removeClass("move").addClass("dontmove");
		}

		else {
			$(bw + "#mobforward.dontmove").click();
			$(bw + "#mobforward.dontmove, #navforward.dontmove").addClass("move").removeClass("dontmove");
		}
	}
	if (event.pageX > downx) {



		if ($(bw + "#navback").hasClass("move")) {
			$(bw + "#navback.move").click();
			$(bw + "#navback.move, #mobback.move").removeClass("move").addClass("dontmove");
		}

		else {
			$(bw + "#mobback.dontmove").click();
			$(bw + "#mobback.dontmove, #navback.dontmove").addClass("move").removeClass("dontmove");
		}


	}
});

