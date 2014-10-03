/**
 * Created by DinhTu on 5/23/14.
 */
/**
 * Created by DinhTu on 5/23/14.
 */
(function($){
    window.satelliteAdmin = {
        version : 1.0,
        name : "System Website Satellite",
        autho : "Đặng Đình Tứ"
    };

    satelliteAdmin.main = function(){
        this.init();
    };
    satelliteAdmin.main.prototype = {
        constructor : satelliteAdmin.main,
        init : function(){
            var actionButtonObj = new satelliteAdmin.actionButton();
        }
    };

    $(document).ready(function () {
        var main = new satelliteAdmin.main();
    });

})(jQuery);

