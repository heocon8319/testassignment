package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoad
import com.viht.assignment.util.DateUtils
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryExportedModel(
    val exp: String?,
    @SerializedName("school_id")
    val schoolId: String?,
    val url: String?
) : Parcelable, BaseModel() {

//    override fun execute(jsonString: String?): BaseModel {
//        return Gson().fromJson(jsonString, StoryExportedModel::class.java)
//    }

}

fun StoryExportedModel.toPortfolioDownloadRecycleItem(id: String, eventDescription: String) = run {
    PortfolioDownLoad(
        id = id,
        type = eventDescription,
        name = this.url ?: "",
        clickDownload = false
    )
}