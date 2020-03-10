package com.example.noteapp19.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nota(
    @SerializedName("titulo") val titulo: String,
    @SerializedName("descricao") val descricao: String
): Parcelable