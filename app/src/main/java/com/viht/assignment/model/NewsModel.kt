package com.viht.assignment.model

import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.checkinout.CheckInOut
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoad
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImage
import com.viht.assignment.util.DateUtils

data class NewsModel(
    val eventDate: String?,
    val eventDescription: String?,
    val model: BaseModel?,
    val eventType: String?,
    val insertedAt: String?
)

fun NewsModel.toRecycleItem(): RecyclerItem {
    val id = System.currentTimeMillis().toString()
    return when (eventType) {
        "event" -> {
            val title = (model as EventModel).schoolName ?: model.childName
            Event(
                id = id,
                title = title ?: "",
                name = model.eventTitle ?: "",
                dateTime = DateUtils.formatDateFromDateString(
                    DateUtils.DATE_FORMAT_4,
                    DateUtils.DATE_FORMAT_3,
                    eventDate
                ) ?: "",
                clickAdd = false
            )
        }
        "everydayHealth" -> {
            Event(
                id = id,
                title = (model as EverydayHealthModel).childName ?: "",
                name = model.activityClass ?: "",
                dateTime = DateUtils.formatDateFromDateString(
                    DateUtils.DATE_FORMAT_4,
                    DateUtils.DATE_FORMAT_3,
                    eventDate
                ) ?: "",
                clickAdd = false
            )
        }
        "checkOut", "checkIn" -> {
            CheckInOut(
                id = id,
                name = (model as CheckInOutModel).msgParams?.childName ?: "",
                type = eventType,
                time = DateUtils.formatDateFromDateString(
                    DateUtils.DATE_FORMAT_5,
                    DateUtils.DATE_FORMAT_1, model.msgParams?.checkInDate
                ) ?: "",
                image = model.checkInThumb ?: ""
            )
        }
        "portfolio" -> {
            PortfolioImage(
                id = id,
                title = (model as PortfolioModel).schoolName ?: "",
                name = model.teacherName ?: "",
                image = model.imageUrl ?: ""
            )
        }
        "story_published" -> {
            PortfolioImage(
                id = id,
                title = (model as StoryPublishedModel).publisherName ?: "",
                name = model.storyName ?: "",
                image = model.storyImage ?: ""
            )
        }
        "story_exported" -> {
            PortfolioDownLoad(
                id = id,
                type = eventDescription ?: "",
                name = (model as StoryExportedModel).url ?: "",
                clickDownload = false
            )
        }
        else -> {
            val title = (model as EventModel).schoolName ?: model.childName
            Event(
                id = id,
                title = title ?: "",
                name = model.eventTitle ?: "",
                dateTime = DateUtils.formatDateFromDateString(
                    DateUtils.DATE_FORMAT_4,
                    DateUtils.DATE_FORMAT_3,
                    eventDate
                ) ?: "",
                clickAdd = false
            )
        }
    }
}