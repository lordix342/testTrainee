package com.pride.testtrainee.Clases


import com.google.gson.annotations.SerializedName

data class GetImage(
    @SerializedName("data")
    val `data`: ArrayList<Data>,
)