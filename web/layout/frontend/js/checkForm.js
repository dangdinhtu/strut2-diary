/**
 * Created by DinhTu on 5/23/14.
 */
(function($) {
    satelliteAdmin.checkForm = function() {
        this.init();
    };
    satelliteAdmin.checkForm.prototype = {
        constructor: satelliteAdmin.checkForm,
        init: function() {
            this.checkSingin();
        },
        checkSingin: function() {
            $("form").on("submit", function() {
                var has_empty = true;
                // check required 
                $(this).find('.required').each(function() {
                    var value = $(this).val();
                    if(value ===  ""){
                        has_empty = false;
                        var alertRequired = $(this).data("required");
                        $(this).parent().append("<span class='text-danger'>" + alertRequired + "</span>");
                    }
                });
                // check repassword
                var password = $("input[name=password]").val();
                var rePassword = $("input[name=rePassword]").val();
                if(password !== rePassword){
                    has_empty = false;
                    $("input[name=rePassword]").parent().append("<span class='text-danger'>Mật khẩu chưa khớp</span>");
                }  
                if (!has_empty) {
                    return false;
                }
            });
        }
    };

})(jQuery);