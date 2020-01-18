package com.demo.mvvmdaggerkotlindemo.dagger.builder

import com.demo.mvvmdaggerkotlindemo.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {



    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): MainFragment

}
