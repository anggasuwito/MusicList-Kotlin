package com.main.myapplication.room.song

import androidx.room.*
import com.main.myapplication.room.music.Music

@Entity
class Song(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0,
    @ColumnInfo(name = "songMusicId")
    var songMusicId: Int,
    @ColumnInfo(name = "songName")
    var songName: String,
    @ColumnInfo(name = "songDuration")
    var songDuration: String
) {}

class SongPlaylist(
    @Embedded
    val music: Music,
    @Relation(
        parentColumn = "musicId",
        entityColumn = "songMusicId"
    )
    val songPlaylist: List<Song>
) {}