package com.example.data.remote.dtos

import com.example.domain.models.Response
import com.google.gson.annotations.SerializedName

data class ResponseDto(
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

fun ResponseDto.toDomain() : Response{
    return Response(originalTitle, title, id, image, url)
}