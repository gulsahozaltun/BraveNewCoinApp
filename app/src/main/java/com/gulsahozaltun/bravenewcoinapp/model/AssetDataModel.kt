package com.gulsahozaltun.bravenewcoinapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AssetDataModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slugName")
    val slugName: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type:")
    val type: String,
    @SerializedName("url")
    val url: String
):Serializable