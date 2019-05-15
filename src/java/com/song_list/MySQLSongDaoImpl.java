/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.song_list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saiko
 */
public class MySQLSongDaoImpl implements SongDao {

    private static final String USER = "songadmin";
    private static final String PASSWORD = "s0ng@dm1n";
    
    @Override
    public List<ManualSongEntity> getSongs() throws DataAccessException {        
        
        List<ManualSongEntity> songs = new ArrayList<>();
        
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/song_list?serverTimezone=UTC&characterEncoding=utf-8&autoReconnect=true&useSSL=false",
                USER,
                PASSWORD
            );

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, title, artist from song order by title");                
            while (rs.next()) {
                Long id = rs.getLong(1);
                String title = rs.getString(2);
                String artist = rs.getString(3);
                ManualSongEntity song = new ManualSongEntity(id, title, artist);
                songs.add(song);
            }
            
            return songs;
        }
        catch(Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
    }
    
}
