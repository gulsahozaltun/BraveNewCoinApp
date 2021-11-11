package com.gulsahozaltun.bravenewcoinapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AssetDataModel(
    val id: String,
    val name: String,
    val slugName: String,
    val status: String,
    val symbol: String,
    val type: String,
    val url: String
):Serializable{}