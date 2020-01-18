package com.demo.mvvmdaggerkotlindemo.database.dbhandler

import com.demo.mvvmdaggerkotlindemo.database.DemoAppDatabase
import com.demo.mvvmdaggerkotlindemo.database.dao.SampleDao
import com.demo.mvvmdaggerkotlindemo.database.entity.SampleEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleDBHandler @Inject
internal constructor(internal val sampleDao: SampleDao, database: DemoAppDatabase) :
    BaseDBHandler(database){

    suspend fun loadAll() : List<SampleEntity>  = sampleDao.loadAll()
}
