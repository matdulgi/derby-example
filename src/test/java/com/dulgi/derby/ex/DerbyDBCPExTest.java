package com.dulgi.derby.ex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyDBCPExTest {
    long startTime;

    @Before
    public void before() throws ClassNotFoundException {
        Class.forName(DerbyDBCPEx.class.getName());
        startTime = System.currentTimeMillis();
    }
    @After
    public void after(){
        long endTime = System.currentTimeMillis();
        System.out.println( (endTime - startTime)  + " ms");
    }

    @Test
    public void connectionWithoutConnectionPoolTest() throws SQLException {
        for (int i = 0; i < 100000; i++) {
            Connection connection = DriverManager.getConnection(BasicDerbyDBEx.CONNECTION_STRING);
            connection.close();
        }
    } // 5475 ms

    @Test
    public void connectionWithPoolingDriverTest() throws SQLException, ClassNotFoundException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Connection connection = DriverManager.getConnection(DerbyDBCPEx.CONNECTION_STRING);
            connection.close();
        }
    } // 694 ms

}
