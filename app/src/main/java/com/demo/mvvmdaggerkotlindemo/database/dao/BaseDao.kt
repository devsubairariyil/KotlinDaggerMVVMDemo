package com.demo.mvvmdaggerkotlindemo.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {


        @Insert
        fun insert(obj: T) : Long

        @Insert
        fun insert(vararg obj: T)

        @Insert
        fun insert(list : List<T>)

        @Update
        fun update(obj: T)

        @Delete
        fun delete(obj: T)


}