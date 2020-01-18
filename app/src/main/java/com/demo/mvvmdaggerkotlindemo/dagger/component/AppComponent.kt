package com.demo.mvvmdaggerkotlindemo.dagger.component

import android.app.Application

import com.demo.mvvmdaggerkotlindemo.dagger.builder.ActivityBuilder
import com.demo.mvvmdaggerkotlindemo.dagger.builder.FragmentBuilderModule
import com.demo.mvvmdaggerkotlindemo.dagger.module.AppModule
import com.demo.mvvmdaggerkotlindemo.dagger.module.DbModule
import com.demo.mvvmdaggerkotlindemo.dagger.module.ViewModelModule
import com.demo.mvvmdaggerkotlindemo.DemoApp

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Singleton
@Component(modules = [AppModule::class,
    AndroidInjectionModule::class,
    FragmentBuilderModule::class,
    ActivityBuilder::class,
    ViewModelModule::class,
    DbModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(demoApp: DemoApp)
}