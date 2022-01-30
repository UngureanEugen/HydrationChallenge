package com.compose.hydration.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hydrations")
data class Hydration(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    val quantity: Int,
    val dayOfYear: Int
)