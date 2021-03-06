package com.compose.hydration.data

data class HydrationState(
    val dailyGoal: Int = 2000,
    val units: String = "ml",
    val containerSmall: Int = 200,
    val containerMedium: Int = 400,
    val containerLarge: Int = 500,
    val currentHydration: Hydration? = null
)