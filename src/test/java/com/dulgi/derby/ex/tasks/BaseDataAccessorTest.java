package com.dulgi.derby.ex.tasks;

import org.junit.Test;

public class BaseDataAccessorTest {
    BaseDataAccessor basicDataAccessor = new BaseDataAccessor();

    @Test
    public void executeTest(){
        basicDataAccessor.execute("DROP TABLE TEST98");
        basicDataAccessor.execute("CREATE TABLE TEST98( COL1 INT, COL2 VARCHAR(10) )");
        basicDataAccessor.execute("INSERT INTO TEST98 VALUES (1, '1')");
        basicDataAccessor.execute("INSERT INTO TEST98 VALUES (2, '2')");
        basicDataAccessor.execute("INSERT INTO TEST98 VALUES (3, '3')");
    }

    @Test
    public void queryTest(){
        basicDataAccessor.query("select * from test98", 3).stream().forEach(System.out::println);
    }
}
