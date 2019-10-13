package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Goodstype;

/**
 * 商品分类 Action
 * @author Wilson
 */
public class GoodstypeAction extends BaseAction<Goodstype>{
    private IGoodstypeBiz goodstypeBiz;

    public void setGoodstypeBiz(IGoodstypeBiz goodstypeBiz) {
        this.goodstypeBiz = goodstypeBiz;
        super.setBaseBiz(this.goodstypeBiz);
    }


}
