package com.dulgi.derby.ex.tasks;

import org.junit.Assert;
import org.junit.Test;

public class BasicDMLTaskTest {
    BasicDMLTask task = new BasicDMLTask();

    String tmpTableName2 = "tmp2";
    String tmpInsertValue = "goodday";

    @Test
    public void selectAndPrintTest(){
        task.selectAndPrint(tmpTableName2, 10);
    }

    @Test
    public void countTableTest(){
        task.countTable(tmpTableName2);
    }

    @Test
    public void insertWithDriverTest() {
        Assert.assertFalse(task.insert(tmpTableName2, tmpInsertValue));
    }

    @Test
    public void insertIntoNotExistTable() {
        task.insert("tmp99", tmpInsertValue);
    }




}
