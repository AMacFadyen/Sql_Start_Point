package example.codeclan.com.sql_start_point;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;
import java.util.ArrayList;

import db.SqlRunner;

public class Album {

    private String title;
    private String genre;
    private int artist_id;
    private int id;

    public Album(String title, String genre, int artist_id) {
        this.title = title;
        this.genre = genre;
        this.artist_id = artist_id;
    }

    public Album(int id, String title, String genre, int artist_id) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.artist_id = artist_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void save() {
        String sql = String.format("");
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


    //Java version of Ruby map method
    public static ArrayList<Album> map(ResultSet rs){

        ArrayList<Album> albums = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int artist_id = rs.getInt("artist_id");
                albums.add(new Album(id, title, genre, artist_id));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }

        return albums;
    }

}