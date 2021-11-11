package com.gulsahozaltun.bravenewcoinapp.service

import com.gulsahozaltun.bravenewcoinapp.model.Content
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    //https://bravenewcoin.p.rapidapi.com/asset/?rapidapi-key=094d10d1b4mshe6b0e51ddbc89d8p1913e2jsn6c5ee93ebfe4

    @GET("asset/?rapidapi-key=094d10d1b4mshe6b0e51ddbc89d8p1913e2jsn6c5ee93ebfe4")
     fun getAsset(): Call<Content>

}