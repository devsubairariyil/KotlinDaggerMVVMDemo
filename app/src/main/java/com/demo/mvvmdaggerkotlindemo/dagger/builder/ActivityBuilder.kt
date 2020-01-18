package com.demo.mvvmdaggerkotlindemo.dagger.builder
import com.demo.mvvmdaggerkotlindemo.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity (): MainActivity
}
