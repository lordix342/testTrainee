package com.pride.testtrainee.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pride.testtrainee.Clases.Data
import com.pride.testtrainee.Clases.GetImage
import com.pride.testtrainee.Model.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelBinding(application: Application) : AndroidViewModel(application) {
    private var repository = Repository()
    private var gifListSave: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    var gifList: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    var gifSelect: MutableLiveData<Data> = MutableLiveData()

    fun getListFromRepo() {
        viewModelScope.launch {
            repository.getList().enqueue(object : Callback<GetImage> {
                override fun onResponse(
                    call: Call<GetImage>,
                    response: Response<GetImage>
                ) {
                    gifListSave.value = response.body()?.data
                    Log.d("asdfgsdf", gifListSave.value.toString())
                    gifList.value = gifListSave.value
                }

                override fun onFailure(call: Call<GetImage>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }

    fun selectGif(gif: Data) {
        gifSelect.value = gif
    }
}