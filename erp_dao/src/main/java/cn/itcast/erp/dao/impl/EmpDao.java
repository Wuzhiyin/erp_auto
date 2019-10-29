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
            //根据部门查询
           if (null != emp1.getDep() && null!= emp1.getDep().getUuid()){
               dc.add(Restrictions.eq("dep",emp1.getDep()));
           }
            //根据性别查询
            if (null != emp1.getGender()){
                dc.add(Restrictions.eq("gender",emp1.getGender()));
            }
            //根据出生年月日查询
            if (null != emp1.getBirthday()){
                dc.add(Restrictions.ge("birthday",emp1.getBirthday()));
            }

        }
        if (null != emp2){
            if (null != emp2.getBirthday()){
                dc.add(Restrictions.le("birthday",emp2.getBirthday()));
            }
        }
        return dc;
    }

}
