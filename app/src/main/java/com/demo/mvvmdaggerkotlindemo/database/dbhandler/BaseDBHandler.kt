package com.demo.mvvmdaggerkotlindemo.database.dbhandler

import com.demo.mvvmdaggerkotlindemo.database.DemoAppDatabase

abstract class BaseDBHandler(val database : DemoAppDatabase) {

    fun clearAllTables(){
        database.clearAllTables()
    }
}