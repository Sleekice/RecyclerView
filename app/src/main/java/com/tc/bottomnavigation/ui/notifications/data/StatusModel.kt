package com.tc.bottomnavigation.ui.notifications.data


import com.google.gson.annotations.SerializedName

data class StatusModel(
    @SerializedName("feedback")
    val feedback: String? = "",
    @SerializedName("sentCount")
    val sentCount: Int? = 0,
    @SerializedName("verified")
    val verified: Boolean? = false
)