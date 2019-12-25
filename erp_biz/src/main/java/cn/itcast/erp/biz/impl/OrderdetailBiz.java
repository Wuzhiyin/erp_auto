package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IOrderdetailBiz;
import cn.itcast.erp.dao.IOrderdetailDao;
import cn.itcast.erp.dao.IStoredetailDao;
import cn.itcast.erp.dao.IStoreoperDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.entity.Storedetail;
import cn.itcast.erp.entity.Storeoper;
import cn.itcast.erp.exception.ErpException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

 /**
 * 订单明细 业务逻辑层
 * @author Wilson
 */
public class OrderdetailBiz extends BaseBiz<Orderdetail> implements IOrderdetailBiz{
    private IOrderdetailDao orderdetailDao;

    public void setOrderdetailDao(IOrderdetailDao orderdetailDao) {
        this.orderdetailDao = orderdetailDao;
        super.setBaseDao(this.orderdetailDao);
    }
     /** 商品仓库库存dao*/
     private IStoredetailDao storedetailDao;

     public void setStoredetailDao(IStoredetailDao storedetailDao) {
         this.storedetailDao = storedetailDao;
     }

     /** 商品仓库库存dao*/
     private IStoreoperDao storeoperDao;

     public void setStoreoperDao(IStoreoperDao storeoperDao) {
         this.storeoperDao = storeoperDao;
     }

     /**
      * 采购 入库 业务
      * @param uuid 明细编号
      * @param storeUuid 仓库编号
      * @param empUuid 库管员编号
      */
     public void doInStore(Long uuid, Long storeUuid, Long empUuid) {
        //第一步:更新的商品明细
         Orderdetail orderdetail = this.orderdetailDao.get(uuid);
         //1.检查是否已经入库了,不能重复入库,只有未入库的明细才能进行入库操作
         if (!Orderdetail.STATE_NOT_IN.equals(orderdetail.getState())){
             throw new ErpException("该明细已经入库了!");
         }
         //2.状态为已入库
         orderdetail.setState(Orderdetail.STATE_IN);
         //3.入库操作员
         orderdetail.setEnder(empUuid);
         //4.入到哪个仓库
         orderdetail.setStoreuuid(storeUuid);
         //5.入库时间
         orderdetail.setEndtime(Calendar.getInstance().getTime());

         //第二步:更新商品仓库库存
         //1. 根据商品编辑和仓库编号,查询是否已经存在库存记录
         // 构建查询条件
         Storedetail storeDetail = new Storedetail();

         storeDetail.setGoodsuuid(orderdetail.getGoodsuuid());
         storeDetail.setStoreuuid(orderdetail.getStoreuuid());
         List<Storedetail> storeList = storedetailDao.getList(storeDetail,null,null,0,100);
         //2. 判断是否存在库存信息
         if (storeList.size()>0) {
             long num = 0;
             if (storeList.get(0).getNum() != null) {
                 num = storeList.get(0).getNum().longValue();
             }
             //如果存在,则更新数量
             storeList.get(0).setNum(num + orderdetail.getNum());
         }else {
             //如果不存在,则增加库存信息
             storedetailDao.add(storeDetail);
         }
        //第三步:增加商品仓库库存更新记录
         Storeoper operLog = new Storeoper();
         //1. 设置操作人
         operLog.setEmpuuid(empUuid);
         //2. 入库哪个商品
         operLog.setGoodsuuid(orderdetail.getGoodsuuid());
         //3. 入库的数量
         operLog.setNum(orderdetail.getNum());
         //4. 入库时间
         operLog.setOpertime(orderdetail.getEndtime());
         //5.入在哪个仓库
         operLog.setStoreuuid(storeUuid);
         //6. 操作类型为入库
         operLog.setType(Storeoper.TYPE_IN);
         storeoperDao.add(operLog);

         //第四步:是否需要更新订单的状态的判断
         //1. 获取明细对应的订单信息
         Orders orders= orderdetail.getOrders();
         //2. 统计该订单所有state=0 的明细个数,看是否还存在 没有入库的明细
         // 构建查询条件
         Orderdetail countParam = new Orderdetail();
         countParam.setState(Orderdetail.STATE_NOT_IN);
         countParam.setOrders(orders);
         Long count = orderdetailDao.getCount(countParam,null,null);
         //3.count=0表示:所有的明细都已经入库了.这时要更新订单的状态,入库完成时间,入库的操作员
         if (count == 0) {
             //更新订单状态
             orders.setState(Orders.STATE_END);
             //设置操作人
             orders.setEnder(empUuid);
             //设置操作时间
             orders.setEndtime(orderdetail.getEndtime());

         }

     }
     /**
      * 销售出库操作
      * @param empuuid
      * @param uuid
      * @param storeuuid
      */
     public void doOutStore(Long empuuid, Long uuid, Long storeuuid){
         //获取订单明细
         Orderdetail orderDetail = orderdetailDao.get(uuid);
         if(!"0".equals(orderDetail.getState())){
             throw new ErpException("亲！该明细已经出库了，不能重复出库哦!");
         }
         //更新订单明细
         orderDetail.setEnder(empuuid);
         orderDetail.setEndtime(new Date());
         orderDetail.setState("1");
         orderDetail.setStoreuuid(storeuuid);

         //查询库存
         Storedetail storeDetail = new Storedetail();
         storeDetail.setGoodsuuid(orderDetail.getGoodsuuid());
         storeDetail.setStoreuuid(storeuuid);
         List<Storedetail> storedetailList = storedetailDao.getList(storeDetail, null, null,0,100);

         //商品仓库库存数量
         long num = -1l;
         //如果存在库存，检查库存是否足够
         if(null != storedetailList && storedetailList.size() > 0){
             storeDetail = storedetailList.get(0);
             num = storeDetail.getNum().longValue() - orderDetail.getNum().longValue();
         }
         if(num > 0){
             //库存充足，则更新库存数量
             storeDetail.setNum(num);
         }else{
             //库存不足，则提示用户
             throw new ErpException("库存不足!");
         }

         //添加库存变更操作记录
         Storeoper log = new Storeoper();
         log.setEmpuuid(empuuid);
         log.setGoodsuuid(orderDetail.getGoodsuuid());
         log.setNum(orderDetail.getNum());
         log.setOpertime(orderDetail.getEndtime());
         log.setStoreuuid(storeuuid);
         log.setType("2");
         storeoperDao.add(log);

         //检查是否订单下的所有明细都已经出库
         Orderdetail queryParam = new Orderdetail();
         Orders orders = orderDetail.getOrders();
         queryParam.setOrders(orders);
         queryParam.setState("0");
         Long cnt = orderdetailDao.getCount(queryParam, null, null);
         if(cnt == 0){
             //所有明细都已经出库，则更新订单状态为已出库
             orders.setState("1");
             orders.setEnder(empuuid);
             orders.setEndtime(orderDetail.getEndtime());
         }
     }

 }
