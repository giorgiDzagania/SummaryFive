package com.exercise.summaryfive.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class NewCourse(
    val id: String,
    val icon_type: String,
    val duration: String,
    val main_color: String,
    val question: String,
    val title: String
)

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "new_courses") val newCourse: List<NewCourse>,
    @Json(name = "active_courses") val activeCourse: List<ActiveCourse>
)