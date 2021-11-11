package com.gulsahozaltun.bravenewcoinapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gulsahozaltun.bravenewcoinapp.model.AssetDataModel
import com.gulsahozaltun.bravenewcoinapp.model.Content
import com.gulsahozaltun.bravenewcoinapp.service.CryptoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoDataViewModel:ViewModel() {

    var job : Job? = null

    val assets = MutableLiveData<List<AssetDataModel>>()
    val assetError = MutableLiveData<Boolean>()
    val assetLoading = MutableLiveData<Boolean>()

    fun downloadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://bravenewcoin.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)

        assetLoading.value = true
        job = viewModelScope.launch(context = Dispatchers.IO) {

            val response = retrofit.getAsset()

            withContext(Dispatchers.Main) {

                if(response.isSuccessful) {
                    response.body()?.let {
                        assets.value = it.content
                        assetLoading.value = false
                    }
                } else {
                    assetError.value = true
                    assetLoading.value = false
                }
            }
        }
    }



}

