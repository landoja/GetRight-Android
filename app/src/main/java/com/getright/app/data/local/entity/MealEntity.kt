package com.getright.app.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey
    val id: String,
    val rawInput: String,
    val timestamp: Long,
    val isSynced: Boolean = false,
    @Embedded
    val macros: Macros
)

data class Macros(
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fat: Int
)