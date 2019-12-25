package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.exception.ErpException;

/**
 * 订单明细 Action
 * @author Wilson
 */
public class OrderdetailAction extends BaseAction<Orderdetail>{
    private IOrderdetailBiz orderdetailBiz;

    public void setOrderdetailBiz(IOrderdetailBiz orderdetailBiz) {
        this.orderdetailBiz = orderdetailBiz;
        super.setBaseBiz(this.orderdetailBiz);
    }
    /** 仓库编号*/
    private Long storeuuid;

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }
    public void doInStore(){
        Emp loginUser = getLoginUser();
        if (loginUser == null) {
            //用户没有登录,session已失效
            ajaxReturn(false,"亲!您还没有登录");
            return;
        }

        try {
            //入库业务
            orderdetailBiz.doInStore(getId(),storeuuid,loginUser.getUuid());
            ajaxReturn(true,"入库成功");

        }catch (ErpException e){
            ajaxReturn(false,e.getMessage());
        }catch (Exception e) {
            ajaxReturn(false,"入库失败");
            e.printStackTrace();
        }
    }
    /**
     * 出库
     */
    public void doOutStore(){
        Emp loginUser = getLoginUser();
        if (loginUser == null) {
            ajaxReturn(false,"亲,您还没有登录!");
            return;
        }
        try {
            orderdetailBiz.doOutStore(loginUser.getUuid(),getId(),storeuuid);
            ajaxReturn(true,"出库成功!");
        } catch (ErpException er) {
            ajaxReturn(false,er.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            ajaxReturn(false,"出库失败!");
        }
    }
}
