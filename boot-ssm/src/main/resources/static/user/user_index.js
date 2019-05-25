$(() => {
    $("#btnSub").click(() => {
        let tel = $("#tel").val();
        if (!tel) {
            $("#info").text("手机号不为空");
            return false;
        }
        // let matched = /'^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$'/.test(tel);
        // if (!matched) {
        //     $("#info").text("手机号码不正确");
        //     return false;
        // }
        $.ajax({
            type: "POST",
            url: "/user/opt",
            data: {tel: tel},
            success(res) {
                if (res.success) {
                    $("#info").text(res.data);
                } else {
                    $("#info").text(res.msg);
                }
            }
        })
    });
})