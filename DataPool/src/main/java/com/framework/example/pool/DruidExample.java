package com.framework.example.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidExample {

    static final String sql = "select * from quota_20231230";
//    static final String sql = "select * from helloworld";
        static final String RESULT_SET_1_1 = "merc_id";
        static final String RESULT_SET_1_2 = "month_total";
//    static final String RESULT_SET_1_1 = "name";
//    static final String RESULT_SET_1_2 = "age";

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

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 执行查询并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(RESULT_SET_1_1) + " " + resultSet.getString(RESULT_SET_1_2));
            System.out.println("==================================");
        }
    }
}
