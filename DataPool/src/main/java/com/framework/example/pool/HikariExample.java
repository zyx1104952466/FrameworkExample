package com.framework.example.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import com.zaxxer.hikari.pool.HikariProxyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariExample {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, HikariExample!");

        // 获取连接
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("root");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);

        HikariPool pool = new HikariPool(config);
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from helloworld");
        // 执行查询并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
            System.out.println("==================================");
        }

    }
}
