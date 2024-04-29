import QueryExecutioner.QueryExecutioner;

import java.sql.SQLException;

public class ExecuteSingleQuery {
    public static void main(String[] args) throws SQLException {
        System.out.println(QueryExecutioner.MySQL.selectSpecificDataFromColumn("SELECT * FROM music.albumview WHERE album_name='18 Singles'", "song_title"));
    }
}
