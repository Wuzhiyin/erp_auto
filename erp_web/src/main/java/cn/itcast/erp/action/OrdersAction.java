package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Orders;

/**
 * 订单 Action
 * @author Wilson
 */
public class OrdersAction extends BaseAction<Orders>{
    private IOrdersBiz ordersBiz;

    public void setOrdersBiz(IOrdersBiz ordersBiz) {
        this.ordersBiz = ordersBiz;
        super.setBaseBiz(this.ordersBiz);
    }


}
