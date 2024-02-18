package com.framework.example.springtx;

import com.framework.example.springtx.model.SysUser;
import com.framework.example.springtx.service.SysUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MysqlSpringtxExample
 *
 * @author zhangyux
 * @since 2024/2/18 14:11
 */
public class MysqlSpringtxExample {

    public static void main(String[] args) {
        System.out.println("Hello, MysqlSpringtxExample!");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.framework.example.springtx");
        SysUserService sysUserService = (SysUserService)applicationContext.getBean("sysUserService");

        SysUser sysUser = new SysUser();
        sysUser.setUserId("1");
        sysUser.setUserName("zhangyux");

        sysUserService.updateAndDelete(sysUser);
    }
}
