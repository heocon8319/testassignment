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

fun News.toNewsModel() = run {
    val className = when (eventType) {
        ModelType.EVENT.type-> EventModel::class.java
        ModelType.EVERYDAY_HEALTH.type -> EverydayHealthModel::class.java
        ModelType.CHECK_IN.type, ModelType.CHECK_OUT.type -> CheckInOutModel::class.java
        ModelType.PORTFOLIO.type -> PortfolioModel::class.java
        ModelType.STORY_EXPORTED.type -> StoryExportedModel::class.java
        ModelType.STORY_PUBLISHED.type -> StoryPublishedModel::class.java
        else -> throw IllegalStateException("Unknown class name")
    }

    NewsModel(
        eventDate = eventDate ?: "",
        eventDescription = eventDescription ?: "",
        model = Gson().fromJson(eventSnapshot, className),
        eventType = eventType ?: "",
        insertedAt = insertedAt ?: "",
    )
}