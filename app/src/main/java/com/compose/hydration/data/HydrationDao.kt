package com.compose.hydration.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HydrationDao {
    @Query("SELECT * FROM hydrations ORDER BY dayOfYear ")
    fun getEntries(): Flow<List<Hydration>>
}