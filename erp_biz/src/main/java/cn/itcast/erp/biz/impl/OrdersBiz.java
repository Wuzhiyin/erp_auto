package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IOrdersBiz;
import cn.itcast.erp.dao.IOrdersDao;
import cn.itcast.erp.entity.Orders;

import java.util.List;

 /**
 * 订单 业务逻辑层
 * @author Wilson
 */
public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz{
    private IOrdersDao ordersDao;

    public void setOrdersDao(IOrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        super.setBaseDao(this.ordersDao);
    }
}
