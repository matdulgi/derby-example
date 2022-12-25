package com.dulgi.derby.ex.tasks;

import java.util.List;

public class BasicDMLTask {
    BaseDataAccessor da = new BaseDataAccessor();


    public List<String> select(String tableName) {
        return da.query("select * from " + tableName );
    }

    public List<String> select(String tableName, int i ) {
        return da.query("select * from " + tableName , i);
    }

    public void selectAndPrint(String tableName){
        select(tableName).stream().forEach(System.out::println);
    }

    public void selectAndPrint(String tableName, int rowNum){
        select(tableName, rowNum).stream().forEach(System.out::println);
    }

    public void countTable(String tableName) {
        da.query("select count(*) from " + tableName);
    }

    public boolean insert(String tableName, List<String> columns) {
        return insert(tableName,String.join(", ", columns));
    }
    public boolean insert(String tableName, String column) {
        return da.execute("insert into " + tableName + " values ('" + column + "')");
    }

}
