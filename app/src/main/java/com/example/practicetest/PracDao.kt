package com.example.practicetest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface PracDao {

    @Query("SELECT * FROM Practice_table")
    fun getAllNumbers(): Flow<List<Entity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entityDigit: Entity)

    @Update
    suspend fun update(entityDigit: Entity)

    @Query("DELETE FROM Practice_table")
    suspend fun deleteAll()

}