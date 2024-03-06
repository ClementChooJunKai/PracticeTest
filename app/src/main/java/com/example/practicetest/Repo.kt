package com.example.practicetest

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class Repo(private val Dao: PracDao)  {



    val numbers: Flow<List<Entity>> = Dao.getAllNumbers()

    @WorkerThread
    suspend fun insert(entityNum: Entity) {
      Dao.insert(entityNum)
    }

    @WorkerThread
    suspend fun update(entityNum: Entity) {
        Dao.update(entityNum)
    }

    @WorkerThread
    suspend fun deleteAll(){
        Dao.deleteAll()
    }


}