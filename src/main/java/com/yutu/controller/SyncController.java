package com.yutu.controller;

import com.yutu.entity.ConfigConstants;
import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TCodConfig;
import com.yutu.entity.table.TLogOperation;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.entity.table.TSysUser;
import com.yutu.mapper.mysql.TCodConfigMapper;
import com.yutu.service.ILogManagerService;
import com.yutu.service.IOrganizationManagerService;
import com.yutu.service.IUserManagerService;
import com.yutu.util.RestClientUtils;
import com.yutu.util.SessionUserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: zhaobc
 * @Date: 2020/1/1 12:31
 * @Description:给子系统同步数据用
 */
@RestController
@RequestMapping(value = "sync")
public class SyncController {
    @Resource
    private IUserManagerService userManagerService;
    @Resource
    private IOrganizationManagerService organizationManagerService;
    @Resource
    private TCodConfigMapper tCodConfigMapper;
    @Resource
    private SessionUserManager sessionUserManager;
    @Resource
    private ILogManagerService logManagerService;

    /**
     * @Author: zhaobc
     * @Date: 2020/1/1 12:32
     * @Description: 同步用户接口
     **/
    @RequestMapping(value = "user")
    public MsgPack syncUser(String appkey) {
        MsgPack msgPack = userManagerService.getUserAll();
        if (msgPack.getStatus() == 1) {
            List<TSysUser> listSysUser = (List<TSysUser>) msgPack.getData();
            List<TCodConfig> listCinfig = tCodConfigMapper.getConfigListById(ConfigConstants.Auth_AppKey, appkey);
            if (listCinfig.size() > 0) {
                String authUrl = listCinfig.get(0).getRemarks();
                for (TSysUser tSysUser : listSysUser) {
                    Map<String, Object> userMap = new HashMap<>();
                    userMap.put("uuid", UUID.randomUUID().toString());
                    userMap.put("userCode", tSysUser.getUserCode());
                    userMap.put("userAccount", tSysUser.getUserAccount());
                    userMap.put("userName", tSysUser.getUserName());
                    userMap.put("userSex", tSysUser.getUserSex());
                    userMap.put("userTitle", tSysUser.getUserTitle());
                    userMap.put("userPhone", tSysUser.getUserPhone());
                    userMap.put("userEmail", tSysUser.getUserEmail());
                    userMap.put("userStatus", tSysUser.getUserStatus());
                    userMap.put("orderBy", tSysUser.getOrderBy());
                    userMap.put("deleteStatus", tSysUser.getDeleteStatus());
                    userMap.put("remarks", tSysUser.getRemarks());
                    MsgPack msgPackLog = RestClientUtils.post(authUrl, "/sync/user/add", userMap, MsgPack.class);

                    //计入日志
                    TLogOperation operation = new TLogOperation();
                    SessionUser sessionUser = sessionUserManager.getSessionUser();
                    operation.setUuid(UUID.randomUUID().toString());
                    operation.setOperateContent(appkey + "子系统同步数据" + msgPackLog.getMsg());
                    operation.setOperateDatetime(new Date());
                    operation.setAppkey(appkey);
                    operation.setLogType("数据同步");
                    operation.setOperateDb("yutuCloud");
                    operation.setOperateDt("t_sys_user");
                    operation.setOperatePerson(sessionUser.getUserAccount());
                    operation.setToken(sessionUser.getToken());
                    operation.setOperateType("update");
                    logManagerService.insertOperationLog(operation);
                }
            }
        }
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/1 12:32
     * @Description: 同步部门接口
     **/
    @RequestMapping(value = "organize")
    public MsgPack syncOrganization(String appkey) {
        MsgPack msgPack = organizationManagerService.getOrganizationAll();
        if (msgPack.getStatus() == 1) {
            List<TSysOrganization> listOrg = (List<TSysOrganization>) msgPack.getData();
            List<TCodConfig> listCinfig = tCodConfigMapper.getConfigListById(ConfigConstants.Auth_AppKey, appkey);
            if (listCinfig.size() > 0) {
                String authUrl = listCinfig.get(0).getRemarks();
                for (TSysOrganization organization : listOrg) {
                    Map<String, Object> orgMap = new HashMap<>();
                    orgMap.put("uuid", UUID.randomUUID().toString());
                    orgMap.put("orgParent", organization.getOrgParent());
                    orgMap.put("orgCode", organization.getOrgCode());
                    orgMap.put("orgName", organization.getOrgName());
                    orgMap.put("orgPhone", organization.getOrgPhone());
                    orgMap.put("orgAddress", organization.getOrgAddress());
                    orgMap.put("orgManager", organization.getOrgManager());
                    orgMap.put("orgStatus", organization.getOrgStatus());
                    orgMap.put("orderBy", organization.getOrderBy());
                    orgMap.put("deleteStatus", organization.getDeleteStatus());
                    orgMap.put("remarks", organization.getRemarks());
                    MsgPack msgPackLog = RestClientUtils.post(authUrl, "/sync/organize/add", orgMap, MsgPack.class);

                    //计入日志
                    TLogOperation operation = new TLogOperation();
                    SessionUser sessionUser = sessionUserManager.getSessionUser();
                    operation.setUuid(UUID.randomUUID().toString());
                    operation.setOperateContent(appkey + "子系统同步数据" + msgPackLog.getMsg());
                    operation.setOperateDatetime(new Date());
                    operation.setAppkey(appkey);
                    operation.setLogType("数据同步");
                    operation.setOperateDb("yutuCloud");
                    operation.setOperateDt("t_sys_organization");
                    operation.setOperatePerson(sessionUser.getUserAccount());
                    operation.setToken(sessionUser.getToken());
                    operation.setOperateType("update");
                    logManagerService.insertOperationLog(operation);
                }
            }
        }
        return msgPack;
    }

}
