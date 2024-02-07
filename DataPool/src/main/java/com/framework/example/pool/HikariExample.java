package com.framework.example.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import com.zaxxer.hikari.pool.HikariProxyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariExample {

    static final String sql = "select * from quota_20231230";
    //    static final String sql = "select * from helloworld";
    static final String RESULT_SET_1_1 = "merc_id";
    static final String RESULT_SET_1_2 = "month_total";
    //    static final String RESULT_SET_1_1 = "name";
    //    static final String RESULT_SET_1_2 = "age";

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
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 执行查询并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(RESULT_SET_1_1) + " " + resultSet.getString(RESULT_SET_1_2));
            System.out.println("==================================");
        }

    }
}
