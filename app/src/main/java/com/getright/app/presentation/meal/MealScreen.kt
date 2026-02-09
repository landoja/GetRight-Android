package com.getright.app.presentation.meal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealScreen(
    viewModel: MealViewModel = hiltViewModel()
) {
    val meals by viewModel.meals.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Get Right: Meal Log") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addMockMeal("Test Meal") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Meal")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(meals) { meal ->
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = meal.rawInput,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "${meal.macros.calories} kcal",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}