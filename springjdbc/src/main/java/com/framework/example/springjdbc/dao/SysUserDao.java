package com.framework.example.springjdbc.dao;

import com.framework.example.springjdbc.model.SysUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysUserDao
 *
 * @author zhangyux
 * @since 2024/2/7 9:59
 */
@Repository
public class SysUserDao {

    private JdbcTemplate jdbcTemplate;

    final String sql = "select * from sys_user";

    public SysUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SysUser> getAll() {

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            SysUser sysUser = new SysUser();
            sysUser.setUserId(resultSet.getString("user_id"));
            sysUser.setUserName(resultSet.getString("user_name"));
            return sysUser;
        });
    }

    public void insert(SysUser sysUser) {
        String sql = "insert into sys_user(user_id, user_name) values(?, ?)";
        jdbcTemplate.update(sql, sysUser.getUserId(), sysUser.getUserName());
    }

    public void update(SysUser sysUser) {
        String sql = "update sys_user set user_name = ? where user_id = ?";
        jdbcTemplate.update(sql, sysUser.getUserName(), sysUser.getUserId());
    }

    public void delete(SysUser sysUser) {
        String sql = "delete from sys_user where user_id = ?";
        jdbcTemplate.update(sql, sysUser.getUserId());
    }

    public SysUser getById(String userId) {
        String sql = "select * from sys_user where user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (resultSet, i) -> {
            SysUser sysUser = new SysUser();
            sysUser.setUserId(resultSet.getString("user_id"));
            sysUser.setUserName(resultSet.getString("user_name"));
            return sysUser;
        });
    }

    public int count() {
        String sql = "select count(*) from sys_user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void batchInsert(List<SysUser> sysUsers) {
        String sql = "insert into sys_user(user_id, user_name) values(?, ?)";
        jdbcTemplate.batchUpdate(sql, sysUsers, sysUsers.size(), (preparedStatement, sysUser) -> {
            preparedStatement.setString(1, sysUser.getUserId());
            preparedStatement.setString(2, sysUser.getUserName());
        });
    }
}
