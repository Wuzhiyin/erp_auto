package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IMenuDao;
import cn.itcast.erp.entity.Menu;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 菜单 数据访问类
 */
public class MenuDao extends BaseDao<Menu> implements IMenuDao{

    public DetachedCriteria getDetachedCriteria(Menu menu1,Menu menu2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Menu.class);
        if(null != menu1){
           
        }
        return dc;
    }

}
