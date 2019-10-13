package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Storedetail;

/**
 * 仓库库存 Action
 * @author Wilson
 */
public class StoredetailAction extends BaseAction<Storedetail>{
    private IStoredetailBiz storedetailBiz;

    public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
        this.storedetailBiz = storedetailBiz;
        super.setBaseBiz(this.storedetailBiz);
    }


}
