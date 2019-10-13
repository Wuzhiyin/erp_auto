package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Emp;

/**
 * 员工 Action
 * @author Wilson
 */
public class EmpAction extends BaseAction<Emp>{
    private IEmpBiz empBiz;

    public void setEmpBiz(IEmpBiz empBiz) {
        this.empBiz = empBiz;
        super.setBaseBiz(this.empBiz);
    }


}
