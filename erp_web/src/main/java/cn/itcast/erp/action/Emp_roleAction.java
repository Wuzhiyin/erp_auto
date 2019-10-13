package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Emp_role;

/**
 * 员工角色 Action
 * @author Wilson
 */
public class Emp_roleAction extends BaseAction<Emp_role>{
    private IEmp_roleBiz emp_roleBiz;

    public void setEmp_roleBiz(IEmp_roleBiz emp_roleBiz) {
        this.emp_roleBiz = emp_roleBiz;
        super.setBaseBiz(this.emp_roleBiz);
    }


}
