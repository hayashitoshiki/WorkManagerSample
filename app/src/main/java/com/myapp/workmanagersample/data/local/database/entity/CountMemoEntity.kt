package com.myapp.workmanagersample.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count_memo")
data class CountMemoEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "count") val count: Int
)