package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IReturnorderdetailDao;
import cn.itcast.erp.entity.Returnorderdetail;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 退货订单明细 数据访问类
 */
public class ReturnorderdetailDao extends BaseDao<Returnorderdetail> implements IReturnorderdetailDao{

    public DetachedCriteria getDetachedCriteria(Returnorderdetail returnorderdetail1,Returnorderdetail returnorderdetail2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Returnorderdetail.class);
        if(null != returnorderdetail1){
           
        }
        return dc;
    }

}
