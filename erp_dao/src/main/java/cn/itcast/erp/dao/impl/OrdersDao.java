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
           //根据订单类型查询
            if (null != orders1.getType() && orders1.getType().trim().length()>0){
                dc.add(Restrictions.eq("type",orders1.getType()));
            }
            //根据订单状态查询
            if (null != orders1.getState() && orders1.getState().trim().length()>0){
                dc.add(Restrictions.eq("state",orders1.getState()));
            }

            //查询我的订单
            if (orders1.getCreater() != null) {
                dc.add(Restrictions.eq("creater",orders1.getCreater()));
            }
        }

        return dc;
    }

}
