package com.sandra.msc.authserver;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    /**
     * Spring Boot 默认已经配置好了数据源，程序员可以直接 DI 注入然后使用即可
     */
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {

        System.out.println("数据源>>>>>>" + dataSource.getClass());
        final Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
        connection.close();

    }
}
