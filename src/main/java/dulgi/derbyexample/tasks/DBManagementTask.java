package dulgi.derbyexample.tasks;

import java.sql.SQLException;

public class DBManagementTask {
    BaseDataAccessor basicDataAccessor = new BaseDataAccessor();

    public void createDerby(){

    }

    public void shutdown() {
//        Connection connection = basicDataAccessor.getConnection("jdbc:derby:;shutdown=true");
    }

    public void runOnOtherDirectory() { }


    public void showTables() throws SQLException {
//        String sql = "select st.tablename  from sys.systables st LEFT OUTER join sys.sysschemas ss on (st.schemaid = ss.schemaid) where ss.schemaname ='APP'";
        String sql = "select st.tablename  from sys.systables st";
    }
}
