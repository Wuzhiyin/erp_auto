package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IDepDao;
import cn.itcast.erp.entity.Dep;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 部门 数据访问类
 */
public class DepDao extends BaseDao<Dep> implements IDepDao{

    public DetachedCriteria getDetachedCriteria(Dep dep1,Dep dep2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Dep.class);
        if(null != dep1){
           
        }
        return dc;
    }

}
