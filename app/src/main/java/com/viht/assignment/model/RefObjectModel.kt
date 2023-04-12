package com.viht.assignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RefObjectModel(
    val type: String?,
    val value: String?
) : Parcelable