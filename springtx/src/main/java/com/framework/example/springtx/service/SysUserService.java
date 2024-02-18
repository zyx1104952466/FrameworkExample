package com.framework.example.springtx.service;

import com.framework.example.springtx.dao.SysUserDao;
import com.framework.example.springtx.model.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * SysUserService
 *
 * @author zhangyux
 * @since 2024/2/7 10:36
 */
@Service("sysUserService")
public class SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    /**
     * REQUIRED，如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
     * Isolation.READ_COMMITTED，读已提交
     * Isolation.READ_UNCOMMITTED，读未提交
     * Isolation.REPEATABLE_READ，可重复读
     * Isolation.SERIALIZABLE，串行化
     * Isolation.DEFAULT，使用数据库默认的隔离级别
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void updateAndDelete(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }

    /**
     * REQUIRES_NEW，创建一个新的事务，如果当前存在事务，则把当前事务挂起。
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateAndDelete1(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }

    /**
     * MANDATORY，如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateAndDelete2(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }

    /**
     * NESTED，如果当前存在事务，则在嵌套事务内执行；如果当前没有事务，则创建一个新的事务。
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.NESTED)
    public void updateAndDelete3(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }

    /**
     * NEVER，如果当前存在事务，则抛出异常；如果当前没有事务，则以非事务方式执行。
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.NEVER)
    public void updateAndDelete4(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }

    /**
     * SUPPORTS，如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务方式执行。
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateAndDelete5(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }

    /**
     * NOT_SUPPORTED，以非事务方式执行操作，如果当前存在事务，则把当前事务挂起。
     * @param sysUser sysUser
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateAndDelete6(SysUser sysUser) {
        sysUserDao.update(sysUser);
        sysUserDao.update(sysUser);
    }
}
