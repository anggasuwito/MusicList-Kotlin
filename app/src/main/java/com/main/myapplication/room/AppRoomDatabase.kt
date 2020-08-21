package com.main.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.myapplication.room.music.Music
import com.main.myapplication.room.music.MusicDao
import com.main.myapplication.room.song.Song
import com.main.myapplication.room.song.SongDao
import com.main.myapplication.room.song.SongPlaylist

@Database(entities = arrayOf(Music::class, Song::class), version = 1, exportSchema = false)
public abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
    abstract fun songDao(): SongDao

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null
        fun getDatabaseInstance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) {
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room
                .databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "music_database"
                )
                .fallbackToDestructiveMigration()
                .build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}