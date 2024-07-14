package com.example.myproject_kelvin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Karakter(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable
