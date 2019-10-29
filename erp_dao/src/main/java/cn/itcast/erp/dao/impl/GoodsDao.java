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
           if (null != goods1.getName() && goods1.getName().trim().length()>0){
               dc.add(Restrictions.like("name",goods1.getName(), MatchMode.ANYWHERE));
           }
            if (null != goods1.getOrigin() && goods1.getOrigin().trim().length()>0){
                dc.add(Restrictions.like("origin",goods1.getOrigin(), MatchMode.ANYWHERE));
            }
            if (null != goods1.getProducer() && goods1.getProducer().trim().length()>0){
                dc.add(Restrictions.like("producer",goods1.getProducer(), MatchMode.ANYWHERE));
            }
            if (null != goods1.getUnit() && goods1.getUnit().trim().length()>0){
                dc.add(Restrictions.like("unit",goods1.getUnit(), MatchMode.ANYWHERE));
            }
            //根据商品类型查询
            if (null != goods1.getGoodstype() && goods1.getGoodstype().getName()!=null){
                dc.add(Restrictions.eq("goodstype",goods1.getGoodstype()));
            }

        }

        return dc;
    }

}
