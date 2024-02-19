package com.framework.example.mybatis;

import com.framework.example.mybatis.mapper.SysUserMapper;
import com.framework.example.mybatis.model.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatisExample
 *
 * @author zhangyux
 * @since 2024/2/19 9:22
 */
public class MyBatisExample {

    public static void main(String[] args) {
        System.out.println("Hello, MyBatisExample!");
        String resource = "mybatis-config.xml";
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                SysUserMapper mapper = session.getMapper(SysUserMapper.class);
                SysUser sysUser = mapper.getSysUserById(1);
                System.out.println(sysUser);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
