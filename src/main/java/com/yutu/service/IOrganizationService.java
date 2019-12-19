package com.yutu.service;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;

/**
* @Author: zhaobc
* @Date: 2019-12-19 19:01
* @Description: 组织服务层
**/
public interface IOrganizationService {

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 19:02
    * @Description: 新增部门
    **/
    MsgPack insertOrganization(TSysOrganization organization);

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 19:02
     * @Description: 修改部门
     **/
    MsgPack updateOrganization(TSysOrganization organization);


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 19:02
     * @Description: 删除部门
     **/
    MsgPack delteOrganization(String orgId);
}
