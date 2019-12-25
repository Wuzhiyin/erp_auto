package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Supplier;

/**
 * 供应商 Action
 * @author Wilson
 */
public class SupplierAction extends BaseAction<Supplier>{
    private ISupplierBiz supplierBiz;
    /**remote传过来的参数名称*/
    private String q;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public void setSupplierBiz(ISupplierBiz supplierBiz) {
        this.supplierBiz = supplierBiz;
        super.setBaseBiz(this.supplierBiz);
    }

    /**
     * 自动补全
     */
    @Override
    public void list() {
        if (getT1() == null) {
            setT1(new Supplier());
        }
        getT1().setName(q);
        super.list();
    }
}
