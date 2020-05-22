package com.yutu.controller;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.entity.table.TSysRole;
import com.yutu.entity.table.TSysUser;
import com.yutu.service.IAuthorityManagerService;
import com.yutu.utils.BlacklistUitls;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:21
 * @Description:权限模块前端接口层
 */
@RestController
@RequestMapping(value = "authority")
public class AuthorityController {
    @Resource
    private IAuthorityManagerService authorityManagerService;


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 获得所有部门列表  分页
     **/
    @RequestMapping(value = "org/list")
    public MsgPack getOrgList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack = authorityManagerService.getOrgList(1,20);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:52
     * @Description: 获得用户列表
     **/
    @RequestMapping(value = "user/list")
    public MsgPack getUserList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack = authorityManagerService.getUserList(1,20);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 获得所有权限列表  分页
     **/
    @RequestMapping(value = "role/list")
    public MsgPack getRoleList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack = authorityManagerService.getRoleList(1,20);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 获得所有黑名单列表  分页
     **/
    @RequestMapping(value = "black/list")
    public MsgPack getSysMenuList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack.setStatus(1);
        msgPack.setData(BlacklistUitls.blacklist);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 新增部门信息
     **/
    @RequestMapping(value = "org/insert")
    public MsgPack getOrgInsertByObj(@RequestBody TSysOrganization organization) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getOrgInsertByObj(organization);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:55
     * @Description: 新增用户信息
     **/
    @RequestMapping(value = "user/insert")
    public MsgPack getUserInsertByObj(@RequestBody TSysUser user) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getOrgInsertByObj(user);
        return msgPack;
    }

    /*
     * @Author: zhaobc
     * @Date: 2020/1/21 10:55
     * @Description: 新增角色信息
     **/
    @RequestMapping(value = "role/insert")
    public MsgPack getRoleInsertByObj(@RequestBody TSysRole role) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getOrgInsertByObj(role);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 根据id删除部门信息
     **/
    @RequestMapping(value = "org/delete/{id}")
    public MsgPack getOrgDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getOrgDelById(id);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:57
     * @Description: 根据id删除用户
     **/
    @RequestMapping(value = "user/delete/{id}")
    public MsgPack getUserDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getUserDelById(id);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:57
     * @Description:根据id删除角色
     **/
    @RequestMapping(value = "role/delete/{id}")
    public MsgPack getRoleDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getRoleDelById(id);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:58
     * @Description: 根据id删除黑名单
     **/
    @RequestMapping(value = "black/delete/{id}")
    public MsgPack getBlackDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();


        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 根据id修改单个部门信息
     **/
    @RequestMapping(value = "org/update/{id}")
    public MsgPack getUpdateOrgById(@PathVariable String id,@RequestBody TSysOrganization organization) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getUpdateOrgById(id,organization);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:59
     * @Description: 根据id修改单个用信息
     **/
    @RequestMapping(value = "user/update/{id}")
    public MsgPack getUserUpdateById(@PathVariable String id,@RequestBody TSysUser user) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getUserUpdateById(id,user);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:01
     * @Description: 根据id修改单个用户的信息
     **/
    @RequestMapping(value = "role/update/{id}")
    public MsgPack getRoleUpdateById(@PathVariable String id,@RequestBody TSysRole role) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getRoleUpdateById(id,role);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 10:42
     * @Description: 查询单个部门信息
     **/
    @RequestMapping(value = "org/info/{id}")
    public MsgPack getOrgInfoById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getOrgInfoById(id);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:25
     * @Description: 根据用户查询用户信息
     **/
    @RequestMapping(value = "user/info/{id}")
    public MsgPack getUserInfoById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getUserInfoById(id);
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:25
     * @Description: 根据id获得权限的信息
     **/
    @RequestMapping(value = "role/info/{id}")
    public MsgPack getRoleInfoById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= authorityManagerService.getRoleInfoById(id);
        return msgPack;
    }


}
