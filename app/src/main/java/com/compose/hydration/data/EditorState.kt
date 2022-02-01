package com.compose.hydration.data

data class EditorState(
    val quantity: String = "2000",
    val unit: String = "ml",
    val container_small: Int = 200,
    val container_medium: Int = 400,
    val container_large: Int = 500,
    val setting: Setting = DailyGoal
)