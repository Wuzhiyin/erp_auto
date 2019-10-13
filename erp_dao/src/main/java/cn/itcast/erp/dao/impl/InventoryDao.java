package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IInventoryDao;
import cn.itcast.erp.entity.Inventory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 盘盈盘亏 数据访问类
 */
public class InventoryDao extends BaseDao<Inventory> implements IInventoryDao{

    public DetachedCriteria getDetachedCriteria(Inventory inventory1,Inventory inventory2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Inventory.class);
        if(null != inventory1){
           
        }
        return dc;
    }

}
