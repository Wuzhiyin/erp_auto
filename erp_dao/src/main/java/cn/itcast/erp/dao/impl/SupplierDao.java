package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.ISupplierDao;
import cn.itcast.erp.entity.Supplier;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 供应商 数据访问类
 */
public class SupplierDao extends BaseDao<Supplier> implements ISupplierDao{

    public DetachedCriteria getDetachedCriteria(Supplier supplier1,Supplier supplier2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Supplier.class);
        if(null != supplier1){
           
        }
        return dc;
    }

}
