package QueryExecutioner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//TODO Add Postgre connection - Needs to be tested
//TODO Test the database connections


public class QueryExecutioner {
    public static class MySQL {
        public static String selectSpecificDataFromColumn(String query, String columnName) {
//            Properties properties = new Properties();
//            try {
//                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            Properties properties = loadProperties();
            var dataSource = new MysqlDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            return executeScriptForSelect(dataSource, query, columnName, properties);
        }

        public static void executeDataAlteringQuery(String query) {
//            Properties properties = new Properties();
//            try {
//                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            Properties properties = loadProperties();
            var dataSource = new MysqlDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            executeScriptForAlter(dataSource, properties, query);
        }
    }
    public static class MSSQL {
        public static String selectSpecificDataFromColumn(String query, String columnName) {
//            Properties properties = new Properties();
//            try {
//                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

            Properties properties = loadProperties();
            var dataSource = new SQLServerDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPortNumber(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            return executeScriptForSelect(dataSource, query, columnName, properties);
        }

        public static void executeDataAlteringQuery(String query) {
//            Properties properties = new Properties();
//            try {
//                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            Properties properties = loadProperties();
            var dataSource = new SQLServerDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPortNumber(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            executeScriptForAlter(dataSource, properties, query);
        }
    }

    public static class PostgreSQL{
        public static String selectSpecificDataFromColumn(String query, String columnName) {
//            Properties properties = new Properties();
//            try {
//                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            Properties properties = loadProperties();
            var dataSource = new PGSimpleDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPortNumbers(new int[]{Integer.parseInt(properties.getProperty("port"))});
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            return executeScriptForSelect(dataSource, query, columnName, properties);
        }

        public static void executeDataAlteringQuery(String query) {
//            Properties properties = new Properties();
//            try {
//                properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            Properties properties = loadProperties();
            var dataSource = new PGSimpleDataSource();
            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPortNumbers(new int[]{Integer.parseInt(properties.getProperty("port"))});
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            executeScriptForAlter(dataSource, properties, query);
        }
    }

    private static String executeScriptForSelect (DataSource dataSource, String query, String columnName, Properties properties) {
        try (var connection = dataSource.getConnection(properties.getProperty("userName"),
                properties.getProperty("password"));
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getString(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void executeScriptForAlter (DataSource dataSource, Properties properties, String query) {
        try (var connection = dataSource.getConnection(properties.getProperty("userName"), properties.getProperty("password")); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("DBCredentials.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return properties;
    }
}


