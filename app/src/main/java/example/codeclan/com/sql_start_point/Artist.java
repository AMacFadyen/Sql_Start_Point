package example.codeclan.com.sql_start_point;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;
import java.util.ArrayList;

import db.SqlRunner;

public class Artist {

    private String name;
    private int id;

    public Artist(String name) {
        this.name = name;
    }

    public Artist(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save() {
        String sql = String.format("");
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


    //Java version of Ruby map method
    public static ArrayList<Artist> map(ResultSet rs){

        ArrayList<Artist> artists = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                artists.add(new Artist(id, name));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }

        return artists;
    }



}