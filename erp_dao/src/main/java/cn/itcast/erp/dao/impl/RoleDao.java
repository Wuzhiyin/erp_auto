package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IRoleDao;
import cn.itcast.erp.entity.Role;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 角色 数据访问类
 */
public class RoleDao extends BaseDao<Role> implements IRoleDao{

    public DetachedCriteria getDetachedCriteria(Role role1,Role role2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Role.class);
        if(null != role1){
           
        }
        return dc;
    }

}
