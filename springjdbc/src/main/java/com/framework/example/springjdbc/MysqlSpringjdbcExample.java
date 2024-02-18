package com.framework.example.springjdbc;

import com.framework.example.springjdbc.dao.SysUserDao;
import com.framework.example.springjdbc.model.SysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MysqlSpringjdbcExample
 *
 * @author zhangyux
 * @since 2024/2/7 9:56
 */
public class MysqlSpringjdbcExample {

    public static void main(String[] args) {
        System.out.println("Hello, MysqlSpringjdbcExample!");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.framework.example.springjdbc");
        SysUserDao sysUserDao = (SysUserDao)applicationContext.getBean("sysUserDao");

        System.out.println(sysUserDao.getById("1"));

        SysUser sysUser = new SysUser();
        sysUser.setUserId("1");
        sysUser.setUserName("zhangyux1");

        sysUserDao.update(sysUser);

        System.out.println(sysUserDao.getById("1"));

        sysUser.setUserName("若依");
        sysUserDao.update(sysUser);
        System.out.println(sysUserDao.getById("1"));
    }
}
