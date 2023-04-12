package com.viht.assignment.model

import android.os.Parcelable
import com.google.gson.Gson
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

    override fun execute(jsonString: String?): BaseModel {
        return Gson().fromJson(jsonString, PortfolioModel::class.java)
    }

}