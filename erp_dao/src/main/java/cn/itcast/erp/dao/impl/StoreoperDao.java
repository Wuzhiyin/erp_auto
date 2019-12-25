package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.Calendar;
import java.util.List;

/**
 * 仓库操作记录 数据访问类
 */
public class StoreoperDao extends BaseDao<Storeoper> implements IStoreoperDao{

    public DetachedCriteria getDetachedCriteria(Storeoper storeoper1,Storeoper storeoper2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Storeoper.class);
        Calendar car = Calendar.getInstance();
        if(null != storeoper1){
           //操作类型
            if (storeoper1.getType() != null && storeoper1.getType().trim().length()>0) {
                dc.add(Restrictions.eq("type",storeoper1.getType()));
            }
            //操作员编号
            if (storeoper1.getEmpuuid() != null) {
                dc.add(Restrictions.eq("empuuid",storeoper1.getEmpuuid()));
            }
            //商品编号
            if (storeoper1.getGoodsuuid() != null) {
                dc.add(Restrictions.eq("goodsuuid",storeoper1.getGoodsuuid()));
            }
            //仓库编号
            if (storeoper1.getStoreuuid() != null) {
                dc.add(Restrictions.eq("storeuuid",storeoper1.getStoreuuid()));
            }
            //操作起始时间
            if (storeoper1.getOpertime() != null) {
                car.setTime(storeoper1.getOpertime());
                car.set(Calendar.HOUR,0);
                car.set(Calendar.MINUTE,0);
                car.set(Calendar.SECOND,0);
                car.set(Calendar.MILLISECOND,0);
                dc.add(Restrictions.ge("opertime",car.getTime()));
            }

        }
        if (storeoper2 != null) {
            //操作结束时间
            if (storeoper2.getOpertime() != null) {
                car.setTime(storeoper2.getOpertime());
                car.set(Calendar.HOUR,23);
                car.set(Calendar.MINUTE,59);
                car.set(Calendar.SECOND,59);
                car.set(Calendar.MILLISECOND,999);
                dc.add(Restrictions.le("opertime",car.getTime()));
            }
        }

        return dc;
    }

}
