import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class DataBaseJDBC {

    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music";

    public static void main(String[] args) throws SQLException {

        String username = JOptionPane.showInputDialog(null, "Enter DB Username");
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter DB Password", JOptionPane.OK_CANCEL_OPTION);
        final char[] password = (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;


//        try(Connection connection = DriverManager.getConnection(
//                CONN_STRING, username, String.valueOf(password))) {
//            System.out.println("Successfully connected to the DB");
//            Arrays.fill(password, ' ');
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
        // Older method


        //DataSource is newer and preferred
        var dataSource = new MysqlDataSource();
//        dataSource.setURL(CONN_STRING); --> next three lines replace this one line (basically they are the same)
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");

        String query = "SELECT * FROM music.albumview WHERE album_name='18 Singles'";

        try (Connection connection = dataSource.getConnection(username, String.valueOf(password));
             Statement statement = connection.createStatement()) {
            System.out.println("Successfully connected to the DB");
            Arrays.fill(password, ' ');

            ResultSet resultSet = statement.executeQuery(query);
            /*resultSet is an array, and we need to move index to next one*/
            resultSet.next();
            String songTitle = resultSet.getString("song_title");
            System.out.println(songTitle);

        } catch (SQLException e) {
            throw new RuntimeException();
        }


    }
}
