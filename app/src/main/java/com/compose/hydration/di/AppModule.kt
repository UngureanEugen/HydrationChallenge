package com.compose.hydration.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.compose.hydration.data.HydrationRepository
import com.compose.hydration.utility.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideHydrationRepository(
        @ApplicationContext app: Context
    ): HydrationRepository = HydrationRepository(app.dataStore)
}

private val Context.dataStore by preferencesDataStore(name = Constants.PREFERENCES_NAME)

