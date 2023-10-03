package com.tc.bottomnavigation.ui.notifications.data


import com.google.gson.annotations.SerializedName

data class CatImageItemModel(
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("width")
    val width: Int? = 0
)