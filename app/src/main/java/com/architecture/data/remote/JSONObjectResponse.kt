package com.architecture.data.remote

import com.google.gson.annotations.SerializedName

data class JSONObjectResponse<T>(
    @SerializedName("code") var code: Int,
    @SerializedName("success") var success: Boolean,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: T? = null
)