package com.viht.assignment.data.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse(
    val data: NewsResponse?
): Parcelable