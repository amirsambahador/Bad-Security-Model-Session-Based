package org.j2os.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static final BasicDataSource XE_DATA_SOURCE = new BasicDataSource();

    static {
        XE_DATA_SOURCE.setUsername("milad");
        XE_DATA_SOURCE.setPassword("myjava123");
        XE_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        XE_DATA_SOURCE.setMaxTotal(10);
        XE_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521/xepdb1");
    }


    public static Connection getConnection() throws Exception {
        return XE_DATA_SOURCE.getConnection();
    }
}