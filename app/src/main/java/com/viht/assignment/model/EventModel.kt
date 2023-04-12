package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
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

    override fun execute(jsonString: String?): BaseModel {
        return Gson().fromJson(jsonString, EventModel::class.java)
    }

}