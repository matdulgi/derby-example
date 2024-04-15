package dulgi.derbyexample;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

public class DerbyDBCPEx {
    static final public String DRIVER_CLASS_NAME = "org.apache.commons.dbcp2.PoolingDriver";
    static final public String PROTOCOL = "jdbc:apache:commons:dbcp:";
    static final public String DB = "mypool";
    static final public String CONNECTION_STRING = PROTOCOL + DB;

    static {
        initConnectionPool();
    }

    static private void initConnectionPool() {
        try {
            String sourceJdbcUrl = BasicDerbyDBEx.CONNECTION_STRING;

            PoolableConnectionFactory poolableConnFactory =
                    new PoolableConnectionFactory(new DriverManagerConnectionFactory(sourceJdbcUrl), null);
            poolableConnFactory.setValidationQuery("select 1");

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRuns(Duration.ofMillis(1000L * 60L * 5L));
            poolConfig.setTestWhileIdle(true);
            poolConfig.setMinIdle(4);
            poolConfig.setMaxTotal(50);

            GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool(poolableConnFactory, poolConfig);
            poolableConnFactory.setPool(connectionPool);

            Class.forName(DRIVER_CLASS_NAME);
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver(PROTOCOL);
            driver.registerPool("mypool", connectionPool);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
