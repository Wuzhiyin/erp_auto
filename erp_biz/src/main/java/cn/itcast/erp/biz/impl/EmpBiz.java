package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.entity.Emp;

import java.util.List;

 /**
 * 员工 业务逻辑层
 * @author Wilson
 */
public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz{
    private IEmpDao empDao;

    public void setEmpDao(IEmpDao empDao) {
        this.empDao = empDao;
        super.setBaseDao(this.empDao);
    }
     /**
      * 用户登录
      * @param username
      * @param pwd
      * @return
      */
     public Emp findByUsernameAndPwd(String username,String pwd){

         return empDao.findByUsernameAndPwd(username,pwd);
     }
}
