package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IGoodstypeBiz;
import cn.itcast.erp.dao.IGoodstypeDao;
import cn.itcast.erp.entity.Goodstype;

import java.util.List;

 /**
 * 商品分类 业务逻辑层
 * @author Wilson
 */
public class GoodstypeBiz extends BaseBiz<Goodstype> implements IGoodstypeBiz{
    private IGoodstypeDao goodstypeDao;

    public void setGoodstypeDao(IGoodstypeDao goodstypeDao) {
        this.goodstypeDao = goodstypeDao;
        super.setBaseDao(this.goodstypeDao);
    }
}
