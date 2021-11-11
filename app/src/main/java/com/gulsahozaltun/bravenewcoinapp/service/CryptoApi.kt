package com.gulsahozaltun.bravenewcoinapp.service

import com.gulsahozaltun.bravenewcoinapp.model.AssetDataModel
import com.gulsahozaltun.bravenewcoinapp.model.Content
import com.gulsahozaltun.bravenewcoinapp.model.ContentMarket
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    //https://bravenewcoin.p.rapidapi.com/asset/?rapidapi-key=094d10d1b4mshe6b0e51ddbc89d8p1913e2jsn6c5ee93ebfe4

    @GET("asset/?rapidapi-key=094d10d1b4mshe6b0e51ddbc89d8p1913e2jsn6c5ee93ebfe4")
    suspend fun getAsset():Response<Content>

    @GET("asset/{id}")
    suspend fun getAssetDetail(@Path("id")id:String):Single<AssetDataModel>

}