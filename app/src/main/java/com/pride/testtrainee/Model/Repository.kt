package com.pride.testtrainee.Model

import com.pride.testtrainee.Clases.GetImage
import com.pride.testtrainee.RertofitInstance
import retrofit2.Call

class Repository {
    fun getList() : Call<GetImage> {
        return RertofitInstance.api.getList()
    }
}