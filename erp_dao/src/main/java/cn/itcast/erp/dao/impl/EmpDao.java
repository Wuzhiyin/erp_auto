package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.entity.Emp;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工 数据访问类
 */
public class EmpDao extends BaseDao<Emp> implements IEmpDao{

    public DetachedCriteria getDetachedCriteria(Emp emp1,Emp emp2,Object param){
        DetachedCriteria dc =DetachedCriteria.forClass(Emp.class);
        if(null != emp1){
           
        }
        return dc;
    }

}
