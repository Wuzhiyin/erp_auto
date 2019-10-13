package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IBaseBiz;

import cn.itcast.erp.dao.IBaseDao;


import java.util.List;

/**
 * Created by Wilson
 */
public class BaseBiz<T> implements IBaseBiz<T> {
    /** 数据访问注入*/
    private IBaseDao<T> baseDao;

    public void setBaseDao(IBaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * 查询全部列表
     * @return
     */
    public List<T> getList() {
        return baseDao.getList();
    }

    /**
     * 条件查询
     * @param t1
     * @return
     */
    public List<T> getList(T t1,T t2,Object param,int firstResult,int maxResults) {
        return baseDao.getList(t1, t2, param, firstResult, maxResults);
    }

    public long getCount(T t1,T t2,Object param) {
        return baseDao.getCount(t1, t2, param);
    }

    public void add(T t) {
        baseDao.add(t);
    }

    /**
     * 删除
     */
    public void delete(Long uuid){
        baseDao.delete(uuid);
    }
    /**
     * 通过编号查询对象
     * @param uuid
     * @return
     */
    public T get(Long uuid){
        return (T) baseDao.get(uuid);
    }

    /**
     * 更新
     */
    public void update(T t){
        baseDao.update(t);
    }
}
