package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.ISupplierBiz;
import cn.itcast.erp.dao.ISupplierDao;
import cn.itcast.erp.entity.Supplier;

import java.util.List;

 /**
 * 供应商 业务逻辑层
 * @author Wilson
 */
public class SupplierBiz extends BaseBiz<Supplier> implements ISupplierBiz{
    private ISupplierDao supplierDao;

    public void setSupplierDao(ISupplierDao supplierDao) {
        this.supplierDao = supplierDao;
        super.setBaseDao(this.supplierDao);
    }
}
