package com.example.practicetest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Entity::class], version = 1)
abstract class PracDatabase : RoomDatabase() {

    abstract fun pracDao() : PracDao

    companion object {
        @Volatile // ensure no cache
        private var INSTANCE: PracDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PracDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PracDatabase::class.java, // Change this to your RoomDatabase class
                    "Prac_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
