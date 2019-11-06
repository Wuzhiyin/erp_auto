package cn.itcast.erp.dao;

import cn.itcast.erp.entity.Emp;

import java.util.List;

/**
 * 部门数据访问接口
 */
public interface IEmpDao extends IBaseDao<Emp>{
    /**
     * 用户登录
     * @param username
     * @param pwd
     * @return
     */
    Emp findByUsernameAndPwd(String username,String pwd);

}
