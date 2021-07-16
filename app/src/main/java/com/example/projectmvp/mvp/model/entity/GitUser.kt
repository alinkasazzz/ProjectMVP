package com.example.projectmvp.mvp.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  GitUser (
    val name: String,
    val login: String
): Parcelable