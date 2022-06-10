package com.pride.testtrainee.Clases


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("images")
    val images: Images,
    @SerializedName("title")
    val title: String,
)

data class Images(
    @SerializedName("downsized")
    val downsized: Downsized,
)

data class Downsized(
    @SerializedName("url")
    val url: String
)