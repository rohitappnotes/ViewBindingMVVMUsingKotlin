package com.mirza.international.model;

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    @SerializedName("usr_ID") var id: String? = null,
    @SerializedName("usr_Email") var email: String? = null,
    @SerializedName("usr_phn") var phoneNumber: String? = null,
    @SerializedName("usr_Pass") var password: String? = null,
    @SerializedName("usr_EmplyID") var employeeId: String? = null,
    @SerializedName("fcm_token") var fcmToken: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
) : Parcelable