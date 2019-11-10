package cn.itcast.erp.action;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.entity.Emp;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAction {
    private String username;//登录用户名
    private String pwd;//登录密码
    private IEmpBiz empBiz;

    public IEmpBiz getEmpBiz() {
        return empBiz;
    }

    public void setEmpBiz(IEmpBiz empBiz) {
        this.empBiz = empBiz;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void checkUser(){
        //查询是否存在
        try{
            Emp loginUser = empBiz.findByUsernameAndPwd(username,pwd);
            if(loginUser != null){
                //记录当前登录的用户
                ActionContext.getContext().getSession().put("loginUser",loginUser);
                ajaxReturn(true,"");
            }else {
                ajaxReturn(false,"用户名或密码错误");
                return;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            ajaxReturn(false,"登陆失败");

        }

    }

    /**
     * 显示登录用户名称
     */
    public void showName(){
        Emp loginUser = (Emp) ActionContext.getContext().getSession().get("loginUser");
        if (loginUser != null) {
            ajaxReturn(true,loginUser.getName());
        }else{
            ajaxReturn(false,"");
        }
    }

    /**
     * 退出登录
     */
    public void loginOut(){
        ActionContext.getContext().getSession().remove("loginUser");
    }
    public void ajaxReturn(boolean success, String message){
        //返回前端的JSON数据
        Map<String, Object> rtn = new HashMap<String, Object>();
        rtn.put("success",success);
        rtn.put("message",message);
        write(JSON.toJSONString(rtn));
    }
    public void write(String jsonString) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
