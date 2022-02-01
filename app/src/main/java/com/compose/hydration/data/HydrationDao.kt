package com.compose.hydration.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface HydrationDao {
    @Query("SELECT * FROM hydrations ORDER BY day DESC")
    fun getAll(): Flow<List<Hydration>>

    @Query("SELECT * FROM hydrations WHERE day = :date")
    fun findHydration(date: Date): Flow<Hydration>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: Hydration)

}