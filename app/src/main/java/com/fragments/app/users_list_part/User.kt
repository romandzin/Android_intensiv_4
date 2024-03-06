package com.fragments.app.users_list_part

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val photo: String,
    val name: String,
    val secondName: String,
    val phoneNumber: Int
): Parcelable
