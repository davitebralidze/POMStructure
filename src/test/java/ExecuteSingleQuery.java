import QueryExecutioner.QueryExecutioner;

import java.sql.SQLException;

public class ExecuteSingleQuery {
    public static void main(String[] args) throws SQLException {
        System.out.println(QueryExecutioner.selectSpecificDataFromColumn("SELECT * FROM music.albumview WHERE album_name='18 Singles'", "song_title"));
        QueryExecutioner.executeDataAlteringQuery("UPDATE `music`.`songs` SET `song_title` = 'I will follow' WHERE `song_id` = 598;");
        System.out.println(QueryExecutioner.selectSpecificDataFromColumn("SELECT * FROM music.albumview WHERE album_name='18 Singles'", "song_title"));
    }
}
