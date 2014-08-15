/**
 * Created by DinhTu on 5/23/14.
 */
(function($){
    satelliteAdmin.actionButton = function(){
        this.init();
    };
    satelliteAdmin.actionButton.prototype = {
        constructor : satelliteAdmin.actionButton,
        init : function(){
            this.processButtonDelete();
            this.processAdd();
            this.processCheckboxSelection();
            this.clickForgetPassword();
            this.processTooltipDelete();
            this.processSelectAll();
            this.processDelete();
        },

        processButtonDelete : function(){
            $(".btn-delete").on("click", function(){
                var arr = [];
                $(".checkbox-selection:checked").each(function(i){
                    arr[i] = $(this).val();
                });
                $('#js-question-delete').modal({keyboard: true, backdrop : "static"});
                var href = $(this).data("delete-all");
                var strId = arr.join(",");
                $(".js-delete-ok").attr("href", href + strId);
            });
        },
        processAdd : function(){		
            $(".btn-add").on("click", function(){
                $('#myModal').modal({keyboard: true, backdrop : "static"});
//                $(".js-form-action").val("addOrUpdate");
            });
        },
        processDelete : function(){
            // load confirm hỏi có xóa hay không
            $(".table-a-delete").on("click", function(){
                $('#js-question-delete').modal({
                    keyboard: true,
                    backdrop : "static"
                });
                var href = $(this).data("redirect");
                $(".js-delete-ok").attr("href", href);
            });
        },
        processCheckboxSelection : function(){
            $(".checkbox-selection").on("click", function(){
                var flag = $(this).prop("checked");
                if(flag)
                    $(this).parents("tr").addClass("success");
                else
                    $(this).parents("tr").removeClass("success");
            });
        },

        clickForgetPassword : function(){
            $(".js-a-forget-password").on("click", function(){
                $(".js-form-login").slideUp("slow");
                $(".js-form-forget-password").show("slow");
                $(".panel-heading > h4 > b").empty();
                $(".panel-heading > h4 > b").append("Lấy lại mật khẩu");
                $(this).addClass("js-hidden");
                $(".js-a-login").removeClass("js-hidden");
                $(".form-horizontal").attr("action", "forget-password");
            });
            // procees click login
            $(".js-a-login").on("click", function(){
                $(".js-form-login").slideDown("slow");
                $(".js-form-forget-password").hide();
                $(".panel-heading > h4 > b").empty();
                $(".panel-heading > h4 > b").append("Đăng nhập hệ thống");
                $(this).addClass("js-hidden");
                $(".js-a-forget-password").removeClass("js-hidden");
                $(".form-horizontal").attr("action", "login");
            });
        },
        processTooltipDelete : function(){
            $('.table-a-delete').tooltip({
                animation : true,
                trigger : "hover",
                placement : "top",
                title : "Xóa"
            });

            $('.table-a-edit').tooltip({
                animation : true,
                trigger : "hover",
                placement : "top",
                title : "Chỉnh sửa"
            });
        },
        processSelectAll : function(){
            $(".js-ck-all").on("click", function(){
                var flag = $(this).prop("checked");
                $(".checkbox-selection").prop("checked", flag);
                if(flag){
                    console.log('đ');
                    $(this).parents("#data").find("tbody > tr").addClass("success");
                }else
                    $(this).parents("#data").find("tbody > tr").removeClass("success");
            });
        }


    };

})(jQuery);