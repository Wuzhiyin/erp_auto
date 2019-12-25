package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.entity.Storedetail;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 仓库库存 数据访问类
 */
public class StoredetailDao extends BaseDao<Storedetail> implements IStoredetailDao{

    public DetachedCriteria getDetachedCriteria(Storedetail storedetail1,Storedetail storedetail2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Storedetail.class);
        if(null != storedetail1){
           //根据商品编辑查询
            if (storedetail1.getGoodsuuid() != null) {
                dc.add(Restrictions.eq("goodsuuid",storedetail1.getGoodsuuid()));
            }
            //根据仓库去查
            if (storedetail1.getStoreuuid() != null) {
                dc.add(Restrictions.eq("storeuuid",storedetail1.getStoreuuid()));
            }
        }
        return dc;
    }

}
