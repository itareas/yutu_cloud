$(function () {
    loadMenu();

    $("#user").click(function() {
        $("#edit").toggle(200);
    });
});

//加载菜单
function loadMenu() {
    //加载菜单
    $.ajax({
        url: '/home/menu/sys/list',
        type: 'POST',
        async: true,
        data: {},
        dataType: "JSON",
        success: function (msgPack) {
            if (msgPack.status == 1) {
                $.each(msgPack.data, function (i, item) {
                    var menuHtml = '<li id="' + item.uuid + '" class="' + item.menuPageClass + '" url="' + item.menuUrl + '" parentId="" target="_blank"  onclick="sysClick(this)"> <img src="' + item.menuPageOther + '"/><p>' + item.menuTitle + '</p></li>'
                    $("#menuList").append(menuHtml);
                })

            } else {
                alert("获得菜单列表失败");
            }

        },
        error: function (error) {
            console.log(error);
        }
    });
}

//系统菜单点击事件
function sysClick(item) {
    //点击事件后获
    var url = $(item).attr("url");
    var target = $(item).attr("target");
    var address;
    if (url == "" || url==undefined) {
        address = "/";
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

//退出
function logoutClick() {
    window.location.href = "/login/logout";
}

//权限管理系统
function managementClick() {
    window.open("/management"); 
}