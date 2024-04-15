package dulgi.derbyexample.tasks;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicDDLTask {
    BaseDataAccessor da = new BaseDataAccessor();

    public void createTable(String tablaName, Map<String, String> columnMap) throws SQLException {
        Set<String> columnSet = columnMap.keySet().stream().map(c->c + " " + columnMap.get(c)).collect(Collectors.toSet());
        createTable(tablaName, String.join(", ", columnSet));
    }
    public void createTable(String tablaName, String columnString) throws SQLException {
        da.execute("CREATE TABLE " + tablaName + " ( " + columnString + " )");
    }


}
