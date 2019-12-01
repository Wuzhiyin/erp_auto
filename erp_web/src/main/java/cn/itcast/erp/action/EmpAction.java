package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.exception.ErpException;

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

    private String newPwd;//新密码
    private String oldPwd;//旧密码

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public void updatePwd(){
        Emp loginUser = getLoginUser();
        if (null == loginUser){
            ajaxReturn(false,"亲,您还没有登录");
            return;
        }
        try {
            this.empBiz.updatePwd(loginUser.getUuid(),oldPwd,newPwd);
            ajaxReturn(true,"密码修改成功");
        } catch (ErpException e) {
            e.printStackTrace();
            ajaxReturn(false,e.getMessage());
        } catch (Exception e1){
            e1.printStackTrace();
            ajaxReturn(false,"修改密码失败");
        }
    }

    public void updatePwd_reset(){
        try {
            //调用业务重置密码
            this.empBiz.updatePwd_reset(getId(),newPwd);
            ajaxReturn(true,"重置密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxReturn(false,"重置密码失败");
        }

    }
}
