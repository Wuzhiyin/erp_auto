package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Menu;

/**
 * 菜单 Action
 * @author Wilson
 */
public class MenuAction extends BaseAction<Menu>{
    private IMenuBiz menuBiz;

    public void setMenuBiz(IMenuBiz menuBiz) {
        this.menuBiz = menuBiz;
        super.setBaseBiz(this.menuBiz);
    }


}
