package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Role;

/**
 * 角色 Action
 * @author Wilson
 */
public class RoleAction extends BaseAction<Role>{
    private IRoleBiz roleBiz;

    public void setRoleBiz(IRoleBiz roleBiz) {
        this.roleBiz = roleBiz;
        super.setBaseBiz(this.roleBiz);
    }


}
