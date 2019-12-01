package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.exception.ErpException;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.List;

 /**
 * 员工 业务逻辑层
 * @author Wilson
 */
public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz{
    /**散列次数*/
    private int hashIterations = 2;

    private IEmpDao empDao;


    public void setEmpDao(IEmpDao empDao) {
        this.empDao = empDao;
        super.setBaseDao(this.empDao);
    }
     /**
      * 根据用户名和密码查询登录用户信息
      * @param username
      * @param pwd
      * @return
      */
     public Emp findByUsernameAndPwd(String username,String pwd){
         //查询前先加密
         pwd = encrypt(pwd,username,hashIterations);
         System.out.println(pwd);
         return this.empDao.findByUsernameAndPwd(username,pwd);
     }

     public void updatePwd(Long id, String oldPwd, String newPwd) throws ErpException {
         Emp emp = this.empDao.get(id);
         //加密旧密码后才能进行匹配判断
         String encryptedOldPwd = encrypt(oldPwd,emp.getUsername(),hashIterations);
         if (!encryptedOldPwd.equals(emp.getPwd())){
             throw new ErpException("原密码不正确");
         }
         //修改持久对象的属性触发更新,新密码也要进行加密
         emp.setPwd(encrypt(newPwd,emp.getUsername(),hashIterations));
     }

     public void updatePwd_reset(Long uuid, String newPwd) {
         //将员工进入持久化状态
         Emp emp = this.empDao.get(uuid);
         //设置密码触发update密码

         empDao.updatePwd(uuid,encrypt(newPwd,emp.getUsername(),hashIterations));
     }

     /**
      * 新增员工
      * @param emp
      */
     public void add(Emp emp){
         String pwd = emp.getPwd();
         //source:原密码
         //salt:盐=>扰乱码
         //hashIterations:散列次数.加密次数
         //Md5Hash md5 = new Md5Hash(pwd,emp.getUsername(),hashIterations);
         //取出加密后的密码
         String newPwd = encrypt(emp.getUsername(),emp.getUsername(),hashIterations);
         //设置成加密后的密码
         emp.setPwd(newPwd);
         //保存到数据库中
         empDao.add(emp);
     }
     /**
      * 加密
      * @param source
      * @param salt
      * @param hashIterations
      * @return
      */
     private String encrypt(String source,String salt,int hashIterations){
         Md5Hash md5 = new Md5Hash(source,salt,hashIterations);
         return md5.toString();
     }

}
