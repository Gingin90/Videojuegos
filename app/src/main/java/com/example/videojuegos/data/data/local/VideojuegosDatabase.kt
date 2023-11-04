package com.example.videojuegos.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.videojuegos.data.data.local.detail.VideojuegosDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity
import com.example.videojuegos.data.local.VideojuegosDAO
import com.example.videojuegos.data.local.detail.VideojuegosDetailEntity
import com.example.videojuegos.data.local.list.VideojuegoEntity

@Database(entities = [VideojuegoEntity::class, VideojuegosDetailEntity::class], version = 1)
abstract class VideojuegosDatabase : RoomDatabase() {

    abstract fun getVideojuegosDAO(): VideojuegosDAO

    companion object {
        @Volatile
        private var INSTANCE: VideojuegosDatabase? = null

        fun getDataBase(context: Context): VideojuegosDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VideojuegosDatabase::class.java,
                    "video_juegos_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}