package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IReturnorderdetailBiz;
import cn.itcast.erp.dao.IReturnorderdetailDao;
import cn.itcast.erp.entity.Returnorderdetail;

import java.util.List;

 /**
 * 退货订单明细 业务逻辑层
 * @author Wilson
 */
public class ReturnorderdetailBiz extends BaseBiz<Returnorderdetail> implements IReturnorderdetailBiz{
    private IReturnorderdetailDao returnorderdetailDao;

    public void setReturnorderdetailDao(IReturnorderdetailDao returnorderdetailDao) {
        this.returnorderdetailDao = returnorderdetailDao;
        super.setBaseDao(this.returnorderdetailDao);
    }
}
