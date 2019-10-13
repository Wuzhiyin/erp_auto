package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IReturnordersBiz;
import cn.itcast.erp.dao.IReturnordersDao;
import cn.itcast.erp.entity.Returnorders;

import java.util.List;

 /**
 * 退货订单 业务逻辑层
 * @author Wilson
 */
public class ReturnordersBiz extends BaseBiz<Returnorders> implements IReturnordersBiz{
    private IReturnordersDao returnordersDao;

    public void setReturnordersDao(IReturnordersDao returnordersDao) {
        this.returnordersDao = returnordersDao;
        super.setBaseDao(this.returnordersDao);
    }
}
