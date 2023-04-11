package com.viht.assignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val eventDate: String?,
    val eventDescription: String?,
    val eventSnapshot: String?,
    val eventType: String?,
    val insertedAt: String?
) : Parcelable {

    fun areSameContent(other: News): Boolean {
        return eventDate == other.eventDate
                && eventDescription == other.eventDescription
                && eventSnapshot == other.eventSnapshot
                && eventType == other.eventType
                && insertedAt == other.insertedAt
    }
}