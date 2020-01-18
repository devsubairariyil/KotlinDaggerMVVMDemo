package com.demo.mvvmdaggerkotlindemo.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "sample_entity")
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var sampleData: String? = null
)