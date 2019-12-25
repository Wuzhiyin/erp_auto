package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import cn.itcast.erp.exception.ErpException;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 订单 Action
 * @author Wilson
 */
public class OrdersAction extends BaseAction<Orders>{
    private IOrdersBiz ordersBiz;
    //前端提交过来的商品明细列表,转成的json字符串
    private String json;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public void setOrdersBiz(IOrdersBiz ordersBiz) {
        this.ordersBiz = ordersBiz;
        super.setBaseBiz(this.ordersBiz);
    }

    /**
     * 采购申请
     */
    @Override
    public void add() {
        System.out.println(json);
        Emp loginUser = getLoginUser();
        //校验用户是否登录,订单的创建人就是当前登录的用户
        if (loginUser == null) {
            ajaxReturn(false,"亲,您还没有登录");
            return;
        }
        try {
            //获取提交的订单
            Orders orders = getT();
            //设置订单的创建人
            orders.setCreater(loginUser.getUuid());
            //获取订单明细
            List<Orderdetail> orderDetailList = JSON.parseArray(json,Orderdetail.class);
            //设置订单的明细
            orders.setOrderDetails(orderDetailList);
            //保存订单
            ordersBiz.add(orders);
            ajaxReturn(true,"添加订单成功");
        }catch (Exception e){
            e.printStackTrace();
            ajaxReturn(false,"添加订单失败");
        }
    }

    /**
     * 采购订单确认
     */
    public void doStart(){
        Emp loginUser = getLoginUser();
        if (loginUser == null) {
            ajaxReturn(false,"亲!您还没有登录");
            return;
        }
        try {
            //确认业务
            ordersBiz.doStart(getId(),loginUser.getUuid());
            ajaxReturn(true,"确认成功");
        }catch (ErpException e){
            ajaxReturn(false,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            ajaxReturn(false,"确认失败");
        }

    }
    public void doCheck(){
        Emp loginUser = getLoginUser();
        if (loginUser == null) {
            ajaxReturn(false,"亲!您还没有登录");
            return;
        }
        try {
            ordersBiz.doCheck(getId(),loginUser.getUuid());
            ajaxReturn(true,"审核成功");
        }catch (ErpException e){
            ajaxReturn(false,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            ajaxReturn(false,"审核失败");
        }

    }

    /**
     * 我的订单
     */
    public void myListByPage(){
        if (null == getT1()){
            //如果查询条件为空,则构造查询条件
            setT1(new Orders());
        }
        Emp loginUser = getLoginUser();
        //设置订单的创建者条件
        getT1().setCreater(loginUser.getUuid());
        super.getList();
    }


}
