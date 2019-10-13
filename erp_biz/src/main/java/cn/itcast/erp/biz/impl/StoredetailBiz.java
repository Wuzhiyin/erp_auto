package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IStoredetailBiz;
import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storedetail;

import java.util.List;

 /**
 * 仓库库存 业务逻辑层
 * @author Wilson
 */
public class StoredetailBiz extends BaseBiz<Storedetail> implements IStoredetailBiz{
    private IStoredetailDao storedetailDao;

    public void setStoredetailDao(IStoredetailDao storedetailDao) {
        this.storedetailDao = storedetailDao;
        super.setBaseDao(this.storedetailDao);
    }
}
