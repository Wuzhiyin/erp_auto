package cn.itcast.erp.biz;

import java.util.List;

/**
 * Created by Wilson
 */
public interface IBaseBiz<T> {

    /**
     * 查询全部列表
     * @return
     */
    public List<T> getList();

    /**
     * 条件查询
     * @param t1
     * @return
     */
    List<T> getList(T t1,T t2,Object param,int firstResult,int maxResults);

    long getCount(T t1,T t2,Object param);
    /**
     * 新增
     * @param t
     */
    public void add(T t);

    /**
     * 删除
     */
    void delete(Long uuid);
    /**
     * 通过编号查询对象
     * @param uuid
     * @return
     */
    T get(Long uuid);


    /**
     * 更新
     */
    void update(T t);
}
