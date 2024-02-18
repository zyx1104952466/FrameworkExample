package com.framework.example.springjdbc.model;

/**
 * SysUser
 *
 * @author zhangyux
 * @since 2024/2/7 9:58
 */
public class SysUser {

    String userId;
    String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
