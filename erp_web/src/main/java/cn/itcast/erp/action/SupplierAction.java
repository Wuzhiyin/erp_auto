package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Supplier;

/**
 * 供应商 Action
 * @author Wilson
 */
public class SupplierAction extends BaseAction<Supplier>{
    private ISupplierBiz supplierBiz;

    public void setSupplierBiz(ISupplierBiz supplierBiz) {
        this.supplierBiz = supplierBiz;
        super.setBaseBiz(this.supplierBiz);
    }


}
