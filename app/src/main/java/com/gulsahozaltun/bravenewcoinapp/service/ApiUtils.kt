package com.gulsahozaltun.bravenewcoinapp.service

import com.gulsahozaltun.bravenewcoinapp.service.RetrofitClient.Companion.getClient

class ApiUtils {

    companion object{
        val BASE_URL:String="https://bravenewcoin.p.rapidapi.com/"

        fun getCryptoApi():CryptoApi{
            return getClient(BASE_URL).create(CryptoApi::class.java)

        }

    }
}