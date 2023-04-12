package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
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

    override fun execute(jsonString: String?): BaseModel {
        return Gson().fromJson(jsonString, EverydayHealthModel::class.java)
    }

}