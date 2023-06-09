package com.example.presentation.models

import com.example.domain.models.Response
import com.google.gson.annotations.SerializedName

data class ResponseUI(
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("url")
    val url: String = ""
)

fun Response.toUI(): ResponseUI {
    return ResponseUI(originalTitle, title, id, image, url)
}