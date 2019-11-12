package cn.itcast.erp.action;
import cn.itcast.erp.biz.*;
import cn.itcast.erp.entity.Menu;
import com.alibaba.fastjson.JSON;

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
    public void getMenuTree(){
        //查询顶级菜单,即可带出其下的每个子菜单
        Menu menu = menuBiz.get("0");
        //转换成漂亮格式的JSON字符串
        String menuJsonString = JSON.toJSONString(menu,true);
        //输入给页面
        write(menuJsonString);
    }

}
