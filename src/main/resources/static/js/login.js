/*
 * Created by 陈志红 on 2018/5/21.
 */
$(function () {
    if ($("#admin").html() != null && $("#admin").html() != "") {
        var pageNo = $("input:hidden[name='pageNo']").val()
        if (pageNo == "" || pageNo == "null") {
            $("#yunwei").remove();
        }
        $(".right").show("slow");
        $(".login").hide();
    } else {
        $(".login").show("slow");
        $(".right").hide();
    }

    // 登录按钮点击事件
    $("#log").click(function () {
        $("#flag").val(0);
        $(".dialog-cover").css("display", "block");
        $(".login-window").css("display", "block");
        $("#username").focus();
        $("#captcha").val("");
        $("#captchaImage").attr("src", "./login/captchato?timestamp=" + (new Date()).valueOf());

    });
    //验证码点击事件
    $("#captchaImage").on('click', function () {
        $("#captchaImage").attr("src", "./login/captchato?timestamp=" + (new Date()).valueOf());
    });

    // 四个中心登录或跳转页面
    $(".navigate li:not(.no-pro)").click(function () {
        //点击事件后获取
        if ($(".login").css("display") == "block") {
            var id = $(this).attr("id");
            $("#flag").val(id);
            $(".dialog-cover").css("display", "block");
            $(".login-window").css("display", "block");
            $("#username").focus();
            $("#captchaImage").attr("src", "./login/captchato?timestamp=" + (new Date()).valueOf());

        } else {
            var url = $(this).attr("url");
            var target = $(this).attr("target");
            var address;
            if (url == "") {
                // $(".main").load("default.do");
                address = "redirect/default.do";
            } else {
                address = url;
            }

            if (target == '_blank') {
                window.open(address);
                return false;
            } else {
                window.location.href = address;
                return false;
            }
        }
    });
    // 登录框的关闭按钮
    $(".login-win-close").hover(function () {
        $("#close").css("width", "20px").css("height", "20px");
    }, function () {
        $("#close").css("width", "14px").css("height", "14px");
    });
    $(".login-win-close").click(function () {
        // 遮罩层及登录框隐藏
        $(".dialog-cover").css("display", "none");
        $(".login-window").css("display", "none");
        // 输入框及错误提示框清空，错误提示框隐藏
        $("#username").val("");
        $("#pwd").val("");
        $("#error").html("").css("display", "none");
    });
    // 回车提交事件
    $("#username").keydown(function () {
        if (event.keyCode == "13") {
            $("#submit").click();
        }
    })
    $("#captcha").keydown(function () {
        if (event.keyCode == "13") {// keyCode=13是回车键
            $("#submit").click();
        }
    });
    $("#pwd").keydown(function () {
        if (event.keyCode == "13") {
            $("#submit").click();
        }
    })
    // 登录
    $("#submit").click(function () {
        var user;
        var username = $("#username").val();
        var pwd = hex_md5($("#pwd").val());
        var yanzhengma = $("#captcha").val();
        var status = $("#flag").val();
        if (username == "") {
            $("#error").html("请输入账户名").css("display", "block");
        } else if (pwd == "") {
            $("#error").html("请输入密码").css("display", "block");
        } else if (yanzhengma == "") {
            $("#error").html("请输入验证码").css("display", "block");
            $("#container").reload();
        } else if (username != "" && pwd != "" && yanzhengma != "") {
            //将账号，验证码替换全部
            username = username.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
            yanzhengma = yanzhengma.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
            status = status.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
            longDo(yanzhengma, status);

        }
    });

    $("#user").click(function () {
        $("#edit").toggle(200);
    });
    $(document).click(function (e) {
        var ele = e ? e.target : window.event.srcElement;
        if (ele.id !== 'user' && ele.id !== 'admin') {
            $("#edit").css("display", 'none');
        }
    });

    // 退出
    $("#exit").click(function () {
        window.location.href = "login/logout";
    });
//登陆提示
    var msgLogin = $("#msgLogin").val();
    if (msgLogin.length > 0 && msgLogin != "null") {
        layer.alert(msgLogin, {
            skin: 'msgLogin'
        });
    }

});


//判断验证码
function checked(yanzhengma, status) {
    $.ajax({
        url: './login/check',
        type: 'POST',
        data: {'yanzhengma': yanzhengma},
        success: function (data) {
            if (data == "false") {
                $("#captchaImage").attr("src", "./login/captchato?timestamp=" + (new Date()).valueOf());
                $("#error").html("请输入正确的验证码！").css("display", "block");
            } else {
                longDo(status);
            }
        }
    });
}

// 登录
function longDo(yanzhengma, data) {
    var loginName = $.trim(document.getElementById("username").value)
    var password = $.trim(document.getElementById("pwd").value);
    loginName = loginName.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
    if (loginName != "" && password != "" && password !== "") {
        $.ajax({
            url: '../login/getLoginVerification',
            type: 'POST',
            async: false,
            data: {userAccount: loginName, userPwd:hex_md5(password), yanzhengma : yanzhengma},
            dataType: "JSON",
            success: function (data) {
                if (data.status == 0) {
                    $("#error").html(data.msg).css("display", "block");
                    $("#captchaImage").attr("src", "./login/captchato?timestamp=" + (new Date()).valueOf());
                } else {

                    // 动态获取六大菜单 2018-12-13
                    $(".dialog-cover").css("display", "none");
                    $(".login-window").css("display", "none");
                    // 输入框及错误提示框清空，错误提示框隐藏
                    $("#username").val("");
                    $("#pwd").val("");
                    $("#error").html("").css("display", "none");
                    $(".login").hide("slow");
                    $(".right").show("slow");
                    window.location.reload();
                }
            },
            error: function () {
                //$("#error").html("您输入的账号密码错误!").css("display", "block");
                $("#error").html("您的机器未获得本网站的授权,请联系管理员!").css("display", "block");
                $("#username").val("");
                $("#pwd").val("");
                $("#captcha").val("");
                $("#username").attr({readonly: 'true'});
                $("#pwd").attr({readonly: 'true'});
                $("#captcha").attr({readonly: 'true'});
            },
            codeError: function () {
                $("codeError").html("您输入的验证码错误!").css("display", "block");
            }
        });
    } else {
        $("#error").html("请填写完整信息！").css("display", "block");
    }

}

function sub_exit() {
    layer.closeAll();
}



