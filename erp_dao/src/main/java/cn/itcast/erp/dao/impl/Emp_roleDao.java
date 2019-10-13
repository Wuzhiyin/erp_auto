package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IEmp_roleDao;
import cn.itcast.erp.entity.Emp_role;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工角色 数据访问类
 */
public class Emp_roleDao extends BaseDao<Emp_role> implements IEmp_roleDao{

    public DetachedCriteria getDetachedCriteria(Emp_role emp_role1,Emp_role emp_role2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Emp_role.class);
        if(null != emp_role1){
           
        }
        return dc;
    }

}
