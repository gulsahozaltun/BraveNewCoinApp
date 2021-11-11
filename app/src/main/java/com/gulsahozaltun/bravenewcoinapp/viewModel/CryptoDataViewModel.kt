package com.gulsahozaltun.bravenewcoinapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.bravenewcoinapp.model.AssetDataModel
import com.gulsahozaltun.bravenewcoinapp.model.Content
import com.gulsahozaltun.bravenewcoinapp.service.ApiUtils
import com.gulsahozaltun.bravenewcoinapp.service.CryptoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoDataViewModel:ViewModel() {
     val cryptoInterface:CryptoApi
     val assetList:MutableLiveData<List<AssetDataModel>>

    init {
        cryptoInterface=ApiUtils.getCryptoApi()
        assetList= MutableLiveData()
        loadAssets()
    }

/*    fun loadAssets():MutableLiveData<List<AssetDataModel>>{
        return assetList
    }*/

    fun loadAssets(){
        getAssets()
    }



     fun getAssets(){
        cryptoInterface.getAsset().enqueue(object :Callback<Content>{
            override fun onResponse(call: Call<Content>, response: Response<Content>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        val assets=response.body()!!.content
                        assetList.value=assets

                    }
                }
            }

            override fun onFailure(call: Call<Content>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }


}