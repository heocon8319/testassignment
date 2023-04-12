package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
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

    override fun execute(jsonString: String?): BaseModel {
        return Gson().fromJson(jsonString, CheckInOutModel::class.java)
    }

}