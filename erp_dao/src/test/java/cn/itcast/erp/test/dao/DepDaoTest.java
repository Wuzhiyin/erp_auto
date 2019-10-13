package cn.itcast.erp.test.dao;

import cn.itcast.erp.dao.IDepDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DepDaoTest {

    @Test
    public void tt(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
        IDepDao depDao = (IDepDao) ac.getBean("depDao");
        System.out.println(depDao.getList().size());
    }
}
