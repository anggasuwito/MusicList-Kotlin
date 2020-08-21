package com.main.myapplication.model

import android.app.Application
import androidx.lifecycle.*
import com.main.myapplication.room.AppRoomDatabase
import com.main.myapplication.room.music.Music
import com.main.myapplication.room.music.MusicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MusicRepository
    val musicList: LiveData<List<Music>>

    init {
        val musicDao = AppRoomDatabase.getDatabaseInstance(application).musicDao()
        repository = MusicRepository(musicDao)
        musicList = repository.allMusic
    }

    fun addMusicList(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createMusic(music)
        }
    }
}