package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IRole_menuDao;
import cn.itcast.erp.entity.Role_menu;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 角色菜单 数据访问类
 */
public class Role_menuDao extends BaseDao<Role_menu> implements IRole_menuDao{

    public DetachedCriteria getDetachedCriteria(Role_menu role_menu1,Role_menu role_menu2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Role_menu.class);
        if(null != role_menu1){
           
        }
        return dc;
    }

}
