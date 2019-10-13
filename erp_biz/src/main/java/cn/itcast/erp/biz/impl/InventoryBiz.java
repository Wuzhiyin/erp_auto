package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IInventoryBiz;
import cn.itcast.erp.dao.IInventoryDao;
import cn.itcast.erp.entity.Inventory;

import java.util.List;

 /**
 * 盘盈盘亏 业务逻辑层
 * @author Wilson
 */
public class InventoryBiz extends BaseBiz<Inventory> implements IInventoryBiz{
    private IInventoryDao inventoryDao;

    public void setInventoryDao(IInventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
        super.setBaseDao(this.inventoryDao);
    }
}
