package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IGoodsBiz;
import cn.itcast.erp.dao.IGoodsDao;
import cn.itcast.erp.entity.Goods;

import java.util.List;

 /**
 * 商品 业务逻辑层
 * @author Wilson
 */
public class GoodsBiz extends BaseBiz<Goods> implements IGoodsBiz{
    private IGoodsDao goodsDao;

    public void setGoodsDao(IGoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        super.setBaseDao(this.goodsDao);
    }
}
