package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IRole_menuBiz;
import cn.itcast.erp.dao.IRole_menuDao;
import cn.itcast.erp.entity.Role_menu;

import java.util.List;

 /**
 * 角色菜单 业务逻辑层
 * @author Wilson
 */
public class Role_menuBiz extends BaseBiz<Role_menu> implements IRole_menuBiz{
    private IRole_menuDao role_menuDao;

    public void setRole_menuDao(IRole_menuDao role_menuDao) {
        this.role_menuDao = role_menuDao;
        super.setBaseDao(this.role_menuDao);
    }
}
