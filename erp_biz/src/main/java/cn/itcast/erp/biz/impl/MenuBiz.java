package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IMenuBiz;
import cn.itcast.erp.dao.IMenuDao;
import cn.itcast.erp.entity.Menu;

import java.util.List;

 /**
 * 菜单 业务逻辑层
 * @author Wilson
 */
public class MenuBiz extends BaseBiz<Menu> implements IMenuBiz{
    private IMenuDao menuDao;

    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
        super.setBaseDao(this.menuDao);
    }
}
