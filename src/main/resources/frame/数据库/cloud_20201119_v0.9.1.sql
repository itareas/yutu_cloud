/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 : Database - cloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `cloud`;

/*Table structure for table `t_cod_app` */

DROP TABLE IF EXISTS `t_cod_app`;

CREATE TABLE `t_cod_app` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `app_key` varchar(64) DEFAULT NULL COMMENT '应用标识',
  `app_name` varchar(512) DEFAULT NULL COMMENT '应用名称',
  `app_type` int DEFAULT '0' COMMENT '应用类型：0：项目； 1:产品',
  `enable` int DEFAULT '1' COMMENT '是否启动：0：不启动； 1：启动',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='码表_系统标识';

/*Data for the table `t_cod_app` */

insert  into `t_cod_app`(`uuid`,`app_key`,`app_name`,`app_type`,`enable`,`update_time`,`remarks`) values 
('4091cadd-d0a1-11ea-b236-f4e9d46bc792','ZKYT-HB-1912-001','黄山新型智慧城市系统',0,1,'2020-07-28 15:09:52',NULL),
('5a94f38a-d0a1-11ea-b236-f4e9d46bc792','ZKYT-PT-2020-002','模型应用展示平台',1,1,'2020-07-28 15:12:03',NULL),
('906dc8b4-d0a1-11ea-b236-f4e9d46bc792','ZKYT-PT-2020-003','精准治霾调控平台',1,1,'2020-07-28 15:12:00',NULL),
('aa287ec1-d0a1-11ea-b236-f4e9d46bc792','ZKYT-PT-2020-004','定时任务平台',1,1,'2020-07-28 15:12:36',NULL),
('f053194c-d0a2-11ea-b236-f4e9d46bc792','ZKYT-PT-2020-001','模型接口控制平台',1,1,'2020-07-28 15:22:05',NULL),
('f053194c-d0a2-11ea-b236-f4e9d46bc793','ZKYT-PT-2020-005','通用业务可视化组件',1,1,'2020-08-20 14:09:01',NULL);

/*Table structure for table `t_cod_config` */

DROP TABLE IF EXISTS `t_cod_config`;

CREATE TABLE `t_cod_config` (
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `config_code` varchar(64) DEFAULT NULL COMMENT '配置编码',
  `config_name` varchar(512) DEFAULT NULL COMMENT '配置名称',
  `config_parent` varchar(64) DEFAULT NULL COMMENT '配置父类',
  `config_level` int DEFAULT NULL COMMENT '配置等级',
  `config_status` int DEFAULT '1' COMMENT '配置状态：0:关闭；1:开启',
  `order_by` int DEFAULT '1' COMMENT '排序',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='码表_通用配置';

/*Data for the table `t_cod_config` */

insert  into `t_cod_config`(`uuid`,`config_code`,`config_name`,`config_parent`,`config_level`,`config_status`,`order_by`,`update_time`,`remarks`) values 
('2500955e-2483-11ea-941d-f875a40f96a2','yutu_web','中科宇图公司','f7d522d1-2482-11ea-941d-f875a40f96a2',2,1,1,NULL,'http://localhost:8096/webapi'),
('f7d522d1-2482-11ea-941d-f875a40f96a2','appName','单点登录列表','0',1,1,1,'2019-12-22 14:20:10',NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志_异常信息表';

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
  `login_result` int DEFAULT NULL COMMENT '登陆结果   0：登陆成功   1：登陆失败',
  `login_appname` varchar(256) DEFAULT NULL COMMENT '登录子系统/模块名称',
  `login_address` varchar(256) DEFAULT NULL COMMENT '登陆系统地址',
  `appkey` varchar(128) DEFAULT NULL COMMENT 'appKey',
  `token` varchar(128) DEFAULT NULL COMMENT 'token',
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志_登录记录表';

/*Data for the table `t_log_landing` */

insert  into `t_log_landing`(`uuid`,`login_userid`,`login_account`,`login_ip`,`login_sessionid`,`login_date`,`login_type`,`login_result`,`login_appname`,`login_address`,`appkey`,`token`,`remarks`) values 
('005e6f6e-f135-4de4-8eea-20048abc816f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','447DEF2793D8604F4FBB47489372B706','2020-02-17 10:27:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0081d8f2-3c01-490c-9d27-a8da7d2af08c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','ACA2C9B6C0497CD3F70693ED067F9E43','2020-01-07 22:39:54','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0161c26f-7e4f-42c9-ab14-1c9230bc0e5f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D005E1511CA190C51AF16CB57E2A9ED4','2019-12-29 16:51:24','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('01e69e36-4d4a-4d4b-8b91-a481bcc12a84','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0A07FCF851C432DFA15286B62C524F96','2020-01-13 10:07:27','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('01f172e5-01b5-4216-b098-97c52ad7f003','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','222A7A00691E03E31B60A8A9AD2E8AE0','2019-12-28 22:57:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('01f3237e-7ed8-40e5-96f6-d2f03149410a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5D57F34DC0193288EF46C515C16875F8','2019-12-29 15:28:29','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('01fa7619-e21f-4b2d-ae94-ac39979a8fed','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C7F778B091F99D2D24508B55DE3A5D8D','2019-12-29 22:10:05','登陆',1,'子系统一','/loginSSO','yutu_web','8f8ccc24-7545-4ee2-a603-b38d66a56387',NULL),
('040a28fe-d20b-4757-b5b8-e7a07c48e96f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.169.222','BB369E82E73B3BC0D799DCC6996A84E7','2020-01-13 11:32:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('043033fa-d6dc-4f92-b2bf-30eadd2da261','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','76F8E651B3CBDE4BE1ECEAFBEE94C9EA','2019-12-29 23:00:36','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('046339ab-d556-4b2e-bf7e-f9081c60829b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','50422041ABF8E8F747A4135344ACF934','2020-02-06 11:54:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('04b39618-d109-4d6b-94af-f7fc1eb89b1e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','ADFE7070870A8D619E0E04E4D8A9D92B','2019-12-29 16:12:02','登陆',1,'子系统一','/loginSSO','yutu_web','c91ddbd9-144d-4a5c-bd91-a1e40ba85f5e',NULL),
('04bc0f8e-a717-422f-a0ec-ac4e3fbf1b4e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E8B7EE1764B20EBFE95AEB10CF9ACD62','2019-12-29 14:54:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('060b9170-465b-4225-a464-7e3b2cb0bd9d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F0D2337ED932466BAD4BADF8835A957B','2020-01-12 16:23:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('06941970-bb32-4424-b7e0-6bf967a2f61e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','12716F9FE74D3DA2C4D82B724273DFE6','2019-12-28 22:05:30','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('07c602b7-2b4b-4c78-81ed-fded0b7d7f91','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A60F20C81CCCF3DE5DD247AF579D8336','2019-12-29 16:16:09','登陆',1,'子系统一','/loginSSO','yutu_web','59270a25-cad9-4977-ac84-e74c07aa09d1',NULL),
('07f887be-e41c-44d8-a52b-827075676bfa','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C92F70DDE7D57DF199F4FF1F87738DA3','2020-01-01 11:20:43','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('086ef10c-2e91-4027-90fa-f334237c919a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','B415B678B5A5B9CD92BB78196EFEB697','2020-02-07 17:12:59','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('08d15661-b240-4a2c-8d83-e8b1dd97de6a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','38303481B958FFA505E6AAF1E24D5230','2019-12-29 23:04:39','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0956e904-12e8-4699-9fad-45f452fed8ad','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.174','7B52888996775017306E7D8C2B6B71B4','2020-01-13 11:31:25','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0a17b66c-baa1-4be3-b6c4-b35f4b2f94e9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D5EB1A90C004C329DA884DE516AD77B4','2019-12-22 10:54:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0a2de812-4f9f-4f6e-bcf5-3919299a5a89','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','539D3707F5BA4A93FFE34DFCFEE5CB76','2019-12-29 16:16:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0bd205c4-429f-4c2b-94d7-92e917713f76','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','60F23EBCB7D0DCB5C7A0B6A336E4037B','2020-11-11 09:34:00','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('0cfc2765-27cf-4d42-ac48-b07e0aaf94ee','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D37313E58616A88627870BB71B3E1E52','2020-01-01 13:14:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0d70c284-3458-4a79-9e47-72fac62f2d3c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C44D6AB0132ACC6418AF5AD5D3DB961A','2020-11-11 10:36:51','登陆',1,'子系统一','/loginSSO','yutu_web','4a46fe0c-c596-461a-91a6-3e60ca811bdb',NULL),
('0f3fda45-0c5d-4d27-931e-8cf0193c809d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','34B8C73A1BC8A34F2D94EEFE1665D84C','2020-01-12 16:32:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('0fce376f-f8ab-4c07-ae3e-ea1877443634','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','29CE7BB2D5B75D61FC28991AD84AABD0','2020-01-12 16:33:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('10d9e754-41b9-4a87-a0c4-2eab5a592b0b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6C5A7E89FD7AE8D9225B3BC6A5D86C83','2019-12-18 22:36:18','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('1158e19e-5f0f-4b1f-9cce-8d08f4ac2bfe','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','48192AE46425160B9FAAC4F1905F56D9','2020-11-11 10:53:45','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('11ae5922-6837-488a-ad2d-eb5e6cdd1a39','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7C60E58DEB8194D982B90956D2E8D117','2019-12-31 22:42:08','登陆',1,'子系统一','/loginSSO','yutu_web','980470cb-74ab-4add-85cf-12b8897c9dd5',NULL),
('125bfebd-89d7-4a24-8c35-97c6b16d3300','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3883024C70485A3F17F6DE7F92DF8EAF','2020-01-01 18:09:18','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1336930d-5333-4425-8f04-3cf22a7e19ec','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','05DBF494AC6B18A744E0FFD100A7E503','2019-12-29 15:00:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1412b8b8-0695-438b-bf4e-4163485bf0ed','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5EABD095B32858A233E112AF97D14709','2019-12-29 14:58:20','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('14829b70-ec2c-48cf-9325-a1d5e3930639','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','85AEF1F9857F0C099185BD23E8A1B852','2020-01-12 15:58:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('14e228c5-2f6e-4508-9ede-7c0eabe9a9fe','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','903CC0F0F87C9FC860CC9DEFE26358EE','2020-11-11 16:04:01','登陆',1,'子系统一','/loginSSO','yutu_web','cloud-zbc18de2334-b8a8-46e4-bee9-c61cf7e27705',NULL),
('1543bea0-cc4b-465e-b388-4ef7df68cd2d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3AE1CE7934D3AF32F649D1D2D773ED6B','2019-12-28 21:52:21','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1573abcd-68a1-4130-8979-e83bdc112dc1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3B3DEFD8DC24013F36F6309087C5B7CC','2019-12-26 22:28:52','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('16150050-777b-468d-8363-f9b345b6692c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AD2B33705B119C4732125D4B9A229A1B','2019-12-22 16:12:38','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('16971105-9dcc-4b6f-ab26-e979140cc5ce','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DDDC7AD44701B7079DFC783924CE5A1C','2019-12-28 23:20:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('180c3bd0-ec52-4a87-b8ac-7e4e0d2be03c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B38A199C97C50564E59DD1319AE18935','2019-12-29 14:58:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('18533ddb-3fc4-4b6c-8293-7225e510b42e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.177','9E526F632661C3852A7A14D60DD2300D','2020-01-18 08:32:39','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('18a7f1a9-021b-4918-b57f-a424749cb50c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B689B35252319327A0A90E432AD561CD','2020-11-11 08:50:41','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('18b47b0e-fc3d-4b78-9b30-71ea5634a44e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5883816B4CAE21BDA7811A608623C941','2020-01-01 11:24:24','登陆',1,'子系统一','/loginSSO','yutu_web','90839012-de65-452a-9598-2d1d82c02071',NULL),
('18dd5a2f-1448-4c8b-acbd-97d536ab8dcf','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','462B007C203B48C9F7BB5EA8C4D30DFE','2020-01-12 21:19:15','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1b384527-5d23-48ee-995b-e06a968f9018','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D4A55C2895B1F0F5B579BAE0E85A886D','2020-01-12 21:22:22','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('1b4d5d6a-c981-48e0-b65f-79bf6f2cac5c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','52DE07EE80DE68FCF50A29A8AE0514E7','2019-12-29 23:04:02','登陆',1,'子系统一','/loginSSO','yutu_web','d34e9542-4df8-4e00-9cfc-6f792152b9fd',NULL),
('1b85004b-2b6e-42d2-addb-b8b8655821e6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2991C198F392DC760FA46DF166947DC1','2020-01-01 13:44:00','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1c06f312-7950-4238-b649-c8c1db3e7470','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','21C69BC3A59E20AD30CE6D46D7B9B923','2019-12-28 23:11:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1ca821f9-6de0-4b9b-80fb-aff1aa498ab0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A7AC591E9B6B26CF0286AF35C6A08BA6','2019-12-29 16:18:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1ca9f1fa-22ee-49ab-a3ac-0aa29369e9e0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','84AA3AA59A4AB7FDDFBFF028F7C8EF91','2019-12-29 16:19:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1cd60f3f-f705-4992-b944-cd53e79ba084','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','60AD09B409F724CF921B65B43A975B93','2020-01-12 15:43:21','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1d3b1ddb-d311-4fe9-89cf-aad70d0db4b5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','31E47686C184A69D772CA9FAF2617181','2019-12-26 22:31:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1eab087f-e677-4307-a2bf-7b45ad80a182','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.169.44','8BAA157606620E3DD11EBEABB6528BF2','2020-02-10 16:54:54','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1ef9e9ff-55a2-42a2-bdf9-7f9884d26a81','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4A5652CAE4826B5F1AA8ED54E620F90F','2019-12-31 22:27:51','登陆',1,'子系统一','/loginSSO','yutu_web','980470cb-74ab-4add-85cf-12b8897c9dd5',NULL),
('1efa32b2-aad7-497a-a5bc-e82c6c97cb83','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8E4AB31EB8B401B959714EB5B4313154','2019-12-29 22:18:01','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1f3f74a5-038b-4e56-971e-5101e08c1e11','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','698DFB64E49C89A9E9BFB48A43E8DAA7','2020-01-13 09:27:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1f4a5283-1bfe-4ab9-981b-fe904a1e7eae','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3A1AC34680A9194E0F909A11AAACC5DD','2019-12-29 14:29:25','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1f629df1-a066-4a53-b384-90edff15b43d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','162DEB7F7D72CA3DED5BD67513ABBA08','2020-01-01 18:17:49','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1f8673a0-7860-45df-a305-e55b36b069da','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','01ADCAFB124899DCABD203BF29B4678F','2019-12-29 17:11:01','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1fc8cbce-6ff9-4983-a842-13ce948e6ea6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FB6EDD271CD9535D7DB8E1861434C201','2019-12-29 14:39:16','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('1fce8485-993f-4377-9492-6da176c60b17','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DCDFD978F268374F3E775392D6740A20','2019-12-29 14:56:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('217f08ca-29e8-4ed0-87fe-96fd3d6a877f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F69A8675A73F95C58B28E6CC32A29218','2019-12-22 17:54:16','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2223cb15-2bfb-48ea-9132-a214cf3d0b35','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8F645A0381C8971B7A4959FEA9C60999','2020-01-01 18:14:19','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2411d463-4739-44f6-b4a6-338ac24367d1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F4873D10CBFB22326644AE68165CAEF7','2019-12-22 10:30:49','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('243684da-0387-48ba-918a-b03e999e4ef6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7820731541AFB5B40E5BBA3A99CCF46E','2019-12-29 22:08:50','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('24a6de04-5953-44f0-a05c-7296ac9be6f3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DF4E8F7BF46CA938A416636FB413010C','2019-12-22 13:55:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('24eac19c-0a3c-4922-8599-7f49365571c4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EAED2B6314AA60DDE6BC2A46B5A0741C','2019-12-29 14:24:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('25572e6f-a802-441a-b35b-41136d13dd09','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EF0CA883405BFD606E1FB4B471D8B931','2020-01-12 14:49:59','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('25a0ef3f-ceec-4802-9562-82893f7d0338','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','07D08D55E3E84FAB78FAAC1D80F70229','2020-11-11 09:16:29','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('25ac7b8b-771b-4ec6-be80-9eecfe408e1d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6FB1652E6DB1CFEBD8FA2ED542FACE2E','2019-12-20 23:03:26','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('25fe0a31-3c04-4aea-aed9-7e479e95d967','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A77D4D7250ECED7C12652025CA75D977','2020-01-01 11:32:27','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('26abc9f0-74ac-4e3f-ab55-2b19d2495897','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C42210B1E8808BA6F1BF251F2ECF65C0','2019-12-29 22:28:27','登陆',1,'子系统一','/loginSSO','yutu_web','8510f4a6-ab59-4b41-aa24-efa784121bd7',NULL),
('277e9924-be3f-483e-a089-01d5f47e5c8e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:25:26','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('28ca53be-1119-4d5d-b3e7-326743ea7031','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9AA19DB146E4AE420469AD2919CB2DAC','2020-01-13 09:38:32','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('291f543f-52cc-427b-b25a-f2018c3d2b62','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E663CACD643E4BC58B2A68FFEE396485','2019-12-28 22:11:51','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('29ba73ab-5257-472a-8789-04160b375419','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C5EC2FA80A7187E48C4A0A4ECBDE6720','2019-12-29 16:18:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2a120a2b-7996-425c-bd8f-752a231a4235','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.169.44','DE1519B271AB6C342C5DC4AEA70F2A07','2020-02-10 16:48:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2a8d91de-0edb-4686-b213-1fe09c45332d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9AA19DB146E4AE420469AD2919CB2DAC','2020-01-13 09:30:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2b2176ae-9f2f-43d3-8e1c-90ff5f2cf544','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1D627322B299C68FC378D8B80EB880D9','2020-11-11 15:54:24','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('2bd55264-59c0-4b6c-9a25-11dcad8d8d14','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EE6CA3B3C7BABCF8BCD0E87E54FA5FF6','2019-12-26 23:11:45','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2c00f69e-8a6e-4a1d-bd9a-717e148fa5ab','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C463ECE073DB8BBEDFC6BC7F83AC2C43','2019-12-29 22:00:15','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2ccde994-9f9f-4d15-b9d8-9445119fded4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4A1ECB63E7F2B42AE716DA24B6FAE132','2020-01-01 12:11:19','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2d0302d7-716c-4143-8361-b0a534296d03','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','17C5A5B75ACD2CF6041D87B017771282','2019-12-22 14:44:54','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2d1b9ffb-a161-4c9b-9a34-82fc0990272e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','751D363F7AAF098BB4C236E37F9F37D6','2020-01-07 22:41:43','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2da1ba74-452b-4b63-8cdf-a2376a692e7d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','C3304D17ED9E78AEEB1C1D40D147061A','2020-02-19 10:34:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2da41d20-f986-4494-ba6d-65cbba8f2da9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A25A62A309E4D52108CFF4CE7CA73DEB','2019-12-18 22:40:49','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('2dcc107f-938a-4cde-9bad-f2aba0a83d09','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9DE6BC5D21A5849EA8877E9C7C04DFFE','2019-12-20 22:50:43','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2e528acb-2dbb-490f-907e-207e8458edff','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2CECE49F7A29216FEE3246B0F509C628','2020-01-01 11:17:06','登陆',1,'子系统一','/loginSSO','yutu_web','db68b294-acba-4819-81b9-1157e9eabb8b',NULL),
('2ed1484e-dd3d-496f-b88f-d363ade64791','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1966A1C2FC48CF75E6EB6E404DB60FCE','2019-12-26 22:24:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2f2ddca2-7415-4382-9d0e-1f759f960055','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AAD5952221EC05EEC3ADEEA940D3AFB8','2020-01-01 11:26:36','登陆',1,'子系统一','/loginSSO','yutu_web','dcd079c9-ac21-4299-bb91-1c9f2639d95e',NULL),
('2f3b0560-3af4-44f0-8619-2fefa62a8750','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AB447DD98784521A23ED57D30D46D675','2020-01-13 09:53:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('2f524f53-ddd6-4983-ba6f-feea7c534306','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EEF5E6E05F3B7E9E199CC3D977801E47','2020-11-11 10:01:33','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('2f7ad5b0-257c-4715-90a9-45473aa26972','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8BAFC9139EEFBD4E035ABC71D6A2AED7','2020-01-07 22:13:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('311a8b43-efc6-4c28-9558-e342d68cbc59','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','25E67E1EA9E3A5D16BEDA7F8AFC9F572','2019-12-22 11:02:55','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('32046cda-7e0d-4bd0-8226-0a405341bd18','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8359103186EB65666CC0D3059CC5E872','2020-01-07 22:27:01','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('32822008-9bc7-4c70-a977-4795345c480d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C7414B3BA36E4F84894CE113A9D43F0F','2020-01-01 13:47:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('32b65bd4-3a30-4b4e-ac9b-f9ad8fc4e9f1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D244D2E642A201B8C0DC76C2AA25ED38','2019-12-29 10:28:53','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('333954c0-618a-4350-bbec-f2319355f818','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','65F25E10A841E1E2C314958F10CDBE34','2020-01-01 11:24:50','登陆',1,'子系统一','/loginSSO','yutu_web','90839012-de65-452a-9598-2d1d82c02071',NULL),
('33ee67f4-2e64-484e-bcc0-56d93b5a0687','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','43604BA5CF19635FE853CF9AFEBEE1B3','2020-02-09 10:23:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('34699c61-8204-42ef-b680-0fc19d79c275','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0FE498EC2D4410B3E8BEFEADD9B1C4E7','2019-12-22 10:47:44','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('34792852-a384-49a1-aabe-28149e53ce0a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DFF494C52688FD3FD3F61A8B84661D76','2020-01-12 15:05:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('34ace2dd-2e28-4912-97ef-95d20bf2e5e9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6AD498422C2D6AD4C463D728195F8848','2020-11-11 10:04:20','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('34d059dd-db06-4e86-9d11-c620f43c9666','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','73D554927AFFEE3FCC9AD66165D8E76B','2020-01-13 10:00:04','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('356e69ba-3d80-4b66-a415-eceb4ad46976','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A5875BF04A2D33FE2E7D6894C7D1CAAB','2020-01-07 22:31:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('36961b5d-780f-4ee2-b501-5dce97a27bc6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EDF305609ECB843306F5B177DF40FD76','2020-01-01 11:41:15','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('399291ee-7b83-4b32-a5ba-afbe83528a64','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','334D3B695A2CD92E9793657EC01D8559','2019-12-22 09:14:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3a1c4fc5-066d-4823-9df3-bd2bdbe25799','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C71B188514CCD08484D35F288668533E','2020-01-13 17:38:49','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('3b10bf9f-bcf8-4fe1-8eba-6124572598f2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','48192AE46425160B9FAAC4F1905F56D9','2020-11-11 10:54:06','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('3b9a4d7d-c3fe-4841-9a5d-862bedbf433b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9B6BF315D1308AFF57E13B1E9B36E308','2020-01-01 12:11:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3c156401-df88-4da7-942c-eb9b5cea03af','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EE42B3BAA59BC23689175C9E9BE3AA8C','2019-12-29 16:18:50','登陆',1,'子系统一','/loginSSO','yutu_web','ca7cf2b2-7529-4d57-9877-74b72072b5b3',NULL),
('3c324763-8a43-4900-b6f8-18224814a4e3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B55BEC51BA354D7FB77493AE21E8DC59','2019-12-22 11:07:22','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3c68252e-8de2-41c8-9d5c-88118c762ce4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2CECE49F7A29216FEE3246B0F509C628','2020-01-01 11:17:25','登陆',1,'子系统一','/loginSSO','yutu_web','db68b294-acba-4819-81b9-1157e9eabb8b',NULL),
('3c7eda59-c5cc-4b55-accf-2e033b15e9c3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.174','7B52888996775017306E7D8C2B6B71B4','2020-01-13 11:31:27','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('3cace722-95c7-472a-a576-6342bb939367','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','03614618B06A6DA4A87DB2F99896A920','2019-12-20 22:55:01','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3cbf42fc-0828-463a-abe6-5b61a1311b95','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','09804FDA98F65BE17A87BF8982950339','2020-01-01 18:27:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3d45cc05-5ab4-40c2-a040-e08468263562','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','724DF41DED27BAAAF98EA71E36321D31','2019-12-20 22:54:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3d7457fc-4ae8-4380-8bb7-a0c21a5cc5ac','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','48192AE46425160B9FAAC4F1905F56D9','2020-11-11 10:53:44','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('3db4f80d-6286-4d95-9fae-d1237c13897e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','50193F645E519563D16D68F280506DA4','2020-11-11 10:36:47','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('3debdf41-ff58-48b1-9aad-3d908b69323e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','34B8C73A1BC8A34F2D94EEFE1665D84C','2020-01-12 16:33:15','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('3e666574-18cf-4eb6-ab46-232a1e86d414','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B1B328851627D96A69A79B40AE81B3FC','2019-12-29 23:04:41','登陆',1,'子系统一','/loginSSO','yutu_web','4b46a369-e9cf-4d54-b300-66bf9b5f7a42',NULL),
('3f67bb07-ee5c-40c7-8b6a-5b6a6029b9f6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','982F9CF4BA92664B70264235B971AB06','2019-12-29 12:06:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4149f80b-9eba-4b79-8803-21b2b6ea2c22','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DE6258FA7EE22986C080EBB0AEC8E654','2020-01-07 22:30:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('422b2b80-3217-4c50-9efc-c4e90352077c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B4F92FA3009E9CBBDA69F78AB57F91F6','2019-12-29 21:59:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('434a9389-0a5c-4081-b6b0-c196e3c53708','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','66C5792E490504815D80E223490869E1','2019-12-29 22:14:32','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('44b73460-8d00-4313-a7f7-fdee5dd8ba45','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DDB075793F4596952366B5751564C70A','2019-12-29 22:42:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4526724f-9518-4f10-9849-4e9866cdde12','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','25794910F8B11235391590060991D736','2019-12-28 22:29:50','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('45b64feb-6bc3-4b2c-8789-e2afb567873c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A521DFB7B10540485D6D05EA471B785B','2019-12-22 17:53:36','子系统一登陆',1,'子系统一','/login/getLoginVerification',NULL,NULL,NULL),
('48abd6c7-9b54-4055-a442-c39bdb0d80af','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','88247EA473F0803C69AEA9568984B541','2020-01-13 09:46:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('49286ea2-4e41-48c6-99f5-8ab6d9256620','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','53233202C3887F3F476D3A57F269CB0A','2019-12-20 22:41:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('492a7f28-8090-4830-8253-147c996fcc64','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C47B837AF03A4F70554E3D02EF237884','2020-01-07 21:59:52','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4a21c77f-79ac-480d-894b-bab98ddb6723','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AC86D7FA081A7729FA17EED802AC413E','2019-12-29 14:50:49','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4ae105a6-a175-4633-9b62-69b791700635','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2D27D12B4C4F96C57971EC8E41843D16','2019-12-29 16:41:06','登陆',1,'子系统一','/loginSSO','yutu_web','1a1020c8-cc5d-4fb9-bc97-fff9c6f9d6cd',NULL),
('4b0d4d95-079e-40d4-8b5d-d86e7edf6809','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FD85801C596045C9126B33741DCBB1E2','2020-04-28 11:58:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4b25e6d8-d041-4c79-8252-163e7141ce2e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6C1F160833217E5BEEFA2E1C9B8345B0','2020-11-11 11:07:00','登陆',1,'子系统一','/loginSSO','yutu_web','cloud-zbcdb4504b6-c9a9-4940-b971-4ca8fc5f6684',NULL),
('4bff9ebe-186a-48ba-b8b1-982f189b369e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1153B8ED2AD223CD30D9E4952A4570E8','2020-01-13 10:00:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4c9187d0-7006-4ba9-bea3-e2195c2dce1f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1D322A4382FEBC9B09D8D5F8D4B6EFB5','2019-12-15 18:05:17','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('4cabd094-1a84-42ff-a19b-b6bab1793f9b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D95C811A1B6CBE0019DF1CFC2FF9CE53','2019-12-29 16:20:50','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4e0d4d33-bc27-4351-a9dc-33265472a693','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FE3997F63B90D28D01B4D926BC38684D','2019-12-29 22:46:30','登陆',1,'子系统一','/loginSSO','yutu_web','1370d507-593d-44d1-8a19-a64b0ba5150d',NULL),
('4f3f2506-ed91-46a6-889c-d39d2e54daaa','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','59ACBA0031CDA27202290A4ED6A85F10','2020-01-12 15:41:45','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('4fae171c-3984-4f3f-ab71-b2848b9c32d0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CD0C3851B72BB92BA6F91D9ADBDDDEA6','2019-12-29 15:47:11','注销',1,'子系统一','/login/logout','yutu_web','6a0a24f0-a610-419f-861d-a075c31be0d5','org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 192.168.4.20:16379'),
('4ff04269-ab41-455d-ab26-ae6860f144a1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','331ABE92DBACFC97B30AAD989AD797E3','2020-01-01 13:28:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5004df63-5709-4c2a-8697-f0f1e2cd0384','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5784B66F8DA28FDB0D1DDD5CEFCB7ABD','2020-01-12 15:26:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('50e89383-a403-4f46-8d36-1b2b261af619','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1E007D34ABFA92224FBDEA0A429868A2','2020-01-01 13:42:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('50ef3700-ba48-4c8a-b74e-509d141ca2d3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','52F74336A4A9D9BDB7BB32C3398DA099','2020-01-12 15:10:15','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('512111ea-c367-4a04-a901-b7b1aa1a1c21','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0D0675AF702C007F69DD2BEBDD1A2E69','2019-12-29 11:20:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('51645a9d-a09f-4b33-bd28-14fd9904e618','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AA52FFA895C262E13F9CD9830AFDC26F','2019-12-15 15:24:17','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('51db89a6-b71f-4af8-95c6-6e74efd7971d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6C1F160833217E5BEEFA2E1C9B8345B0','2020-11-11 11:07:33','登陆',1,'子系统一','/loginSSO','yutu_web','cloud-zbcdb4504b6-c9a9-4940-b971-4ca8fc5f6684',NULL),
('5235ad4c-d195-4fc3-8aa5-dbf1a3e738e6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0385FF5089B797E8C005EAB9533542BC','2019-12-28 23:22:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('524d6b2f-251c-43f2-b2e1-a0f887d26a11','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4448AF1B483078FF3CC17DBEC48EB660','2020-01-01 11:29:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('52d4816b-f3c2-4688-8fb1-94385b1880d4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5255A2865CC15D60440FB795F1278597','2020-01-01 11:58:19','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('5390b3cd-13d6-4d84-9c4f-16b498348765','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CD0C3851B72BB92BA6F91D9ADBDDDEA6','2019-12-29 15:46:13','注销',1,'子系统一','/login/logout','yutu_web','6a0a24f0-a610-419f-861d-a075c31be0d5','org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 192.168.4.20:16379'),
('53ba6dc5-fcba-4614-999f-bbe99af27967','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A5AD19B3165767C4DB8B16B94E5D1714','2020-11-11 15:57:13','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('556c2314-d00d-4c74-891e-d8be6d775244','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FD85801C596045C9126B33741DCBB1E2','2020-04-28 11:58:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('56cdca14-2fc4-4123-9b1c-981d800d437e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3E7C5E06E2BBDF9D343C770386D9D9E1','2020-01-13 17:38:55','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('56ebda0c-db8b-445e-9d18-20e9c918dc0b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','674FECA8BE8F121D7073D94CB37F1553','2019-12-29 14:32:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('57d0b75c-74ff-4b93-a27b-82772b3a18af','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','698DFB64E49C89A9E9BFB48A43E8DAA7','2020-01-13 09:27:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('582b33e0-d632-4ce2-a167-18ee1bdcec12','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','978599A2A08276D6513DD816EAA5FA31','2020-01-01 13:15:44','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('58ca988f-ae23-4571-9e4c-32b3ca8cdb7f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','331ABE92DBACFC97B30AAD989AD797E3','2020-01-01 13:29:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('58f28bab-78eb-456e-9c30-ab51bf2fbcb7','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2AF14C8CC1773512FC231057A8F06A3A','2019-12-29 16:44:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('59486de5-9ea9-4007-aa5e-5f148d62d530','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.24','EA5E73A24781ED6A7529222D5EAF76FA','2020-02-23 20:20:06','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('59b8747b-0874-467e-a19a-08c32407a1a8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7A93CB3DDA72BCF121CF747F2CF44175','2020-01-07 22:40:53','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5a4e6c20-7c65-4b80-bcee-a83046f67c86','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3E65148B03DD813872E2988D27E773CD','2019-12-29 16:51:59','登陆',1,'子系统一','/loginSSO','yutu_web','b18ee530-e6db-4c1f-8fcb-5fbf75cfb4e8',NULL),
('5ade2927-ed0a-4e66-b16e-eb51fc25cb7e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','48610B0F098E5A374CC32DCA6D0139B9','2020-01-01 18:13:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5afd9a90-5bd2-451e-9b3c-f354f1618270','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DDB12C969D7D9AE5E04894F7AA1F02BB','2020-11-11 10:33:55','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('5bb6b425-b9fc-4633-ab4d-0ba9e159052d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','01C9F73EF1DDF2744302837838096714','2020-11-11 10:49:17','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('5bf09396-5637-4830-a1b8-0dec00a85812','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','59ACBA0031CDA27202290A4ED6A85F10','2020-01-12 15:42:13','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5c3b4051-8cc5-43a1-9876-f5a25f37a1cb',NULL,'admin','127.0.0.1',NULL,'2020-01-07 21:39:12','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5c84dae8-9ee8-4d28-904a-23d354dbeb26','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A4399C38A341295B70C523BB0EC4ED06','2019-12-18 22:39:24','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('5e25cd1d-aab2-4f24-8df5-05be36d2a22d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','441AEF4D9810838895D266A100B9CC19','2020-01-12 15:35:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5e8d55ab-a7e4-49db-af0e-f103c589a8b9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6C44D4D8A2E09AD4E63C2C1367EE94D6','2019-12-29 14:43:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('5ec61612-2a27-4689-ab6f-03bfa9958603','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','881D713B7EFC97788129D201A06564A8','2019-12-29 21:57:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('60084dea-8e14-4d38-9986-49353fcb3f43','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C47B837AF03A4F70554E3D02EF237884','2020-01-07 21:59:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6017fca0-808e-430c-b8e4-3dd3cd89ded8',NULL,NULL,'0:0:0:0:0:0:0:1',NULL,'2019-12-20 22:38:11','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('60767b10-ce20-4f2a-bb92-4cf6a06c0ddc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','767D6DD61F17301E8A56D02A8E4C4256','2019-12-29 22:08:52','登陆',1,'子系统一','/loginSSO','yutu_web','0e185221-74f2-4262-91cc-0ccbbd519323',NULL),
('60873eff-bec7-42ed-bf22-330bb8352c96','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C7F778B091F99D2D24508B55DE3A5D8D','2019-12-29 22:12:07','登陆',1,'子系统一','/loginSSO','yutu_web','8f8ccc24-7545-4ee2-a603-b38d66a56387',NULL),
('615d029c-0d3a-4b46-835a-55a8802b897e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C9906D4F35B40A913A92D5A862D8B301','2020-11-10 20:27:15','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('617174c7-605e-4a70-88b1-aa916ab405b3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0A07FCF851C432DFA15286B62C524F96','2020-01-13 10:02:20','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('61b87b5d-a1f6-4751-9573-a02e9e797c23','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','04EFC6B9259CD9C9B2FF6698C6727BF8','2019-12-29 22:12:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('622a9336-c116-483b-821c-1cc6fb25d3f2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AD2B33705B119C4732125D4B9A229A1B','2019-12-22 16:13:18','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,'org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 192.168.4.20:16379'),
('62b173b7-34e7-41b9-8070-5857954f00b5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9163D77735D471A080C3BA6B6470A0B4','2020-11-11 10:58:13','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('6377e13b-799f-46b3-bcc1-59c48d1d476d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.177','4EE550821C0EFBF7261C35A431E370CF','2020-01-18 08:36:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('63cc5618-fbf5-43a1-afaf-40da035e925d',NULL,NULL,'0:0:0:0:0:0:0:1',NULL,'2019-12-20 22:37:26','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('64af5f47-ca50-4da1-82f6-c7c128be1f12','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FF8D1AAE104CA55B7218295D8B8B4863','2020-11-11 09:19:46','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('64ecf3d6-ba47-43f1-b339-d8aa94dc3883','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B59432883720F386852FB54A2C3BB337','2020-01-01 11:16:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('655ea341-57a8-4f67-80d0-bba5ed2f292a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:27:12','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('65ba99a6-4d82-451e-a3d6-778889d39e38','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8A57ABD5CAFE1EB4C6D9723E8E7273A5','2019-12-18 22:18:37','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('662bc2f0-be96-4798-ad4f-e4a25c70b290','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3D95F9933C0B4905DEB8FAA70767B0FB','2019-12-22 17:54:43','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('665c494f-1a85-4e02-a46b-12179fad990b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.177','9E526F632661C3852A7A14D60DD2300D','2020-01-18 08:35:04','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('67bdb7b3-59ba-4436-840c-9fcba587c4a2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EDF305609ECB843306F5B177DF40FD76','2020-01-01 11:44:36','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('684303d5-666d-4842-bb7d-a1c6c0e3708b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','235229E507DBCB2F3E366D73369B30D5','2019-12-29 22:42:09','登陆',1,'子系统一','/loginSSO','yutu_web','005fb91d-ab25-43bc-bad5-a23fab5f97cb',NULL),
('68611acc-97a4-4a7e-ad39-c18f58620902','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6208749199E835C451F9F146AC135A7C','2019-12-29 22:12:47','登陆',1,'子系统一','/loginSSO','yutu_web','6b0b99fa-0b9d-410f-87c8-b94cd7ba7852',NULL),
('6916d72d-bc59-4095-bd63-f1a97d6a5939','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A891172764096F09BE8D4626CF76296A','2019-12-15 19:22:29','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('6986fa9b-771a-4aef-a3fd-93507c041f21','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','245B78CFEDA266A92E0684AFCAE81EE6','2019-12-22 14:26:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6a5be8de-41de-42a4-a25f-34015b7fdc1e',NULL,'admin','127.0.0.1',NULL,'2020-01-07 21:42:56','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6a9b77c7-d0c1-430c-9eac-d2ea178b9fd1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','26B68FDB3F6C993CDC3145B827EF414B','2020-01-01 11:26:50','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('6aabd98e-7dd8-485f-be44-9dc5705ebab5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','126939590E8FBFE1B44BB35329CFB4B3','2019-12-29 22:09:38','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6b84f3b7-68d7-446e-b472-77c4dd762356','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','83EA3A0C03946A6D48107FA8AA9B0996','2020-11-11 09:47:15','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('6b99ebfd-a24b-48d7-bc56-9804c7d58020','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C47B837AF03A4F70554E3D02EF237884','2020-01-07 22:00:14','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6baa8581-5e98-438a-ad74-fa0602d59636',NULL,'admin','0:0:0:0:0:0:0:1',NULL,'2020-01-12 21:23:46','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6bbe5ebc-b0c2-4f25-88a8-f8d311d17ad6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','48610B0F098E5A374CC32DCA6D0139B9','2020-01-01 18:13:13','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6bd1d597-e689-4701-ba49-1d6f8d83a8fd','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CF934622C4A136A646C8C2F50D2D1B6F','2020-01-12 16:21:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6c0f4d1b-27de-45e7-b1b7-905fab2794f8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9B6BF315D1308AFF57E13B1E9B36E308','2020-01-01 12:11:13','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6c4f4913-dc0d-49b9-b1a7-8d03d85f4ad0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A473D646B54646E3F090FC7A7219FBA9','2019-12-29 22:12:22','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6c51d7ba-484b-48e1-ba31-b7f3006797aa','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','36D5781F49EE77556E21150844C211CD','2020-11-11 09:55:59','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('6cc4c967-7e89-48e2-a364-9b468dabc06c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5255A2865CC15D60440FB795F1278597','2020-01-01 11:58:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('6d406faf-3694-4756-8d64-6e3fcbea20d3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7DDFCC8D1DD2F6A7FA9C9800A5641C76','2019-12-29 22:43:19','登陆',1,'子系统一','/loginSSO','yutu_web','090b7a8d-b4fd-46fa-8bf0-eb81033c6f11',NULL),
('6da58c9d-5191-4b95-82dc-fcc858831a9f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E48C23A27A2E8A711F65A38D4A82691E','2019-12-29 16:50:02','登陆',1,'子系统一','/loginSSO','yutu_web','0b5463ab-e1ce-4d15-a984-8d5ab41ecd57',NULL),
('6f284889-70f4-4f5d-81b2-98fa5d1be20d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2AE3714E866714426ECBED7BB5789D86','2019-12-18 22:21:52','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('7056ad70-5efa-4fbf-bb7b-1d542fa5e7de','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1338AC2BCA6AD401F3AA11B358BFF263','2019-12-29 14:19:14','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('70f326ec-c2a9-4669-8854-e9fe76a43b12','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1153B8ED2AD223CD30D9E4952A4570E8','2020-01-13 10:02:07','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('70fe416f-07a8-48ba-a890-59c74f070c5b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','994A1AE2F9E5D74BC4D91C881F3FE507','2019-12-18 22:16:22','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('716641bb-3cb1-4e3b-8170-346c39384fed','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F2A3F46DB1490D61B27620E3974B4466','2020-01-01 18:29:45','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('71774aab-3d39-4076-8f0e-8e213252e05e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C588D32978C1F4EC28A1BAF03ECABD97','2019-12-28 21:49:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('720d2a5b-e79f-487a-be37-e827a3efa4f5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','21DC883FD84F83EDE7F7EB7C326E1485','2020-01-01 11:19:02','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('721e8dda-fbb0-4ccc-9423-bc6991d87ccf','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','73D554927AFFEE3FCC9AD66165D8E76B','2020-01-13 10:00:00','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('723ce423-16da-4a5e-a57d-9856e6176532','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D686566C25235CA0079AB3E31D73F31C','2019-12-31 21:53:57','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('7294b4ef-f568-4507-ab65-9d352782632b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','01C9F73EF1DDF2744302837838096714','2020-11-11 10:50:33','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('72c7fadc-855b-4c35-8045-1b1cf31e6170','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DC70D303091A6DCF868BA233E7AF0459','2019-12-29 15:44:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('738dd808-9f52-4ae5-a471-34a4dcad7b9d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4B383337815FFEDB3B838FCFED86D005','2020-11-11 11:01:52','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('73aae558-32a1-4190-81a2-a52c5569fd89','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D686566C25235CA0079AB3E31D73F31C','2019-12-31 22:01:11','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('73b7c5ef-8129-43e7-8612-98f8068521aa','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0D5247FCC5AB2DE20E9BA515493CB3E5','2019-12-29 16:51:01','登陆',1,'子系统一','/loginSSO','yutu_web','4e5fa791-e0cd-452c-876f-155a084ce0cb',NULL),
('743771fb-e988-4a58-be11-ff5e8ca4ebe5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','579FE368EBC5FD6AF29736D3410B4F91','2020-01-01 10:37:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('74c3c0b8-852d-4128-a9ec-c51fb9d5cee5',NULL,NULL,'0:0:0:0:0:0:0:1',NULL,'2019-12-20 22:40:25','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('74fc8f27-0d48-4bca-a7e4-80e8f7f89dd9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C893ABD7103D28D21F596D39A96789E2','2020-01-12 15:28:01','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('764c542d-20d4-4c49-afea-fc2350dc0ae2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','10BB6039A22A9AA550F9C15A3B9BBC4F','2020-02-18 17:05:55','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('76577247-b371-4c6f-9278-a9aeb5294fa8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F1CA404A9841CF8A5D7351E358999C76','2020-01-01 11:37:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('773ee7a7-1f8f-4caf-82b6-7c297deef0a8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F12CEB47873CE89AAAE54F6CCF5CA46A','2019-12-20 22:55:24','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('77529200-2223-47e7-8eef-cb67e38496c8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AEC9F46BA9EC76B5D4E4A7A61B8991FC','2019-12-20 22:43:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('77837cbf-8300-441b-8f71-e6921bad7457','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','52582A70835E96ECD4C21298C5264859','2020-01-12 15:50:54','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('7867b4b1-3d2a-432b-b18c-32580d48f29c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3B9B17EA48231B4AF503909729272454','2020-01-01 13:41:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('79266437-1d05-4e72-8d4c-ca4f06d723b0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A48364E46FA2DC4ED5D98350D0DA0FAC','2020-11-11 11:06:36','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('795b94d6-1a7b-48e5-82ec-0e026e81b0fd','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1FB725BCD883B3E89BF495214A1953DC','2020-01-07 22:20:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('79f94eee-87f7-43f3-81e2-a8cb5a7c033f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5AB0F8E3DDAADBE9546FD20BDD250B95','2020-11-11 11:59:47','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('7a4dd4b9-096e-4e85-aba8-4d3889a315cf','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','96A8C82C2485E58C1F2C17170ACFD8A4','2020-11-11 10:55:38','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('7a8174bf-87c2-489e-89f6-e187e5ffcca0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3CC6667610A5CB228BC6150BC6B4B7A8','2019-12-31 22:05:20','登陆',1,'子系统一','/loginSSO','yutu_web','17a6df9d-997e-49ea-b7ba-acebb47aedb2',NULL),
('7a943e09-c17d-46ec-b2a5-a1930b854773','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E935092DCF674004778B3AA9B3A9549F','2019-12-20 22:51:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7b3eecbf-5791-4b59-b975-0e1798d3beb4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3714EFBFE569DD611C6AD350A1E5BFE0','2019-12-29 16:45:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7bfad593-6d2a-4815-bd34-9c36ed041ee4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','2A10AFEBF6BD633F77480F11A979717E','2020-01-13 11:58:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7c1f8db4-a852-4db3-8e70-c1a9d4ac5a7b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2AE644F21753E7F81878DB2A1FF474D4','2020-11-11 10:58:20','登陆',1,'子系统一','/loginSSO','yutu_web','Cloud-ZBCf554c0d6-4646-46dd-9e6e-e2b70a6b1add',NULL),
('7c51a897-ff30-4546-a32e-9580c8e8d383','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4448AF1B483078FF3CC17DBEC48EB660','2020-01-01 11:29:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7c6fdea3-f475-49f9-8bde-cf0aaf6c4646','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F4995D31876B845B6CE80973E6757808','2020-11-11 10:02:18','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('7d04fdd1-0ada-47c8-bb00-5fc367890efc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','18240BA836CC3028431B0DCC46E56341','2020-11-11 15:58:23','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('7d054baa-e1e4-4f3b-995d-3a91738335b8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D686566C25235CA0079AB3E31D73F31C','2019-12-31 21:55:52','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('7d660f1a-a5d2-434d-9928-0e714804570a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6B7C6151C7E404E8F69FE89339894F2B','2019-12-29 14:35:03','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7dbf51ee-6bf9-4e7f-bbac-ee8cb4eee5ba','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1EBE019C84812D6DC6B2899589D1AD89','2019-12-22 14:48:38','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7dc4a19f-cf02-45e4-90ff-d17215c78062','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FD85801C596045C9126B33741DCBB1E2','2020-04-28 11:58:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7efc6c4f-52e8-4ca3-ba15-d3a661b7e028','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','BCD33D93997740E65B514CEEBB215270','2020-01-12 16:28:55','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('7f234bb6-245d-4081-a745-7130952cd12b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','96A8C82C2485E58C1F2C17170ACFD8A4','2020-11-11 10:55:38','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('7f39d7cb-e735-47ab-8d40-5ef8faa62689','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D6D6FE92D588FE06732DC0E8D55EC4C7','2019-12-28 21:40:46','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('801e1ee0-7b0a-4950-bd73-679a9c446e33','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','71AFC29AD089E300DC7F253C18A2BFB3','2019-12-15 21:01:07','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('8109447f-62ef-4846-8a3a-2a1d5a60206e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0F2411AE30AB4EDF547B34A3759251EF','2020-01-01 12:18:49','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('811dfed3-5b3c-4510-8b8a-10018b0f6cf8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','05529A3961A41DFF841333C5D62DB36C','2020-01-07 22:45:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('813936e6-dd2c-4a7f-bf9c-24f8ebb0390b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9744312499DD33366DB6883756177E82','2020-01-07 22:34:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('81acd8b7-7f04-4b30-9442-993412b2f963','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DF099790DE5545379B21454B55BF0F8C','2020-01-12 21:21:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('81ba67b2-00a1-4f39-a458-fe82ae82bce0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EFDA476E2B57EFA0E7A6B6B421B12A96','2020-01-12 15:29:56','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('81cf3b76-3858-4729-9fa5-a028e7c199f8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5CABA59BA4348DD9585E52194434D4D0','2020-01-12 15:20:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('8213f49e-4ccd-4cdd-8d32-61c894669d30','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','732BEA0C0CF47A88462990FFF14C9AFB','2020-01-01 10:31:07','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,'org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 192.168.4.20:16379'),
('8256d04a-0c54-4e1f-aed4-8b12bc98c569','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FD85801C596045C9126B33741DCBB1E2','2020-04-28 11:58:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('834b1437-6663-4269-8536-c5c49fd976bf','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7F7A461635630A1EDCE7E05E641C8785','2019-12-29 16:16:34','登陆',1,'子系统一','/loginSSO','yutu_web','c1f1a343-54d6-4ac1-ad51-7d7ece9a8922',NULL),
('84f577c6-b736-47be-bc2c-5a52af02739c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A5660D020A8824C1930DAE08C2DB1B41','2019-12-29 21:59:42','登陆',1,'子系统一','/loginSSO','yutu_web','aa4b2b8c-8239-4fe0-a3bb-44bf7d3bd359',NULL),
('8620171d-0d0c-4d53-bd00-16c37defe0c8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','853A4F5EB9455A0DA9FFC7025957C5CA','2019-12-31 22:27:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('86960efb-2665-4702-80ca-68c6c725b70c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6C1F160833217E5BEEFA2E1C9B8345B0','2020-11-11 11:06:53','登陆',1,'子系统一','/loginSSO','yutu_web','cloud-zbcdb4504b6-c9a9-4940-b971-4ca8fc5f6684',NULL),
('88cd4e20-09d6-4ec1-829a-12afdffed6c0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:28:05','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('897e344b-8a85-4229-be45-3c325596269e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E663CACD643E4BC58B2A68FFEE396485','2019-12-28 22:11:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('898ebd41-8b89-47c1-bce6-fb8614112a68','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1563F66D7DC62460021E43EC4A4CD290','2019-12-28 21:51:38','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('8afa1b2b-6f01-4083-821a-ce57e58c389e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C42210B1E8808BA6F1BF251F2ECF65C0','2019-12-29 22:23:52','登陆',1,'子系统一','/loginSSO','yutu_web','6f5f2482-c581-4bef-8645-1e719cd5e1a0',NULL),
('8b76186c-a4a6-40c4-861b-a25835eb5587','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','BD2F42AA1FD8A5A7A9184DCA594C0CDC','2019-12-29 10:22:20','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('8c1d5186-a2a8-403e-9e67-69ababc8da62','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DECF24088A8FE2027F8DB39FA96D7C36','2020-01-01 18:15:36','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('8c8ca739-1a9c-45ef-aa20-6535e1877651','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A031639B4B195C3A852317D6753A981E','2019-12-22 16:18:18','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('8cbfb759-9344-4015-8a54-c3ea88076eba','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','482A59AC6390F2F7422E0822C73ACEC2','2019-12-15 19:21:03','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('8d4faaff-967e-4051-9c3d-87dc71959f5f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F6537FB3047E43857C705F918AFAB8BE','2019-12-31 22:03:57','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('8d778560-b7bc-4569-954a-7bf8c8ae8fd4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','23135CF872E7ED1346D1DE137018B770','2020-01-12 16:37:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('8ecfd5b8-b005-43e7-b123-8458d17d5953','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C9906D4F35B40A913A92D5A862D8B301','2020-11-10 20:27:15','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('8f6527c0-b304-410a-8793-970fdaa135e5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F3C00FE8D624DBB8AA7443BF86E4733B','2020-01-01 13:29:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('907c0a5f-19bb-4b5f-863e-d471acc1c6bf','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C4A180F6B593514DD333B7F3313A3A3E','2019-12-29 10:57:54','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('909d7129-aabe-4768-90c8-790cbc59665b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D686566C25235CA0079AB3E31D73F31C','2019-12-31 21:54:05','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('9132d1bf-4096-43b6-9e1d-32d30951387b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6BCB4E05661517EC5B2FB20A6C1F044D','2019-12-29 16:46:17','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('91ac6cc2-66f3-4324-b7e6-253efc6a0ad4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','48AB9037B22B3836A86914C77D8456BE','2019-12-29 15:04:53','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('91ad5742-f0f7-4647-90f8-d3df02d3208e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CE25D29008E43582DDC09F19DDE9134D','2020-01-13 09:57:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9277788a-6c52-4c24-8301-80b16eddc657','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FD85801C596045C9126B33741DCBB1E2','2020-04-28 11:58:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('92df3dbd-577c-4077-80ab-0cd1d267bfd4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','462B007C203B48C9F7BB5EA8C4D30DFE','2020-01-12 21:19:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('92f8464d-f425-4283-8db5-1724a1985385','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DAA2525ED48B3DC0D3B66384E2E29491','2020-01-13 09:25:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9346a482-b231-4dec-a6bd-c352384036eb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:26:53','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('936fea2d-2e5b-4124-bf88-f4e750f9460b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C42210B1E8808BA6F1BF251F2ECF65C0','2019-12-29 22:29:08','登陆',1,'子系统一','/loginSSO','yutu_web','8510f4a6-ab59-4b41-aa24-efa784121bd7',NULL),
('939d6375-4c3e-4f65-9315-d2dc18c60842','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DAA756D300003EAB2B8DFD72EF114B1F','2019-12-29 15:31:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('94628583-0ab2-4195-84fe-9164bdd92c49','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1AFD9D067EA11A2BCC40141D59B6FFBD','2019-12-29 22:28:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('95378955-b25e-4e9b-9ae5-f79ce38f7e38','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','26B68FDB3F6C993CDC3145B827EF414B','2020-01-01 11:26:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('95470131-dfdb-4e66-9041-6e0901e438fd','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9B6BF315D1308AFF57E13B1E9B36E308','2020-01-01 12:01:17','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9563664f-17d0-4639-8f43-e5fe2d64ae9c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EACF25C1DD3BE23FC650BEE0C09F27D2','2020-01-07 22:43:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('95f2cb8e-4f57-4669-ae9d-4c25cb2aa190','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','85308DB013E266F32DA9F18B75AE7331','2019-12-22 16:16:13','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9697df30-0f6e-4cbf-a98b-53ffba96606c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6396CFA6217BA36F2D64C671458FFC6A','2020-01-12 16:06:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('97011fed-511e-46d5-a1bf-04c775a09746','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','41072EA0748F2D860486CF8BB3D3F086','2019-12-29 10:19:16','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('97419d6e-5e23-462c-86a6-75c0b9be3228','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8D1FC694C7E44DD3046E49B68E33ED18','2020-01-13 18:00:22','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('97874a43-e661-4208-a967-6285877cef1d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2A58D6DC92DE6B9039A9CF32D82F8D08','2020-01-12 16:33:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('981d97b7-babb-4304-ac6e-a277b197f3b8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.1.1','3EDAF99E64F8624A00E447C9D21F8545','2020-04-15 15:46:55','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('985cc4f1-673d-48f9-ae22-49e682041bb3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.174','DEC87C6CFB48285721F39A8F193F7959','2020-01-13 11:31:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('98e15587-d652-4b93-887a-7b14a08a4355','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','784DE40EAA738C1E97260DEFE055455E','2019-12-29 16:50:25','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('98ea7ed4-7c21-4616-94de-c5e1880f1a65','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C47B837AF03A4F70554E3D02EF237884','2020-01-07 22:03:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('992c594f-cf54-4ace-9010-b949554c77b7','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1C115CEE0DD68CC1632FBEB9F98CADE9','2020-01-12 15:24:44','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('997da7f6-1006-4940-b261-f717c9b6cac7','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2223E0F55F93DCBA847F86819DE7A040','2019-12-29 15:31:01','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('99908f80-d003-4b7c-ae34-6a282331d4fd','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CD0C3851B72BB92BA6F91D9ADBDDDEA6','2019-12-29 15:45:01','登陆',1,'子系统一','/loginSSO','yutu_web','6a0a24f0-a610-419f-861d-a075c31be0d5',NULL),
('99d167cb-2ff6-4c83-8d5d-6c2e15f45c90','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8359103186EB65666CC0D3059CC5E872','2020-01-07 22:22:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('99ee784c-3746-4abe-ab7e-92be2eb95ecb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C71B188514CCD08484D35F288668533E','2020-01-13 17:25:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9ae0bde9-f36b-4689-850d-dfc28f7be719','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D5EB1A90C004C329DA884DE516AD77B4','2019-12-22 10:50:29','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9b0ffeba-be80-4a08-9f13-68633198138e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.25','FD75A7AA098829F82C8A54C82AE9BA8E','2020-02-06 14:01:27','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9b1a251e-beab-45ba-a7d8-959ddcdca3dd','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4D916CD9F86BE93B388F1FB7CB3CDC61','2019-12-28 22:35:13','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9b8619f9-90dd-4863-b0d9-d6fc7909ff74','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4B8C3FD9048AB7D6074085857363B80D','2019-12-29 16:16:33','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9bd36a60-1cf6-4a69-a26c-1238a7a4c53c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1420CB25D76ABE888617F03E32E544DF','2020-01-07 22:32:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9c9f387c-eadf-4d7f-b42e-922c2a1cc09d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.174','1BBF1CDC10E7CBBA596683556295E398','2020-01-19 16:20:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9cb7c2cd-ba89-4771-89d9-934187b34fed','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.169.44','1FD0627F8382C2B7231EEF8B95C1C8E9','2020-02-06 14:27:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9cd540ee-e68a-468c-8ea9-73b34b6e1138','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1D322A4382FEBC9B09D8D5F8D4B6EFB5','2019-12-15 18:04:58','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('9cdf8987-92dc-4303-9893-5ba154491446','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','09D45DDAF23E6B37E8CDBDA0720CA512','2019-12-29 14:53:17','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9d68b275-3604-4bd1-baaf-b997502ec830','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EB27908B2CCE509592A91FA789218ACB','2020-11-11 09:52:12','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('9ecba9ea-f1c3-4e44-b873-0f0fa7b344d1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.5.174','2064D50844DBBE26B17A3F711DAEF3AB','2020-01-19 16:48:26','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9f44426a-2bc1-4670-b8f6-f719bce6d5d5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','85AEF1F9857F0C099185BD23E8A1B852','2020-01-12 15:58:33','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('9f540ec2-ddc6-48c7-9912-2c6f83d31fdc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E4FDE412CFFAF69840D8CC3D3D3235E2','2019-12-15 19:28:41','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('9f6bd396-69be-4926-9ab2-9b321332f676','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5495E0B851182B9106350AA696E500E2','2019-12-16 22:38:20','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('9facf4fd-e8fa-4432-8b5a-77235197eb7a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7E508BF7B1BB5E2A2DDB628A172E29B5','2020-01-13 11:58:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a212ff47-048e-4455-8f5b-0b28d46a3583','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','172.16.0.15','0B0C063EE81A4529D86BB5FBA475AED3','2020-02-18 18:16:30','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a28fe31b-d2bd-4cc1-b3b9-4b7cde2497a9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1640DF9A47CEFC3089CF2C67CA5A1351','2019-12-29 16:10:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a322cfa6-7ae5-4d44-9e47-e3f2d8e818cc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0DE83D33022983A42BEAFFBBBA442E53','2019-12-22 10:56:26','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a364326f-d225-4b74-b9ef-91f76a655d7d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','ED89916562F9D77E5DE7E920CCA45871','2020-01-12 16:38:30','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a46b2524-f9cd-424c-858e-4568aaaaa8fb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9F0A671C3AE1DCAEFA56542914524E64','2020-01-01 11:57:01','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a548d692-d48d-42f3-82a6-69178cc3c3ca','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D086696CF4C962DD902A594511200696','2020-01-01 18:11:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a6109b14-f7f2-4805-bed8-a0fdefd60337','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0F9B245161F93999F6E25D249B21F4C4','2020-01-12 15:42:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a630a5e1-166e-47dd-876d-41233bd1fa38','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','65A1DC0C4568963B96F1E5CDAF057361','2020-01-12 16:20:32','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a63af1c3-1b15-49e7-8cfe-73e1cb25076a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','21DC883FD84F83EDE7F7EB7C326E1485','2020-01-01 11:20:30','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('a661e443-a41c-4a3c-a9ab-de45b4601c0f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E46B8E88126A229EC20C66E109EF315B','2019-12-31 22:05:19','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a77a0933-f104-47ac-89ae-027caebbe6a3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6EC8C0F0BFFC3F8D5646C6DCD362F6DA','2020-01-12 12:48:24','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a92b84e7-809e-4cce-a435-b477374a9951','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4607F7A2F9477B67472B8BE84E8505EC','2019-12-20 23:05:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a968ac1f-ca83-40b1-87af-af53a2862285','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D686566C25235CA0079AB3E31D73F31C','2019-12-31 21:59:41','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('a9920e56-bd66-43c8-920f-c800df54c95c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CB75D0A3A88D29BCE9EE2A026AEA1496','2019-12-29 14:51:39','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('a9963e98-52d8-46ff-b722-1b7557357f32','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','743702F003A9BA3A62A677494EB535E1','2020-11-19 11:11:25','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('aa0a8935-1efd-4b0e-8fcd-8279d495c5fc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0C08A81C089FB599A2695AADBC08492B','2019-12-29 23:04:00','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('aa43ef69-a5bf-44d1-bddb-947d8ce96ab7','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','33963F9BBB749DC8988C2E2DE0C4DF07','2019-12-29 10:58:24','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('aacaee78-16b7-469c-9cc6-ea81a8739de4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E4BDEAE6B5432DD8897A5D6304EB21A1','2019-12-22 11:04:24','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('aadf4ede-5faf-4c66-b725-906f9b2f9e9c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C71B188514CCD08484D35F288668533E','2020-01-13 17:38:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('aafe788a-ab51-4b05-874c-2488af8ef2f9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0A07FCF851C432DFA15286B62C524F96','2020-01-13 10:07:30','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('ab02d717-2253-4dcc-a0bb-ee6abd447199','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:29:18','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('ab4bc64a-a098-4bc9-a28b-3af179345532','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F70639758F45021BC553AB60270C0E5F','2019-12-29 16:20:37','登陆',1,'子系统一','/loginSSO','yutu_web','f2f66839-b5f6-430f-b188-f2b6bf2ca890',NULL),
('ab943dce-dc08-43a2-8e88-a5688644a047','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','ED9764E76558F144C2FD2CF569EBFBC6','2020-01-01 10:28:30','登陆',1,'子系统一','/loginSSO','yutu_web','c64e3b18-16e4-4c11-92e1-02bbb5fe95af',NULL),
('aba9741b-5c51-4203-9a26-d7579f7bc4af','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','21725DFB9E2E06CBE223FFDC130ABF85','2019-12-29 16:46:29','登陆',1,'子系统一','/loginSSO','yutu_web','78b5c279-ffad-472e-92c1-75e51afa6f05',NULL),
('ac01a3b5-b3eb-49a5-b9ab-8cc677227439','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','BFA0FBF52FFE7283C5970445FC5A6047','2019-12-29 16:08:56','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('adf04177-667c-467c-85ee-44d492c04a90','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C6295FB72030D1D82366E4178EB5E5FE','2020-01-13 11:16:13','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('ae38732b-0baa-42a8-b852-d91ef29a71f6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6989C4B63CFA15417BA820EA704BFB75','2019-12-29 14:32:10','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('aed42665-24b0-40e9-990c-bbc051aaf0b1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F18EB0A1CC3613C3A3872CBD1C425746','2020-01-01 13:48:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('af7c7efb-67e8-4c35-a352-75940cadd07a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.25','E26D5405742F123E6AAC6DF603E40E7D','2020-02-22 10:06:32','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b0a4dab9-3646-4eee-a397-31e897d98eaf','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CF319C45368713592296192DE7A3BA55','2020-01-12 21:25:22','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b0dc3671-ca94-4783-9297-2e39b0a999d1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CDFF81CE8D33E4448F3F0302AC519A5E','2019-12-22 10:57:53','门户登陆',0,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b1664596-74f2-4d74-b8f8-130bc001569f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','07D08D55E3E84FAB78FAAC1D80F70229','2020-11-11 09:19:42','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('b1da2f1a-95ae-4efb-8c9e-ebec2981db09','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5C84176257B2C1316EAED16CB05C638B','2020-01-13 14:59:19','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b1f7bed0-119a-4ffc-990b-b1d7106c3f3c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B90552FB616F3A6FFDD3A65D511A70B1','2019-12-22 09:13:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b3047349-ad48-45af-8af0-40483da36285','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','485DC59C11E5B123659FD180B3C3264E','2019-12-29 23:01:59','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b310b487-2ae8-40c8-a252-2a2d05357643','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D173E9C14A2DEDD03AEBF0B9205689B9','2020-01-01 18:05:04','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b33dca7b-0f83-41c4-b1b1-486a64fe8013','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','88FC9049EDE87326716E0AC758E1B895','2020-02-18 17:06:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b37e7f5a-3faa-481c-8dec-f0a8cc6be9cc',NULL,NULL,'0:0:0:0:0:0:0:1',NULL,'2019-12-20 22:36:49','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b3b389c3-6408-4ae4-875d-aeb90e699624','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','693AB0039FE9C478965A5E262A0AD8C2','2020-01-12 16:15:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b44a8958-296d-4a50-9928-0ee7fa0ccb6a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','579FE368EBC5FD6AF29736D3410B4F91','2020-01-01 10:37:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b4560603-50fd-4d55-9a8e-3bd08d8cfd7e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7DDFCC8D1DD2F6A7FA9C9800A5641C76','2019-12-29 22:42:57','登陆',1,'子系统一','/loginSSO','yutu_web','090b7a8d-b4fd-46fa-8bf0-eb81033c6f11',NULL),
('b46d918d-c394-4571-a13d-12439bb7a3fe','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4AC95E6E9CD124952F6D825CD2C45558','2019-12-15 21:46:17','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('b4798a45-34d8-46b9-8a8a-e13dec3bccfe','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0C62390B536E11AC2121397289C73140','2020-01-12 14:57:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b52d6018-a0a9-4200-bbec-d28371db26e9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','732BEA0C0CF47A88462990FFF14C9AFB','2020-01-01 10:28:25','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b60e4ab3-6fad-407e-b57a-ecea552b856f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','401FF4487C4A25A1D1957AA5B3E08C40','2020-01-12 15:36:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b64860e4-4d62-4c48-afd5-2113654740bc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AEB4FBA14505E39504AE5044CA99EBFF','2020-01-12 15:46:02','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b6a4af38-ec36-4806-b5e8-4ed30940bcd1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4104B8488AC68A7561BA5278306AB733','2019-12-29 16:42:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b7243aa4-f82d-4a2d-ad69-6e1af368d4a4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4CBCD30A983229E65360AD9B63686940','2020-11-11 09:41:36','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('b73cb29f-84ba-4ad5-b954-544db073262b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6D029D4CB172A6847954257B40541415','2020-01-12 15:05:17','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b7bd6065-92fa-4ff3-972d-f44f3b712bf5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DAA2525ED48B3DC0D3B66384E2E29491','2020-01-13 09:25:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b7c17ffb-4a67-400e-8384-291eb982de47','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8D1FC694C7E44DD3046E49B68E33ED18','2020-01-13 17:56:54','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b7c2ff58-19e0-4f12-a352-ffb6771684ed','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B0152592DB3D328C3D2321525E9B28DB','2019-12-22 14:54:05','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b80c27a8-dabe-496e-87c0-a79fbf1b3c2d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','82886CFC681F13E009DB2A1845F30283','2019-12-29 16:45:53','登陆',1,'子系统一','/loginSSO','yutu_web','87742fd0-8bb2-4dce-a9be-f083b7e7fa66',NULL),
('b8b3499a-b341-4112-8976-4fc104d35f17','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','37195751F76A239F26667253309D4148','2019-12-29 23:04:21','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b8c2d635-576d-42f5-8880-841868dbeee1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CBAAF27FF445BB16CC791377F5E0AB9A','2019-12-29 12:06:15','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('b991c8bc-5ab4-4b3b-9e7f-5eda6d3daa7b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E7D83A03DEB4C0929737F65AAFD1E4AB','2019-12-31 22:09:32','注销',1,'子系统一','/login/logout','yutu_web','17a6df9d-997e-49ea-b7ba-acebb47aedb2','org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 192.168.4.20:16379'),
('ba3d9d9c-171f-4ac5-be15-b1c3077fd5bc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','52582A70835E96ECD4C21298C5264859','2020-01-12 15:50:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('ba4eb03e-bb9c-45b0-9279-dd026735f7c8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','655245D8E39EF0924FE94D99512C1D65','2019-12-29 16:11:21','登陆',1,'子系统一','/loginSSO','yutu_web','2e1861c6-74ba-4721-8eae-57d308de3094',NULL),
('bae67339-642b-4d21-801c-6470a6f88339','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5883816B4CAE21BDA7811A608623C941','2020-01-01 11:24:46','注销',1,'子系统一','/login/logout','yutu_web','90839012-de65-452a-9598-2d1d82c02071',NULL),
('bb0954d3-763a-44ac-8bd1-908a20d2e43a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','09804FDA98F65BE17A87BF8982950339','2020-01-01 18:27:10','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bb38bfbb-9b8d-41ec-8381-91ca789aca5b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E9BF1D60D783B14FCDF22B828DE9D454','2020-02-19 17:57:53','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bb4a557d-271a-4845-8a34-7f9e3824a988','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DA6DFA5EFDE87031CDA7BAE6F85F2C03','2020-01-07 22:31:23','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bb5a6de7-0ba6-4e81-830a-2fb333d0daf1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E1D7D87AE822DCE3CD4BCF849468C9D1','2020-11-11 15:58:28','登陆',1,'子系统一','/loginSSO','yutu_web','cloud-zbc18de2334-b8a8-46e4-bee9-c61cf7e27705',NULL),
('bb835e61-32a0-4717-b351-959633fca9f6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','96A8C82C2485E58C1F2C17170ACFD8A4','2020-11-11 10:55:38','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('bb95185f-20cf-4223-bf4d-467b27ceffb3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5907ED2B1F141E8641F107D898FAF159','2019-12-29 22:12:17','登陆',1,'子系统一','/loginSSO','yutu_web','ddba4332-7293-41cb-b842-ad19bcd7bdf6',NULL),
('bc2e89c8-b826-4bae-95fa-ea078e360fcb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','97174B567206BAC105E34AFE5BE71570','2019-12-22 11:21:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bcab32a0-38ea-4552-a91b-a623aa075431','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C91B097239E6F7B4948265380A618EDF','2019-12-29 11:31:03','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bd23b980-6b36-478e-8ae3-10e9938c4a02','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','3C6A5ADCDA800BB34D5D2E5CDADA7A26','2020-02-10 16:48:52','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bde5c910-0ff4-49b4-a1fc-2756d8499e9e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C92F70DDE7D57DF199F4FF1F87738DA3','2020-01-01 11:25:04','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('be92b868-a938-49c9-a5f8-22eae55c1a63','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E0AB2AA320F94C8368D429D3023698B5','2020-01-13 09:21:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('bf621cc3-a842-46a8-88b9-93ee4921c25e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','12716F9FE74D3DA2C4D82B724273DFE6','2019-12-28 22:05:29','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c0778630-8ae7-415d-b837-6a5fb1610b31','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','698DFB64E49C89A9E9BFB48A43E8DAA7','2020-01-13 09:27:29','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('c0acc260-10f9-41f7-8a32-a6c067f538ac','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','462B007C203B48C9F7BB5EA8C4D30DFE','2020-01-12 21:20:26','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c0fdf446-a025-43fd-a783-b65c8a6b778d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C5500FECF3D02E545BD36004E7EB8EA9','2019-12-29 22:46:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c1a8abcb-88ee-4372-adce-6b759a70aa1d','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4B9C634254FD67B17061309E4DC6B63E','2019-12-29 16:44:37','登陆',1,'子系统一','/loginSSO','yutu_web','a58d91ac-2734-4bd9-8674-bc733738517e',NULL),
('c202cde8-43dc-4a15-bd34-e93ca2cf4eca','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1F6709AC0C219142BB78BD238199B400','2020-01-12 12:55:53','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c252e2c8-7460-4f17-812e-b2cee62265b0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4DDD31EF5A666A73809B0B0C3A9EF035','2019-12-20 22:54:29','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c2a68ab2-d3e6-458f-b871-a696dcebd3ea','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2CECE49F7A29216FEE3246B0F509C628','2020-01-01 11:16:45','登陆',1,'子系统一','/loginSSO','yutu_web','db68b294-acba-4819-81b9-1157e9eabb8b',NULL),
('c329f5a3-2dd9-49d3-a741-16601e153650','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','750B789B90604F5320B148BCF02FD224','2019-12-29 14:13:55','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c3ab3bda-f7f3-4798-b8b9-5b784613788b',NULL,'admin','0:0:0:0:0:0:0:1',NULL,'2019-12-15 18:04:54','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('c3e7d02d-f27b-4447-9558-eba08ba1c914','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','743702f003a9ba3a62a677494eb535e1','2020-11-19 11:11:28','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('c41ded4e-09f3-4166-8971-ab33c856e890','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','07484D6FD5EC9EC44F020A1FF02E65AA','2019-12-29 23:00:37','登陆',1,'子系统一','/loginSSO','yutu_web','d7302744-02a3-4eb4-8ce7-741eb2249901',NULL),
('c44f0e61-c91c-410c-92e6-623e6910bb0b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','ED3837F5E9A11A1CF093AD8BA7B322EA','2020-01-07 22:36:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c4fefa64-e6ea-4192-b2ae-3b7660297010','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2AE644F21753E7F81878DB2A1FF474D4','2020-11-11 10:58:24','登陆',1,'子系统一','/loginSSO','yutu_web','Cloud-ZBCf554c0d6-4646-46dd-9e6e-e2b70a6b1add',NULL),
('c66b9636-b4b1-4904-a7e1-cdf6d3f7007f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2991C198F392DC760FA46DF166947DC1','2020-01-01 13:43:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c6ec40f1-62a9-4e9b-944b-325c49177dad','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C6FFCA66B30C4C2A2FDF4D473EA5CFA6','2019-12-29 22:41:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c730b44b-184e-4dd2-81d3-4cf66c93185e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A67C7A565C6115A35A887FEBEB607F08','2019-12-29 22:42:38','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c7c33c7c-1b63-4ac8-a520-43edc9d84534','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','01819A895F714F95F85801457795E268','2019-12-29 22:43:31','登陆',1,'子系统一','/loginSSO','yutu_web','090b7a8d-b4fd-46fa-8bf0-eb81033c6f11',NULL),
('c849b774-315a-4dcf-8450-d6f49ef1fe45','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A78C099CE83E19CB3D751534645E6FE0','2020-01-01 11:29:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('c8910e5d-7f2d-4ae3-acea-bbb5f7e98dea','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','74D84E2416C3B0FBEFEC6609640E73BE','2019-12-29 23:04:22','登陆',1,'子系统一','/loginSSO','yutu_web','24488963-0986-4837-8e95-4f7508538853',NULL),
('c89ed232-7b58-43ea-b76e-f144128bb194','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7DDFCC8D1DD2F6A7FA9C9800A5641C76','2019-12-29 22:31:30','登陆',1,'子系统一','/loginSSO','yutu_web','8510f4a6-ab59-4b41-aa24-efa784121bd7',NULL),
('c9f2da4d-19d9-4166-87a4-06be48bca72e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E7D83A03DEB4C0929737F65AAFD1E4AB','2019-12-31 22:09:03','登陆',1,'子系统一','/loginSSO','yutu_web','17a6df9d-997e-49ea-b7ba-acebb47aedb2',NULL),
('cbcf9fb1-42cb-47df-a771-b7a101488d6b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','DDB12C969D7D9AE5E04894F7AA1F02BB','2020-11-11 10:33:55','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('cbf5197c-db7a-4478-aa5d-69f1a5432af0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8F645A0381C8971B7A4959FEA9C60999','2020-01-01 18:14:16','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('ccd3b205-4b17-49e7-8395-b268fd71ea25','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3CC6667610A5CB228BC6150BC6B4B7A8','2019-12-31 22:07:00','注销',1,'子系统一','/login/logout','yutu_web','17a6df9d-997e-49ea-b7ba-acebb47aedb2','org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 192.168.4.20:16379'),
('cd0658e2-9d69-4f63-935b-14347bfbdbe4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0FE498EC2D4410B3E8BEFEADD9B1C4E7','2019-12-22 10:49:11','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('cd2430ed-2173-476b-b229-9b7bbe07431b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4C01E74764F097AF7880B9F0927468A7','2019-12-28 22:28:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('cd6354ac-ea87-4522-8c98-ee8986ad07f6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','3CC6667610A5CB228BC6150BC6B4B7A8','2019-12-31 22:05:46','登陆',1,'子系统一','/loginSSO','yutu_web','17a6df9d-997e-49ea-b7ba-acebb47aedb2',NULL),
('cf443504-29e3-4484-9ec7-4ea2b9f830e4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','77DD572CB63561BF4D892DF230965C30','2019-12-29 23:02:01','登陆',1,'子系统一','/loginSSO','yutu_web','6cfcb3b8-e456-4d1c-bb22-4bdf1a8a091d',NULL),
('cf87ae1c-2da1-4e29-b01e-f05e2e750567','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C9F9A41720B1718D331DD7391E9528BA','2019-12-22 11:28:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d0b524a8-f568-4cd0-a9b1-57d8ede0e649','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0FE498EC2D4410B3E8BEFEADD9B1C4E7','2019-12-22 10:48:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d0cb7339-22cd-482b-843a-b79799af035e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.169.77','C3683896A6D9FB1BC47E746A0EFFE371','2020-01-17 16:11:51','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d121620f-0e52-4f1c-ab5e-04b3416bae62','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CE943DD75D115C44E3F86CE547CB529C','2019-12-29 15:24:55','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d14a28f2-6d7c-4632-948d-b6495f8e9c05','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','51A268F053BEB77E629268D99D2A756F','2019-12-29 16:11:45','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d27bab0a-e9d1-4be2-b076-360696259cd4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','BA59C7E6BEE8E81AC9FCFCFA58CD20EC','2020-01-01 10:30:23','登陆',1,'子系统一','/loginSSO','yutu_web','c64e3b18-16e4-4c11-92e1-02bbb5fe95af',NULL),
('d313ff54-38f4-42bb-a9cd-805f934afb0c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','891081DE8F3EAA57D5BA2FBDDB31AFB0','2019-12-29 16:49:59','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d36c0fcc-746d-4d6e-b454-880dd22a5516','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','649244B7DB95710BF64560F9BF0F6399','2019-12-29 16:54:16','登陆',1,'子系统一','/loginSSO','yutu_web','300b2506-0baf-4870-ba88-b22bbc1c2652',NULL),
('d4bfd622-7b6a-4215-8546-1acb4a91c5c4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.25','36C713ABD3B039EA4A2F500B4B46A896','2020-02-20 18:40:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d4c842ed-97b9-4892-99d0-ade252accd3e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','AC4B714B489E0EB04E7925499BA0C561','2020-01-01 11:19:05','登陆',1,'子系统一','/loginSSO','yutu_web','1a092546-c0e3-48df-98da-6d1bdd50181e',NULL),
('d5b55c1e-3222-4c52-b03c-941d731451e0','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','F1CA404A9841CF8A5D7351E358999C76','2020-01-01 11:37:22','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d60eb2c0-eaa2-423b-89c3-7b06a06f787e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5DE241E1FC266830CC7F094BF8DE3E15','2019-12-29 14:39:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d7f93700-01b4-4713-993f-4e3b602140a9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CE25D29008E43582DDC09F19DDE9134D','2020-01-13 09:58:10','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('d8418e41-3f73-4bb8-9c3a-e850be9bf108','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','01C9F73EF1DDF2744302837838096714','2020-11-11 10:50:05','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('d902e028-bc66-4b37-8cd8-baafd0f0ba69','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8CF606BA7E53E6DCC4E6085DDA1C5105','2019-12-22 14:57:20','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d947e7c5-421d-4e2b-a862-6215522af850','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','67074587357E08C6CDF55ABF50E4A736','2020-01-12 15:19:49','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('d9d2db9b-9049-411d-a716-42dcaf761498','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','B415B678B5A5B9CD92BB78196EFEB697','2020-02-07 17:13:10','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('dadfca4d-9cd9-4464-95dc-90b5ede196ea','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B57A6383FCC9DE13787A14DD54E97C26','2019-12-26 22:19:36','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('db0a81bb-70ba-4ec2-a715-aa8ad0051ccc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','09AA342CF9EBFD2F1B0FCC4351BA5F17','2020-11-11 10:38:24','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('db6fffaa-345d-4bd9-b9aa-59b5a2edbfca','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','965089B84FBB851DEF609F902349F6FC','2019-12-18 22:20:34','用户登陆',0,NULL,'/login/getLoginVerification',NULL,NULL,NULL),
('db97deae-912e-4e75-b907-a34d6d3a47b4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.2.39','6192E619C5770AB5B4E0EB44AE679C64','2020-02-06 15:19:50','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('db9cb03c-7e46-4984-bb90-0eba9b178165','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','A9FA8EE6C14943373E3D91CBCA7C39F5','2020-01-01 10:40:42','登陆',1,'子系统一','/loginSSO','yutu_web','c122186b-90cf-4d5e-857c-338772bfee1b',NULL),
('dc39efc5-e8a5-40de-a5c8-3ba125db6fda','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','5437271D6AA279322A2659778EC184FB','2020-01-01 13:27:37','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('de2f846a-8867-4a9b-b3d3-9a10ed25947f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','4448AF1B483078FF3CC17DBEC48EB660','2020-01-01 11:28:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('df24538c-be82-4c7f-8a09-dd54f6592d73','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','929052AAE70543C399018661D8DF9C8D','2019-12-29 10:28:06','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('df2fec6a-53a3-4742-8a2e-d4f62b8e7896','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0FE5308A42BA4293EDD21D829CA48386','2019-12-29 10:16:52','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('df66d785-b476-465d-97a0-639da308697c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','579FE368EBC5FD6AF29736D3410B4F91','2020-01-01 10:41:01','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('df827691-4781-410a-b6cf-d365c78c3636','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','164E2DAC180E6DDCAF8DDBE391C3F1DD','2020-01-07 22:45:25','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('dfb1f0c0-2d36-475d-87ab-b8359fa5c814','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E51FE2C4EEA22CA234D288E4DFF697B0','2019-12-29 14:46:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e0042ac5-485f-472d-b480-d63cdf6e2b4a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E98FDEC2E2091A2A81F88E552060A91B','2019-12-29 11:07:45','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e0b83e6c-39f7-4d53-a2ee-ee9042aa613c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','1FA75E1E1E894CEA21683C308CD30D1E','2020-01-01 11:20:47','登陆',1,'子系统一','/loginSSO','yutu_web','90839012-de65-452a-9598-2d1d82c02071',NULL),
('e16bfbeb-a09f-4cff-907f-7a8abc32ab9e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7592797BCC8D376C5FBCCA92AD28975A','2020-01-13 19:00:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e19001fb-d551-49a3-aa81-21873b6dda1b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6661A2D7F2F07336C54C05211A9A1E2C','2020-01-12 15:51:03','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e1b4dac5-42a2-4fe4-b7eb-35fc9aa91dcc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','698DFB64E49C89A9E9BFB48A43E8DAA7','2020-01-13 09:27:28','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e2aff858-abbc-454a-b662-1f28bb15974a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','68C3E0A97A2300D0386B3C2FEFA84DB2','2019-12-22 17:31:19','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e31b582d-673c-4233-b376-97db76caff92','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.25','E26D5405742F123E6AAC6DF603E40E7D','2020-02-22 10:06:31','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e3613b82-2f6c-4bef-b892-f9bce53cccf6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','2223E0F55F93DCBA847F86819DE7A040','2019-12-29 15:30:56','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e4f361cf-4cad-4e50-8561-bab4d9e0bd82','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','ABB628B87EF262947E5679D45838DA30','2019-12-28 22:26:06','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e51bef2b-4328-49ba-b276-a378d04c2e8e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F6537FB3047E43857C705F918AFAB8BE','2019-12-31 22:05:08','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('e55971c3-c0ff-4ce8-acfa-5f187749a27e','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E0A886C676AA17E4FB64A58825621E80','2019-12-29 16:42:14','登陆',1,'子系统一','/loginSSO','yutu_web','5898d7d1-53d8-429e-9f70-e28b513c0484',NULL),
('e58bc1ba-bcc6-4343-916a-8d1c2897fef9','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8D1FC694C7E44DD3046E49B68E33ED18','2020-01-13 18:14:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e714fb22-c505-4dfa-aac6-819a41deb291',NULL,'admin','127.0.0.1',NULL,'2020-01-07 21:43:45','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e729fe9f-51d2-4a63-9dab-29a1029bd905',NULL,'admin','127.0.0.1',NULL,'2020-01-07 21:44:40','门户登陆',NULL,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e7b50ce4-3ed0-42f8-8eca-5614dbbabb33','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C7414B3BA36E4F84894CE113A9D43F0F','2020-01-01 13:47:10','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e8168ac0-76ca-4c8d-88eb-481339ee03f4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CF319C45368713592296192DE7A3BA55','2020-01-12 21:25:09','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e8ba5710-fd51-47e1-af8c-f3ce56927682','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','172.16.0.15','3B0471CA04E08D33C78752E83AEE9D57','2020-02-19 10:33:52','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('e9613a39-c18e-4ae9-a863-56e9c00830e1','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','52F01D7FC484D18C52C39B105AA07165','2020-01-12 16:37:14','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('ea01ec09-d853-427e-b4a1-fa2486d23168','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2D27D12B4C4F96C57971EC8E41843D16','2019-12-29 16:41:17','登陆',1,'子系统一','/loginSSO','yutu_web','1a1020c8-cc5d-4fb9-bc97-fff9c6f9d6cd',NULL),
('ea627187-ea9e-4c86-95ee-39204057f614','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','BF515B613FC71C7B29D67606F15305F2','2019-12-29 15:01:41','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('eb7c8f7c-fb58-48c8-961f-4a1d3f7c0e9f','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','65A1DC0C4568963B96F1E5CDAF057361','2020-01-12 16:20:46','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('ec1869bd-e459-43c4-bde2-99ba6b7cd4eb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8A4301DA816982003BC704C693C5D288','2019-12-31 22:28:42','登陆',1,'子系统一','/loginSSO','yutu_web','980470cb-74ab-4add-85cf-12b8897c9dd5',NULL),
('ecdb99e6-95d7-4f03-9142-5f6acbe9067b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','E9BF1D60D783B14FCDF22B828DE9D454','2020-02-19 17:57:54','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('ed362318-0b83-4b6d-bb64-ebf1f9820e62','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D90E0FFE5E141AC9FE202A666AAE32D3','2019-12-31 21:53:34','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('eda65cbf-a4cd-42f1-a194-a8d51983e7d4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','EACF25C1DD3BE23FC650BEE0C09F27D2','2020-01-07 22:43:51','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('edc8023d-b4a0-4232-911c-1bc0be14b4ce','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','39CA7AA13A34A320CC2E8E6580B17024','2019-12-22 17:39:25','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('eeff71bb-7c81-47e6-aaaf-7f2f1c12fbc8','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B0E2BC12E7E15E534B89D7D94F365C77','2020-01-13 09:38:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f01b31ef-5e30-438b-8508-0b155564c7db','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','7592797BCC8D376C5FBCCA92AD28975A','2020-01-13 18:48:40','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f1c1110e-dd00-4311-9798-17547f0f6da6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','9F0A671C3AE1DCAEFA56542914524E64','2020-01-01 11:57:23','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('f1d13844-85a0-4b3e-a6c4-6ff6b3ed555a','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C6295FB72030D1D82366E4178EB5E5FE','2020-01-13 11:16:07','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f216b8c9-6151-4afb-a9d7-9bcd6070c1cb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D686566C25235CA0079AB3E31D73F31C','2019-12-31 21:53:39','登陆',1,'子系统一','/loginSSO','yutu_web','05535a3f-2328-4085-9596-13617b7c81ab',NULL),
('f25fd817-3ac6-4893-9587-202571a72013','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','05529A3961A41DFF841333C5D62DB36C','2020-01-07 22:45:21','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('f2e5de19-f341-49a6-81d1-61794a8009b3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D4A55C2895B1F0F5B579BAE0E85A886D','2020-01-12 21:22:06','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f451b87b-4063-4c94-a813-615404b80e78','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C1034BA57F07E1997484075DC50D1349','2019-12-22 10:41:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f47a9142-d67b-4054-84d3-a3b3201d0cf7','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','788072749DBF0BCB5823A776AB28304E','2019-12-29 16:54:03','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f578bcaf-5baa-48b6-a202-49e412d8dc96','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0B9BE774D27CFBF98A3830A5217DEA04','2019-12-29 11:31:48','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f7490fe2-4925-4119-b746-a52d81499943','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','127.0.0.1','0DAC4EF876CDDC31B08206B67F534F6A','2019-12-29 16:49:49','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f75fef02-9eee-4d5c-9d65-30a0037c8afc','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','67074587357E08C6CDF55ABF50E4A736','2020-01-12 15:20:02','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('f78fc407-d0aa-4b2b-9c6f-c2823211f3b3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','C71B188514CCD08484D35F288668533E','2020-01-13 17:33:17','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f80a7c7e-f9af-4632-9b6d-2653045d7613','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F69A8675A73F95C58B28E6CC32A29218','2019-12-22 17:54:13','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f8f6f007-37e3-4384-842b-5be7f14b5107','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','94D0F9BECD1F65D3F97EEFA7B3BC5589','2019-12-29 10:36:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f98eab01-cc62-485b-af07-964682eb9b20','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.25','DC9921D3B7EFF855A559108D187A9F09','2020-02-19 10:26:00','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('f9ce679d-a1ed-43de-aef0-4c86f98bb9fb','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','8359103186EB65666CC0D3059CC5E872','2020-01-07 22:29:00','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fab45b39-e187-4007-9f36-815a4d2c01c5','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','F61A731FC50D41A2E1CED3ABEEFE2FD1','2019-12-22 11:29:35','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fc627d60-c71f-4b65-a179-5a85c04e4eb2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','FD85801C596045C9126B33741DCBB1E2','2020-04-28 11:58:42','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fc65c6f4-c749-4541-9096-8af3e64a7570','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','D6EC033C829915D4A47ECD819A550170','2020-11-11 11:16:23','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('fcef3dd7-06c7-41cf-a03a-c085a8b73e13','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','B0E2BC12E7E15E534B89D7D94F365C77','2020-01-13 09:39:01','门户注销',1,'系统门户网站','/login/logout',NULL,NULL,NULL),
('fd189284-e7e7-4d00-b4de-0a5ec7c002c4','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','07D08D55E3E84FAB78FAAC1D80F70229','2020-11-11 09:16:29','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('fd495e4e-81ec-4e1f-a7b7-3ce0c3ef72e6','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','CF8938E7CC87A1E6A0C65DC6C8454658','2020-01-01 12:16:47','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fd72e1a0-6a34-4ccb-a945-79d6bea1b922','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:26:53','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('fd80af0c-c512-4fa0-8536-caa57958d94c','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','6E6B3ED023DFC5F79FB754C4E8C5FE3E','2020-11-11 10:30:42','门户登陆',1,'系统门户网站','/login/verification',NULL,NULL,NULL),
('fdf1fe99-0dec-4379-9419-a2debb19a779','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','192.168.4.24','BDC39437F0E3FD89C7A44D79BAFE0F5B','2020-02-23 17:18:58','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fe803365-2641-48ef-bf4e-c83edb3821e3','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','699D43C6768BC7A4A18F2AFDD481BB4D','2020-01-12 16:34:18','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fed64b98-4db1-4c03-a2f8-77a5b86f8134','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','0F2411AE30AB4EDF547B34A3759251EF','2020-01-01 12:18:29','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('ff8a068e-c6f9-496a-8995-c96f29232f75','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','56C1DB63979BA5D8B5624CFC2C92A09B','2019-12-26 22:28:12','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL),
('fff4806d-641e-4251-a729-f7c6dcc2609b','ae771cf1-23f0-4e8e-b235-fc12a6fb4884','admin','0:0:0:0:0:0:0:1','2EECDB867D24EC2A1EB23C14C94DA0AD','2019-12-29 14:07:08','门户登陆',1,'系统门户网站','/login/getLoginVerification',NULL,NULL,NULL);

/*Table structure for table `t_log_operation` */

DROP TABLE IF EXISTS `t_log_operation`;

CREATE TABLE `t_log_operation` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `operate_db` varchar(64) DEFAULT NULL COMMENT '操作数据库',
  `operate_dt` varchar(64) DEFAULT NULL COMMENT '操作表',
  `operate_type` varchar(64) DEFAULT NULL COMMENT '操作类型   增删改',
  `operate_primarykey` varchar(2048) DEFAULT NULL COMMENT '主键',
  `operate_content` text COMMENT '操作内容',
  `operate_status` int DEFAULT NULL COMMENT '操作是否成功  0：失败  1：成功',
  `operate_person` varchar(64) DEFAULT NULL COMMENT '操作人',
  `operate_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  `log_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '日志类型',
  `appkey` varchar(128) DEFAULT NULL COMMENT 'appkey',
  `token` varchar(128) DEFAULT NULL COMMENT 'token',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志_操作记录表';

/*Data for the table `t_log_operation` */

insert  into `t_log_operation`(`uuid`,`operate_db`,`operate_dt`,`operate_type`,`operate_primarykey`,`operate_content`,`operate_status`,`operate_person`,`operate_datetime`,`log_type`,`appkey`,`token`,`remarks`) values 
('205de587-21e5-4c0a-bb58-067e446bdc1c','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据',NULL,'admin','2020-01-01 13:36:40','数据同步','yutu_web','zbcCloud-F3C00FE8D624DBB8AA7443BF86E4733B',NULL),
('28e90b17-c1ab-4e74-9e1f-e6be4d859dcb','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据success',NULL,'admin','2020-01-01 18:14:34','数据同步','yutu_web','zbcCloud-8F645A0381C8971B7A4959FEA9C60999',NULL),
('46aec451-31b4-4e31-b8ec-cde7655fd1bb','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据',NULL,'admin','2020-01-01 13:35:41','数据同步','yutu_web','zbcCloud-F3C00FE8D624DBB8AA7443BF86E4733B',NULL),
('6664d6f3-902b-4be6-9d6c-65064fb7ec36','cloud','t_sys_organization','update',NULL,'yutu_web子系统同步数据success',NULL,'admin','2020-01-01 18:29:59','数据同步','yutu_web','zbcCloud-F2A3F46DB1490D61B27620E3974B4466',NULL),
('6a9cc53b-9af4-484e-b66d-72f2a13b6ad3','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据success',NULL,'admin','2020-01-01 18:27:15','数据同步','yutu_web','zbcCloud-09804FDA98F65BE17A87BF8982950339',NULL),
('869b8720-59fa-4eee-a0d1-b5e34ddf21c8','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据success',NULL,'admin','2020-01-01 18:18:14','数据同步','yutu_web','zbcCloud-162DEB7F7D72CA3DED5BD67513ABBA08',NULL),
('882bb553-c056-4959-abd3-6a21d851bdf6','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据success',NULL,'admin','2020-01-01 18:14:33','数据同步','yutu_web','zbcCloud-8F645A0381C8971B7A4959FEA9C60999',NULL),
('a402b1fb-2436-424e-9e9e-5679f56dce72','cloud','t_sys_user','update',NULL,'yutu_web子系统同步数据success',NULL,'admin','2020-01-01 18:18:21','数据同步','yutu_web','zbcCloud-162DEB7F7D72CA3DED5BD67513ABBA08',NULL);

/*Table structure for table `t_menu_business` */

DROP TABLE IF EXISTS `t_menu_business`;

CREATE TABLE `t_menu_business` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `menu_parent` varchar(64) DEFAULT NULL COMMENT '菜单父类id',
  `menu_title` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `menu_type` int DEFAULT '2' COMMENT '菜单类型：1.外部sso弹出  2.内部跳转',
  `menu_url` varchar(512) DEFAULT NULL COMMENT '菜单url地址',
  `menu_page_class` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中的class，为了调整配置样式',
  `menu_page_img` varchar(512) DEFAULT NULL COMMENT '页面中的图标地址',
  `menu_page_other` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中其他的属性值',
  `menu_status` int DEFAULT '0' COMMENT '菜单状态  0：未锁定  1：已锁定',
  `order_by` int DEFAULT '1' COMMENT '排序',
  `delete_status` int DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单_业务菜单';

/*Data for the table `t_menu_business` */

insert  into `t_menu_business`(`uuid`,`menu_parent`,`menu_title`,`menu_type`,`menu_url`,`menu_page_class`,`menu_page_img`,`menu_page_other`,`menu_status`,`order_by`,`delete_status`,`remarks`) values 
('bc912616-2a0f-11ea-bde7-f875a40f96a2','0','测试一',2,'http://localhost:8096/',NULL,NULL,NULL,0,1,0,NULL),
('d4453d3c-2a0f-11ea-bde7-f875a40f96a2','0','测试二',2,'http://localhost:8096/',NULL,NULL,NULL,0,2,0,NULL),
('df9e3073-2a0f-11ea-bde7-f875a40f96a2','0','测试三',2,'http://localhost:8096/',NULL,NULL,NULL,0,3,0,NULL),
('ea452e22-2a0f-11ea-bde7-f875a40f96a2','0','测试四',2,'http://localhost:8096/',NULL,NULL,NULL,0,4,0,NULL),
('f2176a8f-2a0f-11ea-bde7-f875a40f96a2','0','测试五',2,'http://localhost:8096/',NULL,NULL,NULL,0,5,0,NULL);

/*Table structure for table `t_menu_system` */

DROP TABLE IF EXISTS `t_menu_system`;

CREATE TABLE `t_menu_system` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `menu_title` varchar(512) DEFAULT NULL COMMENT '菜单名称',
  `menu_type` int DEFAULT '1' COMMENT '菜单类型：1.外部sso弹出  2.内部跳转',
  `menu_url` varchar(512) DEFAULT NULL COMMENT '菜单url地址',
  `menu_page_class` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中的class，为了调整配置样式',
  `menu_page_other` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '页面中其他的属性值',
  `order_by` int DEFAULT '1' COMMENT '排序',
  `delete_status` int DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单_系统菜单表';

/*Data for the table `t_menu_system` */

insert  into `t_menu_system`(`uuid`,`menu_title`,`menu_type`,`menu_url`,`menu_page_class`,`menu_page_other`,`order_by`,`delete_status`,`remarks`) values 
('0c0fced6-1f12-11ea-a564-f875a40f96a2','数据汇集平台',1,'http://localhost:8096/loginSSO','oneTheme','/img/index/cj.png',5,1,NULL),
('667c2472-350c-11ea-b7c8-f875a40f96a2','案例展示平台',1,'http://localhost:8100/loginSSO','fivTheme','/img/index/al.png',6,1,NULL),
('8ae7c8c7-350c-11ea-b7c8-f875a40f96a2','智慧遥感平台',1,'http://localhost:8099/loginSSO','fouTheme','/img/index/yg.png',4,0,NULL),
('ac4784b7-1f12-11ea-a564-f875a40f96a2','精准治霾平台',1,'http://192.168.4.24:8081/','twoTheme','/img/index/dq.png',2,0,NULL),
('d385da86-1f12-11ea-a564-f875a40f96a2','系统治水平台',1,'http://192.168.4.25:9090/EnvWaterProject','thrTheme','/img/index/zs.png',3,0,NULL);

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
  `org_status` int DEFAULT '0' COMMENT '部门状态 0：未锁定  1：已锁定',
  `order_by` int DEFAULT '1' COMMENT '排序',
  `delete_status` int DEFAULT '0' COMMENT '逻辑删除 0:未删除,  1:已删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_组织表';

/*Data for the table `t_sys_organization` */

insert  into `t_sys_organization`(`uuid`,`org_parent`,`org_code`,`org_name`,`org_phone`,`org_address`,`org_Manager`,`org_status`,`order_by`,`delete_status`,`remarks`) values 
('8fc09900-1f11-11ea-a564-f875a40f96a2','0','yutu','宇图',NULL,NULL,NULL,0,1,0,NULL);

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `role_parent` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色父类ID（角色树）',
  `role_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `role_status` int DEFAULT '0' COMMENT '角色状态 0：未锁定  1：已锁定',
  `order_by` int DEFAULT '1' COMMENT '排序',
  `delete_status` int DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_权限表';

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`uuid`,`role_parent`,`role_name`,`role_status`,`order_by`,`delete_status`,`remarks`) values 
('b5aa892c-1f11-11ea-a564-f875a40f96a2','0','管理员',0,1,0,NULL);

/*Table structure for table `t_sys_role_menubus` */

DROP TABLE IF EXISTS `t_sys_role_menubus`;

CREATE TABLE `t_sys_role_menubus` (
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `menubus_uuid` varchar(64) DEFAULT NULL COMMENT '业务菜单uuid',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_角色和业务菜单中间表';

/*Data for the table `t_sys_role_menubus` */

insert  into `t_sys_role_menubus`(`uuid`,`role_uuid`,`menubus_uuid`,`remarks`) values 
('1','b5aa892c-1f11-11ea-a564-f875a40f96a2','bc912616-2a0f-11ea-bde7-f875a40f96a2',NULL),
('2','b5aa892c-1f11-11ea-a564-f875a40f96a2','d4453d3c-2a0f-11ea-bde7-f875a40f96a2',NULL),
('3','b5aa892c-1f11-11ea-a564-f875a40f96a2','df9e3073-2a0f-11ea-bde7-f875a40f96a2',NULL),
('4','b5aa892c-1f11-11ea-a564-f875a40f96a2','ea452e22-2a0f-11ea-bde7-f875a40f96a2',NULL),
('5','b5aa892c-1f11-11ea-a564-f875a40f96a2','f2176a8f-2a0f-11ea-bde7-f875a40f96a2',NULL);

/*Table structure for table `t_sys_role_menusys` */

DROP TABLE IF EXISTS `t_sys_role_menusys`;

CREATE TABLE `t_sys_role_menusys` (
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `menusys_uuid` varchar(64) DEFAULT NULL COMMENT '系统菜单uuid',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_角色和系统菜单中间表';

/*Data for the table `t_sys_role_menusys` */

insert  into `t_sys_role_menusys`(`uuid`,`role_uuid`,`menusys_uuid`,`remarks`) values 
('083137d8-1f13-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','ac4784b7-1f12-11ea-a564-f875a40f96a2',NULL),
('10ea09d5-1f13-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','d385da86-1f12-11ea-a564-f875a40f96a2',NULL),
('b28b7800-350c-11ea-b7c8-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','8ae7c8c7-350c-11ea-b7c8-f875a40f96a2',NULL),
('bcf6afc5-350c-11ea-b7c8-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','667c2472-350c-11ea-b7c8-f875a40f96a2',NULL),
('f36e6886-1f12-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','0c0fced6-1f12-11ea-a564-f875a40f96a2',NULL);

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `uuid` varchar(64) NOT NULL COMMENT '主键',
  `user_code` varchar(64) DEFAULT NULL COMMENT '用户特殊编码',
  `user_account` varchar(128) DEFAULT NULL COMMENT '用户登陆名',
  `user_pwd` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `user_question` varchar(256) DEFAULT NULL COMMENT '密码提示',
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户真实姓名',
  `user_sex` int DEFAULT NULL COMMENT '用户性别  0：保密   1：男   2：女''',
  `user_title` varchar(256) DEFAULT NULL COMMENT '用户职称',
  `user_phone` varchar(64) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(256) DEFAULT NULL COMMENT '用户邮件',
  `user_status` int DEFAULT '0' COMMENT '用户锁定  0：正常   1：锁定',
  `order_by` int DEFAULT '1' COMMENT '排序',
  `delete_status` int DEFAULT '0' COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统_用户信息表';

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`uuid`,`user_code`,`user_account`,`user_pwd`,`user_question`,`user_name`,`user_sex`,`user_title`,`user_phone`,`user_email`,`user_status`,`order_by`,`delete_status`,`remarks`) values 
('ae771cf1-23f0-4e8e-b235-fc12a6fb4884','yt-001','admin','be04d0fc5d4fe7d02fde6ce63727fdde','admin','管理员',1,NULL,'18001030020','it_zbc@outlook.com',0,1,0,NULL);

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

insert  into `t_sys_user_organization`(`uuid`,`org_uuid`,`user_uuid`,`remarks`) values 
('cde1e742-1f11-11ea-a564-f875a40f96a2','f875a40f96a2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884',NULL);

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

insert  into `t_sys_user_role`(`uuid`,`role_uuid`,`user_uuid`,`remarks`) values 
('e3fb4794-1f11-11ea-a564-f875a40f96a2','b5aa892c-1f11-11ea-a564-f875a40f96a2','ae771cf1-23f0-4e8e-b235-fc12a6fb4884',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
