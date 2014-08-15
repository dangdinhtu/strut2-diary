// © BEN EVANS 2012
// Nothing new here I don't suppose but please don't pinch it without 
// giving me some recognition by leaving this here :) Thank you.


////////////////////////////// 3D PAGE TURNER /////////////////////////////////

$($(b3d + "#book > ul > li.page").get()).each(function (i) {
	count = i;
	$(this).attr("rel", count);
});
$($(b3d + "#book > ul > li").get().reverse()).each(function (i) {
	i = i + 1;
	four = i * 4;
	pretext = ("translateZ(");
	subtext = ("px)");
	sum = pretext + four + subtext;
	$(this).css("transform", sum).css("z-index", four);
});

//////////// NEXT PAGE //////////////

$.nextpage3d = function () {
	$(b3d + '.currentpage').addClass("previouspage").removeClass("currentpage").next().removeClass('nextpage').addClass("currentpage").next().addClass("nextpage");
	$(b3d + ".nextpage, .currentpage").each(function () {
		plusfour = $(this).css("z-index") * 1 + 4;
		plussum = "translateZ(" + plusfour + "px)";
		$(this).css("transform", plussum).css("z-index", plusfour);
		$(b3d + '#book .previouspage').each(function () {
			minusfour = $(this).css("z-index") - 4;
			minussum = "translateZ(" + minusfour + "px)";
			$(this).css("transform", minussum).css("z-index", minusfour);
			console.log("hello again");
		});
	});
};
$(bw + "#next, #navforward").click(function (e) {
	if ($(bw).hasClass("threed")) {
		if (!$(this).data('isClicked')) {
			e.preventDefault();
			var link = $(this);
			if ($(b3d + ".nextpage").length > 0) {
				pagesound.play();	
				$.nextpage3d();
				$(b3d + "#next, #previous").css("opacity", "1");
			}
			else {
				$(b3d + "#next").css("opacity", "0.1");
			}
			link.data('isClicked', true);
			setTimeout(function () {
				link.removeData('isClicked')
			}, 600);
		}
	}
	return false;
});

//////////// PREVIOUS PAGE //////////////

$.previouspage3d = function () {
	$(b3d + '.currentpage').addClass("nextpage").removeClass('currentpage').prev().removeClass('previouspage').addClass("currentpage").prev().addClass('previouspage');
	$(b3d + ".previouspage, .currentpage").each(function () {
		plusfour = $(this).css("z-index") * 1 + 4;
		plussum = "translateZ(" + plusfour + "px)";
		$(this).css("transform", plussum).css("z-index", plusfour);
		$(b3d + '#book .nextpage').each(function () {
			minusfour = $(this).css("z-index") - 4;
			minussum = "translateZ(" + minusfour + "px)";
			$(this).css("transform", minussum).css("z-index", minusfour);
		});
	});
};
$(bw + "#previous, #navback").click(function (e) {
	if ($(bw).hasClass("threed")) {
	if (!$(this).data('isClicked')) {
	e.preventDefault();
		var link = $(this);
		if ($(b3d + ".previouspage").length > 0) {
			pagesound.play();	
			$.previouspage3d();
			$(b3d + "#next, #previous").css("opacity", "1");
		}
		else {
			$(b3d + "#previous").css("opacity", "0.1");
		}
		link.data('isClicked', true);
		setTimeout(function () {
			link.removeData('isClicked')
		}, 600);
	}
}
	return false;
});

//////////// FIRST AND LAST PAGE //////////////

$(bw + "#navlast").click(function () {
	if ($(bw).hasClass("threed")) {
		$(b3d + "#book > ul > li").each(function (i) {
			setTimeout(function () {
				if ($(b3d + ".nextpage").length > 0) {
					pagessound.play();	
					$(b3d + '.currentpage').addClass("previouspage").removeClass("currentpage").next().removeClass('nextpage').addClass("currentpage").next().addClass("nextpage");
					$(b3d + "#next, #previous").css("opacity", "1");
				}
				else {
					$(b3d + "#next").css("opacity", "0.1");
				}
			}, 50 * i);
		});
		$(b3d + "#book > ul > li").each(function (i) {

			var $this = $(this);
			setTimeout(function () {
				relorder = $this.attr("rel") * 4;
				relsum = "translateZ(" + relorder + "px)";
				$this.css("transform", relsum).css("z-index", relorder);
			}, 25 * i);
		});
	}
	return false;
});
$(bw + "#navfirst").click(function () {
	if ($(bw).hasClass("threed")) {
		$(b3d + "#book > ul > li").each(function (i) {
			setTimeout(function () {
				if ($(b3d + ".previouspage").length > 0) {
					pagessound.play();	
					$(b3d + '.currentpage').addClass("nextpage").removeClass('currentpage').prev().removeClass('previouspage').addClass("currentpage").prev().addClass('previouspage');
					$(b3d + "#next, #previous").css("opacity", "1");
				}
				else {
					$(b3d + "#previous").css("opacity", "0.1");
				}
			}, 50 * i);
		});
		$($(b3d + "#book > ul > li").get().reverse()).each(function (i) {
			four = i * 4;
			foursum = "translateZ(" + four + "px)";
			$(this).css("transform", foursum).css("z-index", four);
		});
	}
	return false;
});

////////////////////////////// 3D /////////////////////////////////

$(document).mousemove(function (e) {
	var horibeg = "translateZ( 0px ) rotatey(";
	var rotx = "rotatex(";
	var horideg = "deg)";
	var mouseposx = e.clientX / $(window).width() * 100 - 50;
	var mouseposy = e.clientY / 10 - 40;
	var revmouseposy = -mouseposy;
	var ysum = rotx + revmouseposy + horideg;
	var horisum = horibeg + mouseposx + horideg + rotx + revmouseposy + horideg;
	$(b3d + "#book").css('transform', horisum);
});

////////////////////////////// EXPLODE /////////////////////////////////

$(bw + '#explode a').click(function () {
	if ($(bw).hasClass("threed")) {
		ripsound.play();
		var explodeheight = $(bw + "#book .page").width() / 2 * 1.414285714;
		$.unthreed();
		$.explode();
	}
	return false;
});

////////////////////////////// 3D SWITCHER /////////////////////////////////

$("#threedoverride a").click(function () {
	threedsound.play();
	if ($(bw).hasClass("notthreed")) {
		$(bw).toggleClass("notthreed").toggleClass("threed");
		$(bw + "#book > ul > li").each(function () {
			zindex = $(this).css("z-index");
			pretext = ("translateZ(");
			subtext = ("px)");
			sum = pretext + zindex + subtext;
			$(this).css("transform", sum);
		});
		return false;
	}
	else {
		$.unthreed();
	}
});

$.unthreed = function () {
	$(bw).toggleClass("notthreed").toggleClass("threed");
	$(bw + "#book").css('transform', "rotatex(0deg) rotatey(0deg)");
	$(bw + ".page").attr("style", "z-index:" + four);
	$($(bw + "#book > ul > li").get().reverse()).each(function (i) {
		four = i * 4;
		$(this).css("z-index", four);
	});
	$(bw + "#navfirst").click();
}