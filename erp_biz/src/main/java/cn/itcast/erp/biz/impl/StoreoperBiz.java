package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IStoreoperBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.dao.IStoreDao;
import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Storeoper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库操作记录 业务逻辑层
 * @author Wilson
 */
public class StoreoperBiz extends BaseBiz<Storeoper> implements IStoreoperBiz{
    private IStoreoperDao storeoperDao;
    private IGoodsDao goodsDao;
    private IStoreDao storeDao;
    private IEmpDao empDao;
    public void setStoreoperDao(IStoreoperDao storeoperDao) {
        this.storeoperDao = storeoperDao;
        super.setBaseDao(this.storeoperDao);
    }

     public void setGoodsDao(IGoodsDao goodsDao) {
         this.goodsDao = goodsDao;
     }

     public void setStoreDao(IStoreDao storeDao) {
         this.storeDao = storeDao;
     }

     public IEmpDao getEmpDao() {
         return empDao;
     }

     public void setEmpDao(IEmpDao empDao) {
         this.empDao = empDao;
     }

     @Override
     public List<Storeoper> getList(Storeoper t1, Storeoper t2, Object param, int firstResult, int maxResults) {
         List<Storeoper> logList = super.getList(t1, t2, param, firstResult, maxResults);
         //缓存员工名称
         Map<Long,String> empNameMap = new HashMap<Long, String>();
         //缓存仓库名称
         Map<Long,String> storeNameMap = new HashMap<Long, String>();
         //缓存商品名称
         Map<Long,String> goodsNameMap = new HashMap<Long, String>();
         for (Storeoper log: logList){
             log.setEmpName(getEmpName(log.getEmpuuid(),empNameMap));
             log.setGoodsName(getGoodsName(log.getGoodsuuid(),goodsNameMap));
             log.setStoreName(getStoreName(log.getStoreuuid(),storeNameMap));
         }
         return logList;
     }
    private String getEmpName(Long uuid, Map<Long,String> empNameMap){
        if (null==uuid){
            return null;
        }
        String empName = empNameMap.get(uuid);
        if (empName == null) {
            empName = empDao.get(uuid).getName();
            empNameMap.put(uuid,empName);
        }
        return empName;
    }
    private String getGoodsName(Long uuid, Map<Long,String> goodsNameMap){
        if (null==uuid){
            return null;
        }
        String goodsName = goodsNameMap.get(uuid);
        if (goodsName == null) {
            goodsName = goodsDao.get(uuid).getName();
            goodsNameMap.put(uuid,goodsName);
        }
        return goodsName;
    }
    private String getStoreName(Long uuid, Map<Long,String> storeNameMap){
        if (null==uuid){
            return null;
        }
        String storeName = storeNameMap.get(uuid);
        if (storeName == null) {
            storeName = storeDao.get(uuid).getName();
            storeNameMap.put(uuid,storeName);
        }
        return storeName;
    }
 }
