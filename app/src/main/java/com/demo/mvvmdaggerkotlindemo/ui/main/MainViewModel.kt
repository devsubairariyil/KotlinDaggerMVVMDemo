package com.demo.mvvmdaggerkotlindemo.ui.main

import com.demo.mvvmdaggerkotlindemo.base.BaseViewModel
import com.demo.mvvmdaggerkotlindemo.logger.AplLogger
import com.demo.mvvmdaggerkotlindemo.database.dbhandler.SampleDBHandler
import javax.inject.Inject

class MainViewModel  @Inject constructor (val sampleDBHandler: SampleDBHandler,
                                          logger: AplLogger
): BaseViewModel(logger)
