/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.song_list;

import java.util.List;

/**
 *
 * @author saiko
 */
public interface SongDao {
    
    List<ManualSongEntity> getSongs() throws DataAccessException;
    
}
