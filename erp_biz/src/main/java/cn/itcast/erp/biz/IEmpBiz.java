package cn.itcast.erp.biz;

import cn.itcast.erp.entity.Emp;

import java.util.List;
/**
 * 员工 业务层接口
 * @author Wilson
 */
public interface IEmpBiz extends IBaseBiz<Emp>{

    /**
     * 用户登录
     * @param username
     * @param pwd
     * @return
     */
    Emp findByUsernameAndPwd(String username,String pwd);
}
