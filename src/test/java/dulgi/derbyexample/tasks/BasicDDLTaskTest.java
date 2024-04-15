package dulgi.derbyexample.tasks;

import org.junit.Test;

import java.sql.SQLException;

public class BasicDDLTaskTest {
    BasicDDLTask task = new BasicDDLTask();

    String tmpTableName2 = "tmp2";
    String tmpTableColumns2 = "col1 varchar(10)";
    String tmpTableInsertValue = "goodday";


    @Test
    public void testCreateTable() throws SQLException {
        String tableName = "tmp2";
        String columnStr = "col1 varchar(10)";
        task.createTable(tableName, columnStr);
    }




}
