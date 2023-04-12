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
    var model: BaseModel = Gson().fromJson(eventSnapshot, EventModel::class.java)
    when (eventType) {
        "everydayHealth" -> model = Gson().fromJson(eventSnapshot, EverydayHealthModel::class.java)
        "checkOut", "checkIn" -> model = Gson().fromJson(eventSnapshot, CheckInOutModel::class.java)
        "portfolio" -> model = Gson().fromJson(eventSnapshot, PortfolioModel::class.java)
        "story_exported" -> model = Gson().fromJson(eventSnapshot, StoryExportedModel::class.java)
        "story_published" -> model = Gson().fromJson(eventSnapshot, StoryPublishedModel::class.java)
    }
    return NewsModel(
        eventDate = eventDate ?: "",
        eventDescription = eventDescription ?: "",
        model = model,
        eventType = eventType ?: "",
        insertedAt = insertedAt ?: "",
    )

}