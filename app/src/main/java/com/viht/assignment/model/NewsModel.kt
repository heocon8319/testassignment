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
        "event" -> (model as EventModel).toEventRecycleItem(id, eventDate ?: "")
        "everydayHealth" -> (model as EverydayHealthModel).toEventRecycleItem(id, eventDate ?: "")
        "checkOut", "checkIn" -> (model as CheckInOutModel).toCheckInOutRecycleItem(id, eventType)
        "portfolio" -> (model as PortfolioModel).toPortfolioImageRecycleItem(id)
        "story_published" -> (model as StoryPublishedModel).toPortfolioImageRecycleItem(id)
        "story_exported" -> (model as StoryExportedModel).toPortfolioDownloadRecycleItem(
            id,
            eventDescription ?: ""
        )
        else -> throw IllegalStateException("Unknown event type recycle item")
    }
}