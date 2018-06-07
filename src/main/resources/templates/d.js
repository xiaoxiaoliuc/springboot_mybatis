var demo1 = {
    HIDE: {
        demo: function (s) {
            $(s).click(function () {
                $(this).hide();
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
    }
}
