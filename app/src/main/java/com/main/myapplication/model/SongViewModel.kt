package com.main.myapplication.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.main.myapplication.room.AppRoomDatabase
import com.main.myapplication.room.song.Song
import com.main.myapplication.room.song.SongPlaylist
import com.main.myapplication.room.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val songRepository: SongRepository

    init {
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        songRepository = SongRepository(songDao)

    }

    fun songList(musicId: Int) = songRepository.allSong(musicId)

    fun addSongList(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            songRepository.createSong(song)
        }
    }
}