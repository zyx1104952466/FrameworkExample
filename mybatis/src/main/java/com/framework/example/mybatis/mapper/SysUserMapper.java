package com.framework.example.mybatis.mapper;

import com.framework.example.mybatis.model.SysUser;

/**
 * SysUserMapper
 *
 * @author zhangyux
 * @since 2024/2/19 9:18
 */
public interface SysUserMapper {

    SysUser getSysUserById(Integer userId);
}
