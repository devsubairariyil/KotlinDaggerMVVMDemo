package com.demo.mvvmdaggerkotlindemo.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.demo.mvvmdaggerkotlindemo.base.BaseViewModelFactory
import com.demo.mvvmdaggerkotlindemo.dagger.module.ViewModelKey
import com.demo.mvvmdaggerkotlindemo.ui.main.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {


    @Binds
    internal abstract fun bindsViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel


}
