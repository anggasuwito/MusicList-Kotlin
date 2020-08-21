package com.main.myapplication.room.song

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.main.myapplication.room.music.Music

@Dao
interface SongDao {
    @Insert
    fun createSong(song: Song)
    @Transaction
    @Query(value = "SELECT * FROM Music WHERE musicId=:musicId")
    fun getAllSong(musicId:Int): LiveData<SongPlaylist>
    @Query(value = "SELECT * FROM Song WHERE id=:id")
    fun getSongByID(id: Int): Song
}
