package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Returnorders;

/**
 * 退货订单 Action
 * @author Wilson
 */
public class ReturnordersAction extends BaseAction<Returnorders>{
    private IReturnordersBiz returnordersBiz;

    public void setReturnordersBiz(IReturnordersBiz returnordersBiz) {
        this.returnordersBiz = returnordersBiz;
        super.setBaseBiz(this.returnordersBiz);
    }


}
