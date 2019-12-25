package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.biz.IOrdersBiz;
import cn.itcast.erp.biz.ISupplierBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IOrdersDao;
import cn.itcast.erp.dao.ISupplierDao;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.exception.ErpException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单 业务逻辑层
 * @author Wilson
 */
public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz{
    private IOrdersDao ordersDao;
    private IEmpDao empDao;
    private ISupplierDao supplierDao;

     public IEmpDao getEmpDao() {
         return empDao;
     }

     public void setEmpDao(IEmpDao empDao) {
         this.empDao = empDao;
     }

     public ISupplierDao getSupplierDao() {
         return supplierDao;
     }

     public void setSupplierDao(ISupplierDao supplierDao) {
         this.supplierDao = supplierDao;
     }

     public void setOrdersDao(IOrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        super.setBaseDao(this.ordersDao);
    }

     /**
      * 新增订单
      * @param orders
      */
     @Override
     public void add(Orders orders) {
         //新增的采购订单状态都是未审核
         orders.setState(Orders.STATE_CREATE);
         //设置订单类型为采购
//         orders.setType(Orders.TYPE_IN);
         //设置订单的创建时间为当前服务器时间
         orders.setCreatetime(new Date());

         //计算总金额
         double total = 0;
         for (Orderdetail detail : orders.getOrderDetails()){
             //累计金额
             total+= detail.getMoney();
             //设置明细的状态为未入库
             detail.setState(Orderdetail.STATE_NOT_IN);
             //设置明细对应的订单,原因:orders采用级联更新,且外键交给明细来维护
             detail.setOrders(orders);
         }
         //设置总金额
         orders.setTotalmoney(total);
         //保存订单
         ordersDao.add(orders);

     }

     @Override
     public List<Orders> getList(Orders t1, Orders t2, Object param, int firstResult, int maxResults) {
         //获取分页结果
         List<Orders> ordersList = super.getList(t1,t2,param,firstResult,maxResults);
         //缓存员工名称,Key为员工编号,value为员工的姓名
         Map<Long,String> empNameMap = new HashMap<Long,String>();
         //缓存供应商名称,key为供应商编号,value为供应商名称
         Map<Long,String> supplierNameMap = new HashMap<Long,String>();
         for (Orders o:ordersList){
             //设置下单员名称
             o.setCreaterName(getEmpName(o.getCreater(),empNameMap));
             //设置审核员名称
             o.setCheckerName(getEmpName(o.getChecker(),empNameMap));
             //设置采购员名称
             o.setStarterName(getEmpName(o.getStarter(),empNameMap));
             //设置入库员名称
             o.setEnderName(getEmpName(o.getEnder(),empNameMap));
             //设置供应商名称
             o.setSupplierName(getSupplierName(o.getSupplieruuid(),supplierNameMap));

         }
         return super.getList(t1, t2, param, firstResult, maxResults);
     }

    /**
     * 根据员工编号获取员工名称
     * @param uuid 员工编号
     * @param empNameMap 缓存员工名称,Key为员工的编号,value为员工的姓名
     * @return
     */
     private String getEmpName(Long uuid,Map<Long,String> empNameMap){
         //如果员工编号为空,则返回空
         if (uuid == null) {
             return null;
         }
         //通过员工编号,尝试从缓存中获取员工名称
         String empName = empNameMap.get(uuid);
         if (empName == null) {
             //如果在缓存中没有找到,则调用dao查询后,获取的员工名称
             empName = empDao.get(uuid).getName();
             //按员工编号保存员工名称到缓存
             empNameMap.put(uuid,empName);
         }
         return empName;
     }
    /**
     * 根据供应商编号获取供应商名称
     * @param uuid 供应商编号
     * @param supplierNameMap 缓存供应商名称,Key为供应商的编号,value为供应商的名称
     * @return
     */
    private String getSupplierName(Long uuid,Map<Long,String> supplierNameMap){
        //如果供应商编号为空,则返回空
        if (uuid == null) {
            return null;
        }
        //通过供应商编号,尝试从缓存中获取供应商名称
        String supplierName = supplierNameMap.get(uuid);
        if (supplierName == null) {
            //如果在缓存中没有找到,则调用dao查询后,获取的供应商名称
            supplierName = supplierDao.get(uuid).getName();
            //按供应商编号保存供应商名称到缓存中
            supplierNameMap.put(uuid,supplierName);
        }
        return supplierName;
    }

    /**
     * 采购订单审核业务
     * @param uuid
     * @param empUuid
     */
    public void doCheck(Long uuid, Long empUuid) {
        //获取订单信息
        Orders orders = ordersDao.get(uuid);
        //检查订单的状态是否为未审核
        if (!Orders.STATE_CREATE.equals(orders.getState())){
            throw new ErpException("亲!该订单已经审核过了");
        }
        //更新审核员
        orders.setChecker(empUuid);
        //更新审核时间
        orders.setChecktime(new Date());
        //更新订单状态为已审核
        orders.setState(Orders.STATE_CHECK);
    }

    /**
     * 采购订单确认业务
     * @param uuid
     * @param empUuid
     */
    public void doStart(Long uuid, Long empUuid) {
        //获取订单信息
        Orders orders = ordersDao.get(uuid);
        //检查订单的状态是否为已审核
        if (!Orders.STATE_CHECK.equals(orders.getState())){
            throw new ErpException("亲!该订单已经确认过了");
        }
        //更新确认人员
        orders.setStarter(empUuid);
        //更新确认时间
        orders.setStarttime(new Date());
        //更新订单状态为已确认
        orders.setState(Orders.STATE_START);
    }
}
