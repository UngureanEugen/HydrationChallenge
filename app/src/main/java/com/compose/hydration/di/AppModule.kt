package com.compose.hydration.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.compose.hydration.data.AppDatabase
import com.compose.hydration.data.HydrationDao
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
        @ApplicationContext app: Context,
        hydrationDao: HydrationDao
    ): HydrationRepository = HydrationRepository(app.dataStore, hydrationDao)


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideHydrationDao(appDatabase: AppDatabase): HydrationDao {
        return appDatabase.hydrationDao()
    }
}

private val Context.dataStore by preferencesDataStore(name = Constants.PREFERENCES_NAME)

