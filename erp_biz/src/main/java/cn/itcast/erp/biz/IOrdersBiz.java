package cn.itcast.erp.biz;

import cn.itcast.erp.entity.Orders;

import java.util.List;
/**
 * 订单 业务层接口
 * @author Wilson
 */
public interface IOrdersBiz extends IBaseBiz<Orders>{
    /**
     * 采购订单审核业务
     * @param uuid
     * @param empUuid
     */
    void doCheck(Long uuid,Long empUuid);
    /**
     * 采购订单确认业务
     * @param uuid
     * @param empUuid
     */
    void doStart(Long uuid,Long empUuid);
}
