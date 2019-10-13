package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IStoreoperBiz;
import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;

import java.util.List;

 /**
 * 仓库操作记录 业务逻辑层
 * @author Wilson
 */
public class StoreoperBiz extends BaseBiz<Storeoper> implements IStoreoperBiz{
    private IStoreoperDao storeoperDao;

    public void setStoreoperDao(IStoreoperDao storeoperDao) {
        this.storeoperDao = storeoperDao;
        super.setBaseDao(this.storeoperDao);
    }
}
