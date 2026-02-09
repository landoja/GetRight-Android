package com.getright.app.data.repository

import com.getright.app.data.local.entity.Macros
import com.getright.app.data.local.entity.MealEntity
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    fun getAllMeals(): Flow<List<MealEntity>>

    suspend fun addMeal(rawInput: String, macros: Macros)

    suspend fun getUnsyncedMeals(): List<MealEntity>
}