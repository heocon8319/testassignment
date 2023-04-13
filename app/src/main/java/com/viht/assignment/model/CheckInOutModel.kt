package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.viht.assignment.ui.news.view.checkinout.CheckInOut
import com.viht.assignment.util.DateUtils
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckInOutModel(
    @SerializedName("checkinThumb")
    val checkInThumb: String?,
    @SerializedName("checkinUrl")
    val checkInUrl: String?,
    val msgParams: MsgParamModel?,
    val referenceObj: RefObjectModel?,
    val schoolId: String?
) : Parcelable, BaseModel {
//    override val eventType = ModelType.CHECK_IN_OUT
//    override fun execute(jsonString: String?): BaseModel {
//        return Gson().fromJson(jsonString, CheckInOutModel::class.java)
//    }

}

fun CheckInOutModel.toCheckInOutRecycleItem(id: String, eventType: String) = run {
    CheckInOut(
        id = id,
        name = this.msgParams?.childName ?: "",
        type = eventType,
        time = DateUtils.formatDateFromDateString(
            DateUtils.DATE_FORMAT_5,
            DateUtils.DATE_FORMAT_1, this.msgParams?.checkInDate
        ) ?: "",
        image = this.checkInThumb ?: ""
    )
}