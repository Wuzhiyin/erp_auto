package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Goods;

/**
 * 商品 Action
 * @author Wilson
 */
public class GoodsAction extends BaseAction<Goods>{
    private IGoodsBiz goodsBiz;

    public void setGoodsBiz(IGoodsBiz goodsBiz) {
        this.goodsBiz = goodsBiz;
        super.setBaseBiz(this.goodsBiz);
    }


}
