package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IReturnordersDao;
import cn.itcast.erp.entity.Returnorders;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 退货订单 数据访问类
 */
public class ReturnordersDao extends BaseDao<Returnorders> implements IReturnordersDao{

    public DetachedCriteria getDetachedCriteria(Returnorders returnorders1,Returnorders returnorders2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Returnorders.class);
        if(null != returnorders1){
           
        }
        return dc;
    }

}
