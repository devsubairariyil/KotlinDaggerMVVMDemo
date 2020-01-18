package com.demo.mvvmdaggerkotlindemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.mvvmdaggerkotlindemo.database.dao.SampleDao
import com.demo.mvvmdaggerkotlindemo.database.entity.SampleEntity


@Database(
    entities =
    [SampleEntity::class
       ]
    , version = 1,
    exportSchema = false
)
abstract class DemoAppDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao


}
