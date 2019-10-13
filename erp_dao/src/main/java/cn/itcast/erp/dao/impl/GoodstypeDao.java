package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IGoodstypeDao;
import cn.itcast.erp.entity.Goodstype;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 商品分类 数据访问类
 */
public class GoodstypeDao extends BaseDao<Goodstype> implements IGoodstypeDao{

    public DetachedCriteria getDetachedCriteria(Goodstype goodstype1,Goodstype goodstype2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Goodstype.class);
        if(null != goodstype1){
           
        }
        return dc;
    }

}
