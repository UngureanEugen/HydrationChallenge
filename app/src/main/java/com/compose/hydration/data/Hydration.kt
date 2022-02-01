package com.compose.hydration.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.math.roundToInt

@Entity(tableName = "hydrations")
data class Hydration(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    val quantity: Int,
    val day: Date
)

fun Hydration.dailyPercentage(dailyGoal: Float): Int {
    return ((quantity / dailyGoal) * 100).roundToInt()
}