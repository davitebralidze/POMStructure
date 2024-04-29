package QueryExecutioner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class QueryExecutioner {
    public static class MySQL {
        public static String selectSpecificDataFromColumn(String query, String columnName) {
            Properties properties = new Properties();
            try {
                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            var dataSource = new MysqlDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));

            try (var connection = dataSource.getConnection(properties.getProperty("userName"), properties.getProperty("password")); Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                resultSet.next();
                return resultSet.getString(columnName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public static void executeDataAlteringQuery(String query) {
            Properties properties = new Properties();
            try {
                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            var dataSource = new MysqlDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));

            try (var connection = dataSource.getConnection(properties.getProperty("userName"), properties.getProperty("password")); Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //TODO Add MS and Postgre connections
    public static class MSSQL {}
    public static class PostgreSQL{}

    }


