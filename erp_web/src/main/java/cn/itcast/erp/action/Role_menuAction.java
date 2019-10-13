package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Role_menu;

/**
 * 角色菜单 Action
 * @author Wilson
 */
public class Role_menuAction extends BaseAction<Role_menu>{
    private IRole_menuBiz role_menuBiz;

    public void setRole_menuBiz(IRole_menuBiz role_menuBiz) {
        this.role_menuBiz = role_menuBiz;
        super.setBaseBiz(this.role_menuBiz);
    }


}
