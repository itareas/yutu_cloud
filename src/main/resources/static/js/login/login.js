document.onkeydown = function (e) {
    var theEvent = window.event || e;
    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code == 13) {
        submitFormInfo();
    }
}
$(function () {
    if (window != top) {
        top.location.href = location.href;
    }
    $('body').fontFlex(12, 16, 70);
    initValidateCode();
    $("#loginButton").on("click", function () {
        submitFormInfo();
    });

});

function submitFormInfo() {
    var userAccount = $("#userAccount").val();
    var userPwd = $("#userPwd").val();
    var code = $("#code").val();
    if (userAccount == null || userAccount == '') {
        $("#errorInfo").text("用户名不能为空");
        $("#userAccount").focus();
        return;
    }
    if (userPwd == null || userPwd == '') {
        $("#errorInfo").text("密码不能为空");
        $("#userPwd").focus();
        return;
    }
    if (code == null || code == '') {
        $("#errorInfo").text("验证码不能为空");
        $("#code").focus();
        return;
    }
    $.ajax({
        url: '../login/getLoginVerification',
        type: 'POST',
        async: false,
        data: {userAccount: userAccount, userPwd: hex_md5(userPwd),code:code},
        dataType: "JSON",
        success: function (data) {
            if (data.status == 1) {
                window.location.href = "./index";
            } else if (data.status == 2){
                initValidateCode();
                $("#code").val("");
                $("#code").focus();
                $("#errorInfo").text("验证码不正确！");
            } else {
                initValidateCode();
                $("#userAccount").val("");
                $("#userPwd").val("");
                $("#code").val("");
                $("#userAccount").focus();
                $("#errorInfo").text("用户密码错误！");
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

/**
 * 初始化验证码
 */
function initValidateCode() {
    var width = $("#validateCodeDiv").width();
    var height = $("#validateCodeDiv").height();
    var src = "/login/captchato?width=" + width + "&height=" + height;
    $("#validateCode").attr("src", src + "&time=" + (new Date().getTime()));
    $("#validateCode").on("click", function () {
        $("#validateCode").attr("src", src + "&time=" + (new Date().getTime()));
    });
}