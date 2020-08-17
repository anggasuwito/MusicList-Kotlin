package com.main.myapplication.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.main.myapplication.classes.Music

class MusicViewModel : ViewModel() {
    val musicList = mutableListOf<Music>(
        Music("NOAH", "Bintang di Surga", "https://cdns.klimg.com/kapanlagi.com/wallpaper/img/noah-6218.jpg"),
        Music("Camilla Cabello", "Havana", "https://static.billboard.com/files/media/Camila-Cabello-press-by-Amanda-Charchian-2020-billboard-1548-1024x677.jpg"),
        Music("Iwan Fals", "Wakil Rakyat", "https://cdn.akurat.co/images/uploads/images/akurat_20190207110219_zrfI6q.jpg")
    )

    val musicLiveData: MutableLiveData<MutableList<Music>> = MutableLiveData(musicList)

    fun addMusicList(musicArtistName: String, musicTitle: String, musicImage: String) {
        musicList.add(
            Music(
                musicArtistName,
                musicTitle,
                musicImage
            )
        )
        musicLiveData.value = musicList
    }
}