package com.getright.app.di

import android.content.Context
import androidx.room.Room
import com.getright.app.data.local.AppDatabase
import com.getright.app.data.local.dao.MealDao
import com.getright.app.data.repository.MealRepository
import com.getright.app.data.repository.MealRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "getright_db"
        ).build()
    }

    @Provides
    fun provideMealDao(database: AppDatabase): MealDao {
        return database.mealDao()
    }

    @Provides
    @Singleton
    fun provideMealRepository(repository: MealRepositoryImpl): MealRepository {
        return repository
    }
}