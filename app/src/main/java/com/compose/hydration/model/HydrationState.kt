package com.compose.hydration.model

data class HydrationState(
    val dailyGoal: Int = 2000,
    val unit: String = "ml",
    val container_small: Int = 200,
    val container_medium: Int = 400,
    val container_large: Int = 500,
)