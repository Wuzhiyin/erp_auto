package cn.itcast.erp.biz;

import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.exception.ErpException;

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


    /**
     * 更新员工密码
     * @param id
     * @param oldPwd
     * @param newPwd
     * @throws ErpException
     */
    void updatePwd(Long id,String oldPwd ,String newPwd) throws ErpException;

    /**
     * 重置员工密码
     * @param uuid
     * @param newPwd
     */
    void updatePwd_reset(Long uuid,String newPwd);
}
