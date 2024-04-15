package dulgi.derbyexample.tasks;

import dulgi.derbyexample.BasicDerbyDBEx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class is base component of other DAO Classes
 */
public class BaseDataAccessor {
    private  final String connectionString = BasicDerbyDBEx.CONNECTION_STRING;

    public boolean execute(String sql) {
        try (Connection connection = DriverManager.getConnection(connectionString) ) {
            return connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> query(String sql){
        return query(sql, -1);
    }

    public List<String> query(String sql, int rowNum) {
        try (Connection connection = DriverManager.getConnection(connectionString);
             ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
        ) {
            return mapResultSetToList(resultSet, rowNum);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // fix it
    private List<String> mapResultSetToList(ResultSet resultSet, int rowNum){
        List<String> list = new ArrayList<>();
        try {
            int c = 0;
            while (resultSet.next() && c++ < rowNum || rowNum == -1) {
                StringBuilder stringBuilder = new StringBuilder();
                IntStream.rangeClosed(1, resultSet.getMetaData().getColumnCount()).forEach( i -> {
                if (i > 1) stringBuilder.append(",  ");
                    try {
                        stringBuilder.append(resultSet.getString(i));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } );
                list.add(stringBuilder.toString());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
