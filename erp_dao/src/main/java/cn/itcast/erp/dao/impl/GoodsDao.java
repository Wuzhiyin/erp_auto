package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.entity.Goods;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 商品 数据访问类
 */
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao{

    public DetachedCriteria getDetachedCriteria(Goods goods1,Goods goods2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Goods.class);
        if(null != goods1){
           
        }
        return dc;
    }

}
