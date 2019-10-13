package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Dep;

/**
 * 部门 Action
 * @author Wilson
 */
public class DepAction extends BaseAction<Dep>{
    private IDepBiz depBiz;

    public void setDepBiz(IDepBiz depBiz) {
        this.depBiz = depBiz;
        super.setBaseBiz(this.depBiz);
    }


}
