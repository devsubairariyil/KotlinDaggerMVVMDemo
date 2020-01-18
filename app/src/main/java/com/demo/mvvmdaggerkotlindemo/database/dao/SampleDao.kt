package com.demo.mvvmdaggerkotlindemo.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.demo.mvvmdaggerkotlindemo.database.entity.SampleEntity

@Dao
interface SampleDao : BaseDao<SampleEntity> {

    @Query("SELECT * FROM sample_entity")
    suspend fun loadAll(): List<SampleEntity>
}