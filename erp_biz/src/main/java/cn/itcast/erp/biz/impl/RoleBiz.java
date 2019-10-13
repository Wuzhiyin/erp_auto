package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IRoleBiz;
import cn.itcast.erp.dao.IRoleDao;
import cn.itcast.erp.entity.Role;

import java.util.List;

 /**
 * 角色 业务逻辑层
 * @author Wilson
 */
public class RoleBiz extends BaseBiz<Role> implements IRoleBiz{
    private IRoleDao roleDao;

    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
        super.setBaseDao(this.roleDao);
    }
}
