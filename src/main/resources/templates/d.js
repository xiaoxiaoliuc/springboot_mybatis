
var demo1 = {
   HIDDEN:{
     hiden:function (s) {
         $(s).on("click",function () {
             $(this).hide();
         })
     },
     fadeout:function (s,t) {
         $(s).click(function () {
            $(this).fadeOut(t);
         });
     },
     animate:function(s,t){
         $(s).on("click",function () {
            $(t).animate({height:'300px',opacity:'0.4'},"slow");
             $(t).animate({width:'300px',opacity:'0.8'},"slow");
             $(t).animate({height:'100px',opacity:'0.4'},"slow");
             $(t).animate({width:'100px',opacity:'0.8'},"slow");
         });
     },
     chickHide:function (s) {
           $(s).click(function () {
               $(this).parent().hide();
           });
       },
     chickShow:function (s,t) {
         $(s).click(function () {
            $(t).show();
         });
     },
     toggleShow:function (s,t) {
         $(s).click(function () {
             $(t).slideToggle("show");
         })
     }
},
    DATE:{
        getDate: function (s,t) {
            $(s).click(function () {
                $(t).html(Date())
            })
        }
    },
    MOUSE:{
        mouseAbout:function (s,t) {
            $(s).mousemove(function (e) {
                x = e.clientX;
                y = e.clientY;
                $(t).html(x+","+y);
            }),
            $(s).mouseout(function () {
                $(t).html("");
            })
        }},
    WRITE1:{
            getAndWrite:function (s,t) {
                $(s).change(function () {
                    $(t).html($(s).val());
                })
            }
    },
}