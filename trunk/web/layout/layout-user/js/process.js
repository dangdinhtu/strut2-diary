$(document).ready(function () {
            $(".loading").fadeOut();
            $(".save").fadeIn();
            $("#tit-here").click(function () {
                if ($(this).val() == "Enter title !")
                    $(this).val("");                   
            });
            
            $("#text-here").click(function () {
                if ($(this).val().trim() == "write content here!")
                    $(this).val("");
                    $(".loading").fadeIn();
                    $(".save").fadeOut();

            });
            $("#text-here").blur(function () {                
                if ($(this).val().trim() == "")
                    $(this).val("write content here!");
                $(".loading").fadeOut();
                $(".save").fadeIn();
                               
                $("#number-count").text($(this).val().length);
            });
            
            var count = 1;
            $(".icon-left").click(function () {
                if (count == 1) {
                    $("#menu-hide").fadeIn();
                    $(".wflow").attr("style", "margin-left:200px;");                    
                    $(this).attr("style", "margin-left:200px;");
                    count = 0;
                }
                else {
                    $("#menu-hide").fadeOut();
                    $(".wflow").attr("style", "");
                    $(this).attr("style", "");
                    count = 1;
                }
            });
            
        }); 