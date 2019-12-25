package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IStoreDao;
import cn.itcast.erp.entity.Store;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 仓库 数据访问类
 */
public class StoreDao extends BaseDao<Store> implements IStoreDao{

    public DetachedCriteria getDetachedCriteria(Store store1,Store store2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Store.class);
        if(null != store1){
            if (store1.getName() != null && store1.getName().trim().length()>0) {
                dc.add(Restrictions.like("name",store1.getName(),MatchMode.ANYWHERE));
            }
            //根据员工编辑查询
            if (store1.getEmpuuid() != null) {
                dc.add(Restrictions.eq("empuuid",store1.getEmpuuid()));
            }
        }
        return dc;
    }

}
