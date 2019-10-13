package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Store;

/**
 * 仓库 Action
 * @author Wilson
 */
public class StoreAction extends BaseAction<Store>{
    private IStoreBiz storeBiz;

    public void setStoreBiz(IStoreBiz storeBiz) {
        this.storeBiz = storeBiz;
        super.setBaseBiz(this.storeBiz);
    }


}
