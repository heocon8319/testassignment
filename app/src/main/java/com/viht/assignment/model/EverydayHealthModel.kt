package com.viht.assignment.model

import android.os.Parcelable
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.util.DateUtils
import kotlinx.parcelize.Parcelize

@Parcelize
data class EverydayHealthModel(
    val activityClass: String?,
    val activityId: String?,
    val activitySubType: String?,
    val activityType: String?,
    val childName: String?,
    val endTime: String?,
    val referenceObj: RefObjectModel?,
    val remarks: String?,
    val schoolId: String?,
    val startTime: String?
) : Parcelable, BaseModel {
//    override val eventType = ModelType.EVERYDAY_HEALTH
//    override fun execute(jsonString: String?): BaseModel {
//        return Gson().fromJson(jsonString, EverydayHealthModel::class.java)
//    }

}

fun EverydayHealthModel.toEventRecycleItem(id: String, eventDate: String) = run {
    Event(
        id = id,
        title = this.childName ?: "",
        name = this.activityClass ?: "",
        dateTime = DateUtils.formatDateFromDateString(
            DateUtils.DATE_FORMAT_4,
            DateUtils.DATE_FORMAT_3,
            eventDate
        ) ?: "",
        clickAdd = false
    )
}