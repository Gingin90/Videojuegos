package com.example.videojuegos.data.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.superheroescomics.data.local.detail.SuperHeroDetailEntity
import com.example.videojuegos.data.data.local.list.VideojuegoEntity

@Database(entities = [VideojuegoEntity::class, SuperHeroDetailEntity::class], version = 1)
abstract class VideojuegosDatabase : RoomDatabase() {

    abstract fun getSuperHeroesDAO(): VideojuegosDAO

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
                    "super_heroes_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}