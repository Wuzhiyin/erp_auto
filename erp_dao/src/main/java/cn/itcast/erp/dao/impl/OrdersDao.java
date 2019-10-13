package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IOrdersDao;
import cn.itcast.erp.entity.Orders;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 订单 数据访问类
 */
public class OrdersDao extends BaseDao<Orders> implements IOrdersDao{

    public DetachedCriteria getDetachedCriteria(Orders orders1,Orders orders2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Orders.class);
        if(null != orders1){
           
        }
        return dc;
    }

}
