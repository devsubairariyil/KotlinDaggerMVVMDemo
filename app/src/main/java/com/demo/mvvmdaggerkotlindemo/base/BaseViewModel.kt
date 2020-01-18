package com.demo.mvvmdaggerkotlindemo.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.mvvmdaggerkotlindemo.logger.AplLogger

abstract class BaseViewModel(val logger: AplLogger) : ViewModel(){

    val newPlayerNotifier = MutableLiveData<Long>()
    val newTeamNotifier = MutableLiveData<Long>()

    open fun onViewStarted(){

    }


}
