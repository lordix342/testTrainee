package com.pride.testtrainee.Model

import com.pride.testtrainee.Clases.GetImage
import retrofit2.Call
import retrofit2.http.GET

interface GiphyInterface {
    @GET("trending?api_key=i2NxhnMDZe6vKdAjnlXEW3jUd8JbXp4m&limit=25&rating=g")
    fun getList(): Call<GetImage>
}