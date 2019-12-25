package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IOrderdetailDao;
import cn.itcast.erp.entity.Orderdetail;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 订单明细 数据访问类
 */
public class OrderdetailDao extends BaseDao<Orderdetail> implements IOrderdetailDao{

    public DetachedCriteria getDetachedCriteria(Orderdetail orderdetail1,Orderdetail orderdetail2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Orderdetail.class);
        if(null != orderdetail1){
            if (orderdetail1.getGoodsname() != null && orderdetail1.getGoodsname().trim().length()>0) {
                dc.add(Restrictions.like("goodsname",orderdetail1.getGoodsname(),MatchMode.ANYWHERE));
            }
            //根据明细状态    
            if (orderdetail1.getState() != null && orderdetail1.getState().trim().length()>0) {
                dc.add(Restrictions.eq("state",orderdetail1.getState()));
            }
            //根据订单查询
            if (orderdetail1.getOrders() != null && orderdetail1.getOrders().getUuid() != null) {
                dc.add(Restrictions.eq("orders",orderdetail1.getOrders()));
            }
        }
        return dc;
    }

}
