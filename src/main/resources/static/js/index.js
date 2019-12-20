 $(function () {
     loadMenu();

 });

//加载菜单
 function loadMenu() {
     //加载菜单
     $.ajax({
         url: '../home/getSysMenuList',
         type: 'POST',
         async: true,
         data: {},
         dataType: "JSON",
         success: function (msgPack) {
             if (msgPack.status == 1) {
                 $.each(msgPack.data,function (i,item) {
                     $("#menuList").append('<li class="menuLi"><a href="'+item.menuUrl+'" target="_blank">'+item.menuTitle+'</a></li>');
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