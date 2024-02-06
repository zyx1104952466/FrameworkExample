package com.framework.example.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidExample {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, DruidExample!");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(10);

        DruidPooledConnection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from helloworld");
        // 执行查询并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
            System.out.println("==================================");
        }
    }
}
