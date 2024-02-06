package com.framework.example.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MysqlJdbcExample
 *
 * @author zhangyux
 * @since 2024/2/6 17:52
 */
public class MysqlJdbcExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello, MysqlJdbcExample!");

        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/ry?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);

        PreparedStatement preparedStatement = connection.prepareStatement("select * from sys_user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("user_id"));
            System.out.println(resultSet.getString("user_name"));
        }
    }
}
