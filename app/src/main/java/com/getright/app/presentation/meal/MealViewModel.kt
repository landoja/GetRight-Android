package com.getright.app.presentation.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.getright.app.data.local.entity.Macros
import com.getright.app.data.local.entity.MealEntity
import com.getright.app.data.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {

    val meals: StateFlow<List<MealEntity>> = repository.getAllMeals()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addMockMeal(input: String) {
        viewModelScope.launch {
            val dummyMacros = Macros(
                calories = 500,
                protein = 30,
                carbs = 45,
                fat = 20
            )
            repository.addMeal(input, dummyMacros)
        }
    }
}