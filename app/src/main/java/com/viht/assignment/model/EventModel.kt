package com.viht.assignment.model

import android.os.Parcelable
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.util.DateUtils
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventModel(
    val childId: String?,
    val childName: String?,
    val eventDate: String?,
    val eventTitle: String?,
    val schoolId: String?,
    val schoolName: String?
) : Parcelable, BaseModel {
//    override val eventType = ModelType.EVENT
//    override fun execute(jsonString: String?): BaseModel {
//        return Gson().fromJson(jsonString, EventModel::class.java)
//    }
}

fun EventModel.toEventRecycleItem(id: String, eventDate: String) = run {
    val title = this.schoolName ?: this.childName
    Event(
        id = id,
        title = title ?: "",
        name = this.eventTitle ?: "",
        dateTime = DateUtils.formatDateFromDateString(
            DateUtils.DATE_FORMAT_4,
            DateUtils.DATE_FORMAT_3,
            eventDate
        ) ?: "",
        clickAdd = false
    )
}