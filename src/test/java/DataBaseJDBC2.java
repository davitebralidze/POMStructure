import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseJDBC2 {
    public static void main(String[] args) {

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

        String query = "SELECT * FROM music.albumview WHERE album_name='18 Singles'";

        try (var connection = dataSource.getConnection(
                properties.getProperty("userName"),
                properties.getProperty("password"));
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);

            /*resultSet is an array, and we need to move index to next one*/
            resultSet.next();

            System.out.println(resultSet.getString("song_title"));


//            var meta = resultSet.getMetaData();
//
////            for (int i = 1; i <= meta.getColumnCount(); i++) {
////                System.out.printf("%d %s %s %n", i, meta.getColumnName(i), meta.getColumnTypeName(i));
////            }
////
////            System.out.println("=================================");
//
//            for (int i = 1; i < meta.getColumnCount(); i++) {
//                System.out.printf("%-30s", meta.getColumnName(i).toUpperCase());
//            }
//
//            System.out.println();
//
//            while (resultSet.next()) {
////                System.out.printf("%d %s %s %n",
////                        resultSet.getInt("track_number"),
////                        resultSet.getString("artist_name"),
////                        resultSet.getString("song_title")
////                );
//                for (int i = 1; i < meta.getColumnCount(); i++) {
//                    System.out.printf("%-30s", resultSet.getString(i));
//                }
//                System.out.println();
//            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
