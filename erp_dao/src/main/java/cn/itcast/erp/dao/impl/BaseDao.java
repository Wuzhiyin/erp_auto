package cn.itcast.erp.dao.impl;

import cn.itcast.erp.dao.IBaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Wilson
 */
@SuppressWarnings("unchecked")
public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
    private Class<T> entityClass;
    public BaseDao() {
        //通过子类来获取父类
        Type baseDaoClass = getClass().getGenericSuperclass();
        //转成参数化类型
        ParameterizedType pType = (ParameterizedType) baseDaoClass;
        //获取参数类型的数组
        Type[] types = pType.getActualTypeArguments();
        //得到了泛型里的T的类型
        Type targetType = types[0];
        //转成class类型
        entityClass = (Class <T>) targetType;
    }

    /**
     * 查询全部列表
     * @return
     */
    public List<T> getList() {
        return (List<T>) getHibernateTemplate().find("FROM "+entityClass.getName());
    }

    /**
     * 条件查询
     * @param t1
     * @return
     */
    public List<T> getList(T t1,T t2,Object param,int firstResult,int maxResults) {
        DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
        return (List<T>) this.getHibernateTemplate().findByCriteria(dc,firstResult,maxResults);
    }
    /**
     * 记录条件查询的总记录数
     * @param t1
     * @return
     */
    public long getCount(T t1,T t2,Object param) {
        DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
        return list.get(0);
    }
    /**
     * 新增
     * @param t
     */
    public void add(T t){
        this.getHibernateTemplate().save(t);
    }
    /**
     * 删除
     */
    public void delete(Long uuid) {
        //让对象进入持久化状态
        T t = this.getHibernateTemplate().get(entityClass, uuid);
        //删除持久化状态
        this.getHibernateTemplate().delete(t);
    }

    /**
     * 通过编号查询对象
     * @param uuid
     * @return
     */
    public T get(Long uuid){
        return getHibernateTemplate().get(entityClass, uuid);
    }

    /**
     * 通过字符串主键获取对象
     * @param uuid
     * @return
     */
    public T get(String uuid){
        return getHibernateTemplate().get(entityClass, uuid);
    }
    /**
     * 更新
     */
    public void update(T t){
        this.getHibernateTemplate().update(t);
    }

    /**
     * 由子类实现
     * @return
     */
    public DetachedCriteria getDetachedCriteria(T t1,T t2,Object param){
        return null;
    }
}
