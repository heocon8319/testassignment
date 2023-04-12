package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryExportedModel(
    val exp: String?,
    @SerializedName("school_id")
    val schoolId: String?,
    val url: String?
) : Parcelable, BaseModel {

    override fun execute(jsonString: String?): BaseModel {
        return Gson().fromJson(jsonString, StoryExportedModel::class.java)
    }

}