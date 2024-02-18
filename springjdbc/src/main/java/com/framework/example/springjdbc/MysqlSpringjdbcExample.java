package com.framework.example.springjdbc;

import com.framework.example.springjdbc.model.SysUser;
import com.framework.example.springjdbc.service.SysUserService;
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
        SysUserService sysUserService = (SysUserService)applicationContext.getBean("sysUserService");

        SysUser sysUser = new SysUser();
        sysUser.setUserId("2");
        sysUser.setUserName("zhangyux");

        sysUserService.updateAndDelete(sysUser);
    }
}
