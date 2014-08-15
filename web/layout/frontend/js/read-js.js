// © BEN EVANS 2012
// Nothing new here I don't suppose but please don't pinch it without 
// giving me some recognition by leaving this here :) Thank you.


////////////////////////////// PAGE TURNER /////////////////////////////////

//////////// SET UP //////////////

if ($.browser.msie) {
	$("#book").addClass("ie");
	$('.page div').wrapInner('<span></span>');
	var browser = "-ms-";
}
if ($.browser.webkit) {
	var browser = "-webkit-";
}
if ($.browser.opera) {
	var browser = "-o-";
}
if ($.browser.mozilla) {
	var browser = "-moz-";
}

$(document).delay(2000).ready(function () {
	$("body").css("line-height", "1.5em");
	$("h1,h2,h3,h4,h5,h6").css("line-height", "1.6em");
});

var pagesound = $("#book-wrapper #audio1")[0];
var pagessound = $("#book-wrapper #audio2")[0];
var ripsound = $("#book-wrapper #audio3")[0];
var threedsound = $("#book-wrapper #audio4")[0];
var bw = "#book-wrapper ";
var b2d = "#book-wrapper.notthreed ";
var b3d = "#book-wrapper.threed ";
var bwls = "#book-wrapper.landscape ";
var bwp = "#book-wrapper.portrait ";

$($(bw + "#book > ul > li").get().reverse()).each(function (i) {
	four = i * 4;
	$(this).css("z-index", four);
});

$($(bw + "#book > ul > li.page").get()).each(function (i) {
	count = i;
	$(this).attr("rel", count);
});

//////////// NEXT PAGE //////////////

$.nextpage = function () {
	$(bw + '.currentpage').addClass("previouspage").removeClass("currentpage").next().removeClass('nextpage').addClass("currentpage").next().addClass("nextpage");
	$(bw + '.previouspage').each(function () {
		minusfour = $(this).css("z-index") - 4;
		$(this).css("z-index", minusfour);
		$(bw + ".nextpage, .currentpage").each(function () {
			plusfour = $(this).css("z-index") * 1 + 4;
			$(this).css("z-index", plusfour);
		});
	});
};
$(bw + "#next, #navforward").click(function (e) {
	e.preventDefault();
	if ($(bw).hasClass("notthreed")) {
		if (!$(this).data('isClicked')) {
			var link = $(this);
			if ($(".nextpage").length > 0) {
				pagesound.play();
				if ($.browser.msie) {
					store = $('.currentpage').css("z-index");
					$(bw + '#book .page .left').css('z-index', '1');
					$(bw + '#book .page .right').css('z-index', '0');
					$.nextpage();
					$('.nextpage').css("z-index", "-999");
					$('.currentpage').prev().css("z-index", "999").children().children().children("div:last").animate({
						width: '-=50%'
					}, 550, function () {
						$('.currentpage').prev().css("z-index", store - 4).children().children().children("div:last").attr("style", "left:0;");
					});
					$('.currentpage').attr("style", "z-index:950;");
					$('.currentpage .left div').attr("style", "left:100%;").width(0).animate({
						width: '+=50%',
						left: '-=100%'
					}, 600, function () {
						$('.currentpage .left div').attr("style", "left:0;");
						$('.currentpage').css("z-index", store);
					});
					$('.currentpage .right div').attr("style", "left:100%;").width(0).animate({
						width: '+=50%',
						left: '-=50%'
					}, 600);
				}
				else {
					$.nextpage();
				}
				$(bw + "#next, #previous").css("opacity", "1");
			}
			else {
				$(bw + "#next").css("opacity", "0.1");
			}
			link.data('isClicked', true);
			setTimeout(function () {
				link.removeData('isClicked')
			}, 600);
		}
	}
	if ($.browser.msie) {
		$('.currentpage').css("z-index", store).prev().css("z-index", store - 4);
	}
	return false;
});

//////////// KEYBOARD CONTROL //////////////

$(document).keydown(function (e) {
	if (e.keyCode == 39) {
		$(bw + "#navforward").click();
	}
	if (e.keyCode == 37) {
		$(bw + "#navback").click();
	}
	if (e.keyCode == 32) {
		$(bw + '.left div').click();
	}

});


//////////// PREVIOUS PAGE //////////////

$.previouspage = function () {
	$(bw + '.currentpage').addClass("nextpage").removeClass('currentpage').prev().removeClass('previouspage').addClass("currentpage").prev().addClass('previouspage');
	$(bw + "#book > ul > li.page").each(function () {
		plusfour = $(this).css("z-index") * 1 + 4;
		$(this).css("z-index", plusfour);
		$(bw + '.nextpage').each(function () {
			minusfour = $(this).css("z-index") - 4;
			$(this).css("z-index", minusfour);
		});
	});
};
$(bw + "#previous, #navback").click(function (e) {
	e.preventDefault();
	if ($(bw).hasClass("notthreed")) {
		if (!$(this).data('isClicked')) {
			var link = $(this);
			if ($(bw + ".previouspage").length > 0) {
				pagesound.play();
				if ($.browser.msie) {
					store = $('.currentpage').css("z-index");
					$(bw + '#book .page.currentpage .left').css('z-index', '-1');
					$(bw + '#book .page.currentpage .right').css('z-index', '1');
					$.previouspage();
					$('.currentpage').css("z-index", "999").next().css("z-index", "980").children().children().children("div:first").attr("style", "left:0;").animate({
						width: '-=50%',
						left: '+=50%'
					}, 550, function () {
						$('.currentpage').next().css("z-index", store - 4).children().children().children("div:first").attr("style", "");
					});
					$('.currentpage .right div').attr("style", "left:0;").width(0).animate({
						width: '+=50%',
						left: '+=50%'
					}, 600, function () {
						$('.currentpage .right div').attr("style", "left:50%;");
						$('.currentpage').css("z-index", store);
					});
					$('.currentpage .left div').attr("style", "left:0;").width(0).animate({
						width: '+=50%'
					}, 600);
				}
				else {
					$.previouspage();
				}
				$(bw + "#next, #previous").css("opacity", "1");
			}
			else {
				$(bw + "#previous").css("opacity", "0.1");
			}
			link.data('isClicked', true);
			setTimeout(function () {
				link.removeData('isClicked')
			}, 600);
		}
	}
	if ($.browser.msie) {
		$('.currentpage').css("z-index", store).next().css("z-index", store - 4);
	}
	return false;
});

//////////// FIRST AND LAST PAGE //////////////

$(bw + "#navlast").click(function () {
	if ($(bw).hasClass("notthreed")) {
		$(bw + "#book > ul > li").each(function (i) {
			setTimeout(function () {
				if ($(bw + ".nextpage").length > 0) {
					pagessound.play();
					$(bw + '.currentpage').addClass("previouspage").removeClass("currentpage").next().removeClass('nextpage').addClass("currentpage").next().addClass("nextpage");
					$(bw + "#next, #previous").css("opacity", "1");
					if ($.browser.msie) {
						$(bw + "#book .page .left div").css("left", "0");
					}
				}
				else {
					$(bw + "#next").css("opacity", "0.1");
				}
			}, 50 * i);
		});
		$(bw + "#book > ul > li").each(function (i) {

			var $this = $(this);
			setTimeout(function () {
				relorder = $this.attr("rel") * 4;
				$this.css("z-index", relorder);
			}, 25 * i);
		});
	}
	return false;
});
$(bw + "#navfirst").click(function () {
	if ($(bw).hasClass("notthreed")) {
		$(bw + "#book > ul > li").each(function (i) {
			setTimeout(function () {
				if ($(bw + ".previouspage").length > 0) {
					pagessound.play();
					$(bw + '.currentpage').addClass("nextpage").removeClass('currentpage').prev().removeClass('previouspage').addClass("currentpage").prev().addClass('previouspage');
					$(bw + "#next, #previous").css("opacity", "1");
					if ($.browser.msie) {
						$(bw + "#book .page div").css("left", "50%");
					}
				}
				else {
					$(bw + "#previous").css("opacity", "0.1");
				}
			}, 50 * i);
		});
		$($(bw + "#book > ul > li").get().reverse()).each(function (i) {
			four = i * 4;
			$(this).css("z-index", four);
		});
	}
	return false;
});

////////////////////////////// RESPONSIVE STUFF /////////////////////////////////

function booksize() {

	if ($(bw).height() > $(bw).width()) {
		$(bw).removeClass("landscape").addClass("portrait");
	}
	if ($(bw).height() < $(bw).width()) {
		$(bw).removeClass("portrait").addClass("landscape");
	}

	if ($(bw).height() > $(bw).width()) {
		var bookheight = $(bw).height() / 1.2;
		var fontsize = $(bw).height() / 7.5 + "%";
	}
	else {
		var bookheight = $(bw).height() / 1.3;
		var fontsize = $(bw).height() / 8 + "%";
	}
	var bookwidth = bookheight / 1.414285714 * 2;
	var margin = -$(bw).width() / 3 + "px";
	$(bw + "#book").css("width", bookwidth + "px");
	$(bw + "#book").css("height", bookheight + "px");
	$(bw + "#book").css("font-size", fontsize);

	var footer = $(bw).height() - bookheight - 60;

	$(bw + "#pright").height(footer);
}
$(document).ready(booksize);
$(window).resize(booksize);
var imgsize = $(bw + '#book .page ul li div').width();
$(bw + "img").css("width", imgsize / 4 + "%");
$(bw + "img.image").css("width", imgsize / 8 + "%");

////////////////////////////// PAGE NUMBER /////////////////////////////////

$($(bw + "#book > ul > li.page div").get()).each(function (i) {
	count = i;
	$(this).attr("rel", count);
	current = $(bw + "#book .currentpage .right div").attr("rel");
	$(bw + "ul#booktopbar #booknav p").text(current + " / " + count);
	$(bw + "#next, #navforward, #previous, #navback").click(function () {
		if ($(bw + "#book .currentpage").attr("rel") < 1) {
			$(bw + "ul#booktopbar #booknav p").text("0 / " + count);
		}
		else {
			current = $(bw + "#book .currentpage .right div").attr("rel");
			$(bw + "ul#booktopbar #booknav p").text(current - 1 + "-" + current + " / " + count);
		}
	});
	$(bw + "#navlast").click(function () {
		$(bw + "ul#booktopbar #booknav p").text(count - 1 + "-" + count + " / " + count);
	});
	$(bw + "#navfirst").click(function () {
		$(bw + "ul#booktopbar #booknav p").text("0 / " + count);
	});
});

////////////////////////////// Z-INDEX FIX /////////////////////////////////

if ($(bw).height() < $(bw).width()) {

$(bw).mousemove(function (ev) {
	if (ev.clientX < $(bw).innerWidth() / 2) {
		$(bw + "#book .currentpage .right, #book .exploded .right").css("z-index", "-1");
		$(bw + "#book .currentpage .left, #book .exploded .left").css("z-index", "+1");
	} else {
		$(bw + "#book .currentpage .left , #book .exploded .left").css("z-index", "-1");
		$(bw + "#book .currentpage .right, #book .exploded .right").css("z-index", "+1");
	}
	ev.preventDefault();
});


////////////////////////////// ZOOM /////////////////////////////////


	$(bw + '.left div, .right div').click(function () {
		var zoomfontsize = $("#book-wrapper").width() / 8 + "%";
		var scrollTop = $(window).scrollTop();
		$("#bookpagezoom").css("font-size", zoomfontsize);
		$("#bookpagezoomwrapper").show().css("top", scrollTop).delay(500).queue(function () {
			var zoomheight = $("#bookpagezoom").width() * 1.414285714;
			$("#bookpagezoom").css("min-height", zoomheight);
		});
		$($(this).html()).appendTo('#bookpagezoom div');
		$(this).addClass("zoomedhere").parent().next("li").children("div").addClass("zoomednext");
		$(bw + "#next, #previous").css("opacity", "0");
		//	$(window).scroll(function () {
		//		var scrollTop = $(window).scrollTop();
		//		$("#bookpagezoomwrapper").css("top", scrollTop)
		//});
		return false;
	});
	$('#bookzoomclose').click(function () {
		$("#bookpagezoomwrapper").hide();
		$('#bookpagezoom div').html("");
		$(bw + '.left div, .right div').removeClass("zoomedhere").parent().next("li").children("div").removeClass("zoomednext");
		$(bw + "#next, #previous").css("opacity", "1");
		return false;
	});

////////////////////////////// ZOOM NEW BIT /////////////////////////////////

//if ($("#people .making-of .mask ul li.current").next("li").length > 0) {
//	alert("Exists");
//}
//else {
//	alert("Dont exists");
//}


if ($(bw + '.zoomednext').length) {

	alert("hello");

//	$(bw + '#zoomnext').click(function () {
//		$('#bookpagezoom div').html("").queue(function () {
//			$($(bw + '.zoomedhere').removeClass('zoomedhere').parent().next().children().addClass('zoomedhere').html()).appendTo('#bookpagezoom div');
//		});
//		return false;
//	});
}
else {
	//			$(bw + '.zoomedhere').addClass("nothat");
	//			$($(bw + '.zoomedhere').removeClass('zoomedhere').parent().parent().parent().next().children().children().children('div:first').addClass('zoomedhere').html()).appendTo('#bookpagezoom div');

	$(bw + '#zoomnext').hide();
}

//if ($(bw + '.zoomedhere').parent().prev().children().length > 0) {

//	$(bw + '#zoomprevious').click(function () {
//		$('#bookpagezoom div').html("").queue(function () {
//			$($(bw + '.zoomedhere').removeClass('zoomedhere').parent().prev().children().addClass('zoomedhere').html()).appendTo('#bookpagezoom div');
//		});
//		return false;
//	});
//}
//else {
//	$(bw + '#zoomprevious').hide();
//}



//$(bw + '#zoomprevious').click(function () {
//	$('#bookpagezoom div').html("").queue(function () {
//		$($(bw + '.zoomedhere').parent().prev().children().html()).appendTo('#bookpagezoom div');
//	});
//	return false;
//});



////////////////////////////// EXPLODE /////////////////////////////////

$(bw + '#explode a').click(function () {
	$.explode();
	return false;
});

$.explode = function () {
	ripsound.play();
	var explodeheight = $(bw + "#book .page").width() / 2 * 1.414285714;
	$(bw + "#explode").slideUp("fast");
	$(bw + "#unexplode").delay(500).slideDown("fast");
	$(bw + "#book, #book .page").addClass("exploded");
	$(bw + "#book .page").css("height", explodeheight + "px");
	//	$("#book").css("width", "80%");
	$(bw + "#book, #book > ul").css("height", "auto");
	$(bw + "#booknav, #next, #previous, #threedoverride").slideUp("fast");
}

}

////////////////////////////// SOME IE FIXES GRRRR /////////////////////////////////

$(document).delay(2000).ready(function () {
	var pagewidth = $(bw + '#book.ie .page ul li div span').width();
	$(bw + '#book.ie .page ul li div span').css("width", pagewidth);
});

////////////////////////////// SOME SAFARI FIXES MORE GRRRR /////////////////////////////////

//if (navigator.userAgent.indexOf('Safari') != -1 && navigator.userAgent.indexOf('Chrome') == -1) {
//	if (haveqt = "false") {
//		$("#bookpagezoomwrapper").fadeIn().css("top", $(window).scrollTop()); ;
//		$("#bookpagezoom div").html("No Quicktime, sound disabled.")
//		pagesound = $.noop;
//		pagessound = $.noop;
//		ripsound = $.noop;
//		threedsound = $.noop;
//		ripsound.play = $.noop;
//		$("#bookpagezoomwrapper").delay(2000).fadeOut(function () {
//			$("#bookpagezoom div").html("");
//		});
//	}
//}
//var haveqt = false;
//if (navigator.plugins) {
//	for (i = 0; i < navigator.plugins.length; i++) {
//		if (navigator.plugins[i].name.indexOf
//        ("QuickTime") >= 0)
//		{ haveqt = true; }
//	}
//}
//if ((navigator.appVersion.indexOf("Mac") > 0)
//    && (navigator.appName.substring(0, 9) == "Microsoft")
//    && (parseInt(navigator.appVersion) < 5))
//{ haveqt = true; }