## 核心配置区

* 系统框架： **SpringBoot+Mybatis+Druid+Thymeleaf+Docker+Vue**

* 系统版本： **V0.5.0**

* 支持数据库：**SqlServer、Oracle、MySql、Redis...**

* 数据库连接池：**Druid**

* 前端模板引擎：Thymeleaf

* 系统接口类型：REST/HttpClient

* 框架安全机制：
>       1.XssAndSqlFilter过滤跨站脚本和sql注入攻击；
>       2.MyFilter过滤非法访问url和用户；
>       3.黑名单机制用来拦截用户恶意访问系统；
>       4.MyInterceptor拦截器实时判断用户登录状态（需要权限系统）；
>       5.全局异常机制来保护系统出错时候敏感信息泄露；
>       6.必要时可以进行系统配置信息AES全程加密；
 
* 系统特色：
>       1.架构层和业务层配置分离，调整框架不影响业务
>       2.支持多库多数据源同时连接，换库更方便
>       3.多层安全保障机制，保护系统安全 

* 配置区：    
>      configuration：系统配置层,用于配置数据源信息；
>      filter：过滤器，过滤系统url地址；
>      interceptor：拦截器，用于系统的单点登录统一退出登录；
>      listener：监听器，用于加载起始业务配置文件加载和监控在线人数和登录退出日志；
>      exception：异常处理层，用于记录全局错误日志；

* 业务区：  
>      controller：控制层,用于前后台数据交互；
>      entity：实体类层；
>      init: 业务配置文件起始加载区；
>      mapper：数据处理层，与数据库交互；
>      service：业务服务层，业务处理层；
>      util：通用工具类；
>      webapi：对外接口层，系统和系统之前交互；

* 系统配置文件：
>      resources/config/*：自定义业务配置文件（关于业务的）；
>      resources/frame: 系统架构说明和数据库；
>      resources/application.properties： 系统核心配置文件，用于配置通用配置；
>      resources/application-dev.properties： 开发环境配置文件，用于开发过程中使用；
>      resources/application-prod.properties： 生产环境配置文件，用于正式版部署使用；
>      resources/log4j.properties：日志配置文件；
>      resources/mybatis-config.xml：mybatis核心配置；
>      resources/readme.md：系统开发手册；       

------------------------------------------------------------------

## 后台开发要求

* controller
>   1.RedirectController 为系统统一前台页面统一注册页，由前段人员参与维护
>   2.依赖注入方法统一用 @Resource
>   3.常规前台业务交互层返回数据统一用**MsgPack**类统一进行返回，类注解统一用@RestController，返回参数时无需再转json
>>      示例：         
>>               @RestController
>>               @RequestMapping("login")
>>               public class LoginController {
>>                   @Resource
>>                   private ServiceFactory serviceFactory;
>>    
>>                   @RequestMapping("getLoginVerification")
>>                   public MsgPack getLoginVerification(HttpServletRequest request){
>>                      //正常业务处理
>>                      MsgPack msgPak= serviceFactory.getLoginService().业务处理方法;               
>>                      return msgPak;
>>                   }
>>                }  
> 4.创建类和方法时候及时写注释，注释上必须标明创建人、创建时间、此方法/类简介

* entity
> 1.数据实体类统一放到table文件夹下，公用开发实力类放到主目录下

> 2.创建类和方法时候及时写注释，注释上必须标明创建人、创建时间、此方法/类简介

* mapper
> 1.遵循mybatis规范

* service
> 1.接口首字母用I，后面采用pascal 命名法

> 2.依赖注入方法统一用 @Resource

* webapi
> 1.接口之间通信统一用JSON,类注解统一用@RestController，交互json标准为：MsgPack实体类 

> 2.所有接口返回数据前必须通过**AES进行加密**，AES加密实体类在 /util/AESUtil
>>     加密： String aesMsgPack = AESUtil.encrypt(msgPack);
>>     解密： MsgPack decryptMsgPack=AESUtil.decrypt(aesMsgPack);

* **配置区的文件正常开发请勿乱动，如需要更改，请联系研发负责人** 

------------------------------------------------------------------

## 前段开发要求

* 静态页规范
>  1.首级目录命令为 templates  
>
>  2.主html页面放到 templates/*.html      
>>     例如：login.html/error.html 
>
>  3.模块下业务html根据各个模块分好文件夹 templates/ModularOne/*.html    
>>     例如：ModularOne     

* 其他资源规范
>  1.首级目录命令为 static
>
>  2.二级目录根据资源类型分类  static/js  static/css   static/img    static/script   其他类型造此类推 
>
>  3.三级目录 按模块划分，**具体命名与静态页一致**，主文件放外面，模块文件放到下一级目录
>>     例如：static/js/ModularOne/login.js   static/js/ModularOne/*.js  
>
>  4.第三方js框架统一放到 static/script目录下 
   
* 与后台交互规范 初版
>  1.与后台交互统一用ajax post 方式，传递参数命名采用驼峰命名法
>
>  2.后台与前台交互传递数据统一用json数据格式  
>>     例如：{"status":0,"msg":"用户名或密码错误","data":null} 
>>	    status：0：成功，  1：失败
>>	    msg：提示信息
>>     data：返回json数据



------------------------------------------------------------------

## 未完成的问题

> 1.XSS和SQL注入攻击实用性测试

> 2.监听器进行存文件和读文件时候会有一次，不稳定

> 3.Docker打包发布功能开发

------------------------------------------------------------------

##开发日志区 

* 2019年12月14日  V0.5.0
>   0. 用visio画框架图纸，确定功能和相关结构
>   1. 创建springBoot框架，已选型为2.2.2版本
>   2. 确定数据库为mysql8.0.18版本
>   3. 从yutu_frame框架中移植框架基础功能
>
* 2019年12月15日  V0.5.1
>   1. 创建数据库表结构，并录入相关数据
>   2. 调整框架登录session存储数据类型，优化部分登录代码
>   3. 创建相关数据库实体类，对框架进行跑通 
>   4. github对系统进行托管，配置相关环境和代码

* 2019年12月16日  V0.5.2
>   1. 更新maven配置类（pom）所有引用插件的版本
>   2. 优化generator 代码生成插件模板

