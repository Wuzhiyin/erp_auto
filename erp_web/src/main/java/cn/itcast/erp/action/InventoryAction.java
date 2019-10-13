package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Inventory;

/**
 * 盘盈盘亏 Action
 * @author Wilson
 */
public class InventoryAction extends BaseAction<Inventory>{
    private IInventoryBiz inventoryBiz;

    public void setInventoryBiz(IInventoryBiz inventoryBiz) {
        this.inventoryBiz = inventoryBiz;
        super.setBaseBiz(this.inventoryBiz);
    }


}
