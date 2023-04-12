package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
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

fun News.toNewsModel(): NewsModel {
    val className = when (eventType) {
        "event" -> EventModel::class.java
        "everydayHealth" -> EverydayHealthModel::class.java
        "checkOut", "checkIn" -> CheckInOutModel::class.java
        "portfolio" -> PortfolioModel::class.java
        "story_exported" -> StoryExportedModel::class.java
        "story_published" -> StoryPublishedModel::class.java
        else -> throw IllegalStateException("Unknown class name")
    }

    return NewsModel(
        eventDate = eventDate ?: "",
        eventDescription = eventDescription ?: "",
        model = Gson().fromJson(eventSnapshot, className),
        eventType = eventType ?: "",
        insertedAt = insertedAt ?: "",
    )
}