package com.main.myapplication.room.song

import androidx.lifecycle.LiveData
import com.main.myapplication.room.music.MusicDao

class SongRepository(private val songDao: SongDao) {

    fun allSong(musicId: Int) = songDao.getAllSong(musicId)

    fun createSong(song: Song) {
        songDao.createSong(song)
    }

    fun getSongById(id: Int) {
        songDao.getSongByID(id)
    }
}
