package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 仓库操作记录 数据访问类
 */
public class StoreoperDao extends BaseDao<Storeoper> implements IStoreoperDao{

    public DetachedCriteria getDetachedCriteria(Storeoper storeoper1,Storeoper storeoper2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Storeoper.class);
        if(null != storeoper1){
           
        }
        return dc;
    }

}
