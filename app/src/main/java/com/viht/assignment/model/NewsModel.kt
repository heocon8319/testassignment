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
        ModelType.EVENT.type -> (model as EventModel).toEventRecycleItem(id, eventDate ?: "")
        ModelType.EVERYDAY_HEALTH.type -> (model as EverydayHealthModel).toEventRecycleItem(
            id,
            eventDate ?: ""
        )
        ModelType.CHECK_OUT.type, ModelType.CHECK_IN.type -> (model as CheckInOutModel).toCheckInOutRecycleItem(
            id,
            eventType
        )
        ModelType.PORTFOLIO.type -> (model as PortfolioModel).toPortfolioImageRecycleItem(id)
        ModelType.STORY_PUBLISHED.type -> (model as StoryPublishedModel).toPortfolioImageRecycleItem(
            id
        )
        ModelType.STORY_EXPORTED.type -> (model as StoryExportedModel).toPortfolioDownloadRecycleItem(
            id,
            eventDescription ?: ""
        )
        else -> throw IllegalStateException("Unknown event type recycle item")
    }
}