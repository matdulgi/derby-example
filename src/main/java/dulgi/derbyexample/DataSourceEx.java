package dulgi.derbyexample;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceEx {
    static final String DRIVER_CLASS_NAME = "org.apache.derby.jdbc.EmbeddedDriver";
    static final String PROTOCOL = "jdbc:derby:";
    static final String DB = "derbyDB";
    static final String OPTIONS = "create=true";
    static final String URL = PROTOCOL + DB + ";" + OPTIONS;

    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        return dataSource;
    }

    public static void main(String[] args) throws SQLException {
    }
}
