package com.demo.mvvmdaggerkotlindemo.dagger.module

import android.app.Application
import androidx.room.Room
import com.demo.mvvmdaggerkotlindemo.database.DemoAppDatabase
import com.demo.mvvmdaggerkotlindemo.database.dao.SampleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): DemoAppDatabase {
        return Room.databaseBuilder(application, DemoAppDatabase::class.java, "apl_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    //
    @Provides
    @Singleton
    internal fun provideSampleDao(database: DemoAppDatabase): SampleDao {
        return database.sampleDao()
    }


}
