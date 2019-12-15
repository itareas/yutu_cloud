/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.18 : Database - yutucloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yutucloud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `yutucloud`;

/*Table structure for table `t_cod_config` */

DROP TABLE IF EXISTS `t_cod_config`;

CREATE TABLE `t_cod_config` (
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `config_code` varchar(64) DEFAULT NULL COMMENT '配置编码',
  `config_name` varchar(512) DEFAULT NULL COMMENT '配置名称',
  `config_parent` varchar(64) DEFAULT NULL COMMENT '配置父类',
  `config_level` int(11) DEFAULT NULL COMMENT '配置等级',
  `config_status` int(11) DEFAULT '1' COMMENT '配置状态：0:关闭；1:开启',
  `order_by` int(11) DEFAULT '1' COMMENT '排序',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='通用_码表';

/*Data for the table `t_cod_config` */

/*Table structure for table `t_log_error` */

DROP TABLE IF EXISTS `t_log_error`;

CREATE TABLE `t_log_error` (
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `project_name` varchar(128) DEFAULT NULL COMMENT '项目名称',
  `create_date` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `log_level` varchar(64) DEFAULT NULL COMMENT '等级',
  `log_category` varchar(128) DEFAULT NULL COMMENT '类别',
  `file_name` varchar(256) DEFAULT NULL COMMENT '文件名',
  `thread_name` varchar(64) DEFAULT NULL COMMENT '线程名称',
  `log_line` varchar(256) DEFAULT NULL COMMENT '线程日志',
  `all_category` varchar(515) DEFAULT NULL COMMENT '所有类型',
  `log_message` text COMMENT '详细信息',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志管理_异常错误信息表';

/*Data for the table `t_log_error` */

/*Table structure for table `t_log_landing` */

DROP TABLE IF EXISTS `t_log_landing`;

CREATE TABLE `t_log_landing` (
  `uuid` varchar(64) NOT NULL COMMENT '主键编码',
  `login_userid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `login_account` varchar(64) DEFAULT NULL COMMENT '登录账号',
  `login_ip` varchar(128) DEFAULT NULL COMMENT '登陆者的ip',
  `login_sessionid` varchar(128) DEFAULT NULL COMMENT '登陆sessionId',
  `login_date` datetime DEFAULT NULL COMMENT '登陆时间',
  `login_type` varchar(32) DEFAULT NULL COMMENT '登陆类型： 登陆/退出登录',
  `login_result` int(11) DEFAULT NULL COMMENT '登陆结果   0：登陆成功   1：登陆失败',
  `login_appname` varchar(256) DEFAULT NULL COMMENT '登录子系统/模块名称',
  `login_address` varchar(256) DEFAULT NULL COMMENT '登陆系统地址',
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统日志_用户登录表';

/*Data for the table `t_log_landing` */

insert  into `t_log_landing`(`uuid`,`login_userid`,`login_account`,`login_ip`,`login_sessionid`,`login_date`,`login_type`,`login_result`,`login_appname`,`login_address`,`remarks`) values ('4c9187d0-7006-4ba9-bea3-e2195c2dce1f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1D322A4382FEBC9B09D8D5F8D4B6EFB5','2019-12-15 18:05:17','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('51645a9d-a09f-4b33-bd28-14fd9904e618','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AA52FFA895C262E13F9CD9830AFDC26F','2019-12-15 15:24:17','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('6916d72d-bc59-4095-bd63-f1a97d6a5939','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A891172764096F09BE8D4626CF76296A','2019-12-15 19:22:29','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('801e1ee0-7b0a-4950-bd73-679a9c446e33','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','71AFC29AD089E300DC7F253C18A2BFB3','2019-12-15 21:01:07','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('8cbfb759-9344-4015-8a54-c3ea88076eba','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','482A59AC6390F2F7422E0822C73ACEC2','2019-12-15 19:21:03','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('9cd540ee-e68a-468c-8ea9-73b34b6e1138','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1D322A4382FEBC9B09D8D5F8D4B6EFB5','2019-12-15 18:04:58','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('9f540ec2-ddc6-48c7-9912-2c6f83d31fdc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E4FDE412CFFAF69840D8CC3D3D3235E2','2019-12-15 19:28:41','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('b46d918d-c394-4571-a13d-12439bb7a3fe','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4AC95E6E9CD124952F6D825CD2C45558','2019-12-15 21:46:17','用户登陆',0,NULL,'/login/getLoginVerification',NULL),('c3ab3bda-f7f3-4798-b8b9-5b784613788b',NULL,'admin','0:0:0:0:0:0:0:1',NULL,'2019-12-15 18:04:54','用户登陆',0,NULL,'/login/getLoginVerification',NULL);

/*Table structure for table `t_log_operation` */

DROP TABLE IF EXISTS `t_log_operation`;

CREATE TABLE `t_log_operation` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `operate_db` varchar(64) DEFAULT NULL COMMENT '操作数据库',
  `operate_dt` varchar(64) DEFAULT NULL COMMENT '操作表',
  `operate_type` varchar(64) DEFAULT NULL COMMENT '操作类型   增删改',
  `operate_primarykey` varchar(2048) DEFAULT NULL COMMENT '主键',
  `operate_content` text COMMENT '操作内容',
  `operate_person` varchar(64) DEFAULT NULL COMMENT '操作人',
  `operate_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  `log_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '日志类型',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志管理_数据操作表';

/*Data for the table `t_log_operation` */

/*Table structure for table `t_menu_business` */

DROP TABLE IF EXISTS `t_menu_business`;

CREATE TABLE `t_menu_business` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `menu_parent` varchar(64) DEFAULT NULL COMMENT '菜单父类id',
  `menu_title` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `menu_type` int(11) DEFAULT '2' COMMENT '菜单类型：1.外部sso弹出  2.内部跳转',
  `menu_url` varchar(512) DEFAULT NULL COMMENT '菜单url地址',
  `menu_page_class` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中的class，为了调整配置样式',
  `menu_page_img` varchar(512) DEFAULT NULL COMMENT '页面中的图标地址',
  `menu_page_other` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中其他的属性值',
  `menu_status` int(11) DEFAULT '0' COMMENT '菜单状态  0：未锁定  1：已锁定',
  `order_by` int(11) DEFAULT '1' COMMENT '排序',
  `delete_status` int(11) DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理_业务菜单';

/*Data for the table `t_menu_business` */

/*Table structure for table `t_menu_system` */

DROP TABLE IF EXISTS `t_menu_system`;

CREATE TABLE `t_menu_system` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `menu_title` varchar(512) DEFAULT NULL COMMENT '菜单名称',
  `menu_type` int(11) DEFAULT '1' COMMENT '菜单类型：1.外部sso弹出  2.内部跳转',
  `menu_url` varchar(512) DEFAULT NULL COMMENT '菜单url地址',
  `menu_page_class` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中的class，为了调整配置样式',
  `menu_page_other` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中其他的属性值',
  `order_by` int(11) DEFAULT '1' COMMENT '排序',
  `delete_status` int(11) DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理_门户子系统';

/*Data for the table `t_menu_system` */

insert  into `t_menu_system`(`uuid`,`menu_title`,`menu_type`,`menu_url`,`menu_page_class`,`menu_page_other`,`order_by`,`delete_status`,`remarks`) values ('0c0fced6-1f12-11ea-a564-f875a40f96a2','案例展示',1,NULL,NULL,NULL,1,0,NULL),('ac4784b7-1f12-11ea-a564-f875a40f96a2','运算服务',1,NULL,NULL,NULL,2,0,NULL),('d385da86-1f12-11ea-a564-f875a40f96a2','数据服务',1,NULL,NULL,NULL,3,0,NULL);

/*Table structure for table `t_sys_organization` */

DROP TABLE IF EXISTS `t_sys_organization`;

CREATE TABLE `t_sys_organization` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `org_parent` varchar(64) DEFAULT NULL COMMENT '部门父类id(表格树)',
  `org_code` varchar(64) DEFAULT NULL COMMENT '部门特殊编码',
  `org_name` varchar(512) DEFAULT NULL COMMENT '部门名称',
  `org_phone` varchar(64) DEFAULT NULL COMMENT '部门电话',
  `org_address` varchar(2048) DEFAULT NULL COMMENT '部门地址',
  `org_Manager` varchar(64) DEFAULT NULL COMMENT '部门负责人',
  `org_status` int(11) DEFAULT '0' COMMENT '部门状态 0：未锁定  1：已锁定',
  `order_by` int(11) DEFAULT '1' COMMENT '排序',
  `delete_status` int(11) DEFAULT '0' COMMENT '逻辑删除 0:未删除,  1:已删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_组织表';

/*Data for the table `t_sys_organization` */

insert  into `t_sys_organization`(`uuid`,`org_parent`,`org_code`,`org_name`,`org_phone`,`org_address`,`org_Manager`,`org_status`,`order_by`,`delete_status`,`remarks`) values ('8fc09900-1f11-11ea-a564-f875a40f96a2','0','yutu','宇图',NULL,NULL,NULL,0,1,0,NULL);

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `uuid` varchar(64) DEFAULT NULL COMMENT '编码',
  `role_parent` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色父类ID（角色树）',
  `role_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `role_status` int(11) DEFAULT '0' COMMENT '角色状态 0：未锁定  1：已锁定',
  `order_by` int(11) DEFAULT '1' COMMENT '排序',
  `delete_status` int(11) DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_权限表';

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`uuid`,`role_parent`,`role_name`,`role_status`,`order_by`,`delete_status`,`remarks`) values ('b5aa892c-1f11-11ea-a564-f875a40f96a2','0','管理员',0,1,0,NULL);

/*Table structure for table `t_sys_role_menubus` */

DROP TABLE IF EXISTS `t_sys_role_menubus`;

CREATE TABLE `t_sys_role_menubus` (
  `uuid` varchar(64) DEFAULT NULL COMMENT '编码',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `menubus_uuid` varchar(64) DEFAULT NULL COMMENT '业务菜单uuid',
  `remarks` text COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_角色和业务菜单中间表';

/*Data for the table `t_sys_role_menubus` */

/*Table structure for table `t_sys_role_menusys` */

DROP TABLE IF EXISTS `t_sys_role_menusys`;

CREATE TABLE `t_sys_role_menusys` (
  `uuid` varchar(64) DEFAULT NULL COMMENT '编码',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `menusys_uuid` varchar(64) DEFAULT NULL COMMENT '系统菜单uuid',
  `remarks` text COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_角色和系统菜单中间表';

/*Data for the table `t_sys_role_menusys` */

insert  into `t_sys_role_menusys`(`uuid`,`role_uuid`,`menusys_uuid`,`remarks`) values ('f36e6886-1f12-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','0c0fced6-1f12-11ea-a564-f875a40f96a2',NULL),('083137d8-1f13-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','ac4784b7-1f12-11ea-a564-f875a40f96a2',NULL),('10ea09d5-1f13-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','d385da86-1f12-11ea-a564-f875a40f96a2',NULL);

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `uuid` varchar(64) NOT NULL COMMENT '主键',
  `user_code` varchar(64) DEFAULT NULL COMMENT '用户特殊编码',
  `user_account` varchar(128) DEFAULT NULL COMMENT '用户登陆名',
  `user_pwd` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `user_question` varchar(256) DEFAULT NULL COMMENT '密码提示',
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户真实姓名',
  `user_sex` int(11) DEFAULT NULL COMMENT '用户性别  0：保密   1：男   2：女''',
  `user_title` varchar(256) DEFAULT NULL COMMENT '用户职称',
  `user_phone` varchar(64) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(256) DEFAULT NULL COMMENT '用户邮件',
  `user_status` int(11) DEFAULT '0' COMMENT '用户锁定  0：正常   1：锁定',
  `order_by` int(11) DEFAULT '1' COMMENT '排序',
  `delete_status` int(11) DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`uuid`,`user_code`,`user_account`,`user_pwd`,`user_question`,`user_name`,`user_sex`,`user_title`,`user_phone`,`user_email`,`user_status`,`order_by`,`delete_status`,`remarks`) values ('ae771cf1-23f0-4e8e-b235-fc12a6fb4884','yt-001','admin','1168d53c7f5094945a60aa6d2320e7c4','admin','管理员',1,NULL,'18001030020','it_zbc@outlook.com',0,1,0,NULL);

/*Table structure for table `t_sys_user_organization` */

DROP TABLE IF EXISTS `t_sys_user_organization`;

CREATE TABLE `t_sys_user_organization` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `org_uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门uuid',
  `user_uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户uuid',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_用户部门中间表';

/*Data for the table `t_sys_user_organization` */

insert  into `t_sys_user_organization`(`uuid`,`org_uuid`,`user_uuid`,`remarks`) values ('cde1e742-1f11-11ea-a564-f875a40f96a2','f875a40f96a2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884',NULL);

/*Table structure for table `t_sys_user_role` */

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `user_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_用户角色表';

/*Data for the table `t_sys_user_role` */

insert  into `t_sys_user_role`(`uuid`,`role_uuid`,`user_uuid`,`remarks`) values ('e3fb4794-1f11-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
