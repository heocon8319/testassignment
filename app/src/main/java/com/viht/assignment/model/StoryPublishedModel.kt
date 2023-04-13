package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImage
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryPublishedModel(
    @SerializedName("publisher_id")
    val publisherId: String?,
    @SerializedName("publisher_name")
    val publisherName: String?,
    @SerializedName("school_id")
    val schoolId: String?,
    @SerializedName("story_id")
    val storyId: String?,
    @SerializedName("story_image")
    val storyImage: String?,
    @SerializedName("story_name")
    val storyName: String?
) : Parcelable, BaseModel {
//    override val eventType = ModelType.STORY_PUBLISHED
//    override fun execute(jsonString: String?): BaseModel {
//        return Gson().fromJson(jsonString, StoryPublishedModel::class.java)
//    }

}

fun StoryPublishedModel.toPortfolioImageRecycleItem(id: String) = run {
    PortfolioImage(
        id = id,
        title = this.publisherName ?: "",
        name = this.storyName ?: "",
        image = this.storyImage ?: ""
    )
}
