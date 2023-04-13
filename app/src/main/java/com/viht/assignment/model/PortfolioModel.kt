package com.viht.assignment.model

import android.os.Parcelable
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImage
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortfolioModel(
    val albumId: String?,
    val albumName: String?,
    val caption: String?,
    val childId: String?,
    val childName: String?,
    val fileId: String?,
    val imageUrl: String?,
    val referenceObj: RefObjectModel?,
    val schoolId: String?,
    val schoolName: String?,
    val teacherName: String?
) : Parcelable, BaseModel {
//    override val eventType = ModelType.PORTFOLIO
//    override fun execute(jsonString: String?): BaseModel {
//        return Gson().fromJson(jsonString, PortfolioModel::class.java)
//    }

}

fun PortfolioModel.toPortfolioImageRecycleItem(id: String) = run {
    PortfolioImage(
        id = id,
        title = this.schoolName ?: "",
        name = this.teacherName ?: "",
        image = this.imageUrl ?: ""
    )
}