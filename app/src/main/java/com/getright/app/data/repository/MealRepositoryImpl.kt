package com.getright.app.data.repository

import com.getright.app.data.local.dao.MealDao
import com.getright.app.data.local.entity.Macros
import com.getright.app.data.local.entity.MealEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealDao: MealDao
) : MealRepository {

    override fun getAllMeals(): Flow<List<MealEntity>> {
        return mealDao.getAllMeals()
    }

    override suspend fun addMeal(rawInput: String, macros: Macros) {
        val newMeal = MealEntity(
            id = UUID.randomUUID().toString(),
            rawInput = rawInput,
            timestamp = System.currentTimeMillis(),
            isSynced = false,
            macros = macros
        )
        mealDao.insertMeal(newMeal)
    }

    override suspend fun getUnsyncedMeals(): List<MealEntity> = mealDao.getUnsyncedMeals()
}