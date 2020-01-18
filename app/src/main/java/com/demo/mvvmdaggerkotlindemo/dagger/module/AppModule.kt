package com.demo.mvvmdaggerkotlindemo.dagger.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.demo.mvvmdaggerkotlindemo.logger.AplLogger
import com.demo.mvvmdaggerkotlindemo.logger.AplLoggerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app : Application):Context = app

    @Provides
    @Singleton
    fun provideAppLogger(): AplLogger = AplLoggerImpl()


    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

}
