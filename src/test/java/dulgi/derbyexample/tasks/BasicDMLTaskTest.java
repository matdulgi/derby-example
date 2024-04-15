package dulgi.derbyexample.tasks;

import org.junit.Assert;
import org.junit.Test;

public class BasicDMLTaskTest {
    BasicDMLTask task = new BasicDMLTask();

    String tableName = "tmp2";
    String tmpInsertValue = "goodday";

    @Test
    public void selectAndPrintTest(){
        task.selectAndPrint(tableName, 10);
    }

    @Test
    public void countTableTest(){
        task.countTable(tableName);
    }

    @Test
    public void testInsertWithDriver() {
        Assert.assertFalse(task.insert(tableName, tmpInsertValue));
    }

    @Test
    public void insertIntoNotExistTable() {
        task.insert("tmp99", tmpInsertValue);
    }




}
