package com.viht.assignment.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.viht.assignment.model.News
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserTimeLineResponse(
    @SerializedName("__typename")
    val typename: String?,
    val eventDate: String?,
    val eventDescription: String?,
    val eventSnapshot: String?,
    val eventType: String?,
    val insertedAt: String?
) : Parcelable

fun UserTimeLineResponse.toNews() = News(
    eventDate = eventDate ?: "",
    eventDescription = eventDescription ?: "",
    eventSnapshot = eventSnapshot ?: "",
    eventType = eventType ?: "",
    insertedAt = insertedAt ?: "",
)