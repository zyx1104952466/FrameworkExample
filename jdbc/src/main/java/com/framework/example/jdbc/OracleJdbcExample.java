package com.framework.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * OracleJdbcExample
 *
 * @author zhangyux
 * @since 2024/2/6 18:02
 */
public class OracleJdbcExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello, OracleJdbcExample!");

        // 注册驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 获取连接
        String url = "jdbc:oracle:thin:@10.213.40.22:1521:yyk01";
        String user = "yspos_boss";
        String password = "boss!123";
        Connection connection = DriverManager.getConnection(url, user, password);
        // 获取执行器
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM URMTMFEE_BASE ub WHERE ub.MERC_ID = '000000000000000'");
        // 执行查询并获取结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("merc_id") + "|" + resultSet.getString("rate_id"));
            System.out.println("====================================");
        }
    }
}
