/**
 * Created by DinhTu on 5/23/14.
 */
(function($) {
    satelliteAdmin.actionButton = function() {
        this.init();
    };
    satelliteAdmin.actionButton.prototype = {
        constructor: satelliteAdmin.actionButton,
        init: function() {
            this.processLogin();
            this.processSingin();
            this.clickForgetPassword();
        },
        processSingin: function() {
            $(".js-signin").on("click", function() {
                $('#myModal-signin').modal({
                    keyboard: true,
                    backdrop: "static"
                });
                var currentUrl = $(location).attr('href');
                var arr = currentUrl.split("/");
                $(".current_url").val(arr[4]);
                var href = $(this).data("redirect");
                $(".js-delete-ok").attr("href", href);
            });
        },
        processLogin: function() {
            $(".js-login").on("click", function() {
                $('.myModal-login').modal({
                    keyboard: true,
                    backdrop: "static"
                });
                var currentUrl = $(location).attr('href');
                var arr = currentUrl.split("/");
                $(".current_url").val(arr[4]);
            });
        },
        clickForgetPassword: function() {
            $(".js-a-forget-password").on("click", function() {
                $(".js-form-login").slideUp("slow");
                $(".js-form-forget-password").show("slow");
                $(this).parents(".modal-content").find("h4 > b").empty();
                $(this).parents(".modal-content").find("h4 > b").append("Lấy lại mật khẩu");
                $(this).addClass("js-hidden");
                $(".js-a-login").removeClass("js-hidden");
                $(".js-action-login").val("forget-password");
            });
            // procees click login
            $(".js-a-login").on("click", function() {
                $(".js-form-login").slideDown("slow");
                $(".js-form-forget-password").hide();
                $(this).parents(".modal-content").find("h4 > b").empty();
                $(this).parents(".modal-content").find("h4 > b").append("Đăng nhập hệ thống");
                $(this).addClass("js-hidden");
                $(".js-a-forget-password").removeClass("js-hidden");
                $(".js-action-login").val("login");
            });
        }
    };

})(jQuery);