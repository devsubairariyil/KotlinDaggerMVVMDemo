package com.demo.mvvmdaggerkotlindemo

import android.app.Application
import com.demo.mvvmdaggerkotlindemo.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class DemoApp :Application() , HasAndroidInjector {

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        plantTimberTree()

    }

    fun plantTimberTree(){

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}