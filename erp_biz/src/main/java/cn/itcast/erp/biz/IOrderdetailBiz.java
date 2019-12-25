package cn.itcast.erp.biz;

import cn.itcast.erp.entity.Orderdetail;

import java.util.List;
/**
 * 订单明细 业务层接口
 * @author Wilson
 */
public interface IOrderdetailBiz extends IBaseBiz<Orderdetail>{
    /**
     * 采购入库
     * @param uuid 明细编号
     * @param storeUuid 仓库编号
     * @param empUuid 库管员编号
     */
    void doInStore(Long uuid, Long storeUuid, Long empUuid);
    /**
     * 出库
     * @param uuid 明细编号
     * @param storeUuid 仓库编号
     * @param empUuid 库管员编号
     */
    void doOutStore(Long uuid, Long storeUuid, Long empUuid);
}
