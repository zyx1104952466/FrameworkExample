package com.framework.example.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostgresqlJdbcExample
 *
 * @author zhangyux
 * @since 2024/2/6 17:56
 */
public class PostgresqlJdbcExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello, PostgresqlJdbcExample!");

        Class.forName("org.postgresql.Driver");
        // 获取连接
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 获取执行器
        PreparedStatement preparedStatement = connection.prepareStatement("select * from quota_20231230");
        // 执行查询并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("merc_id"));
            System.out.println(resultSet.getString("month_total"));
        }

    }
}
