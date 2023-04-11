package com.viht.assignment.data.remote.response

import android.os.Parcelable
import com.viht.assignment.model.News
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
    val userTimeline: ArrayList<UserTimeLineResponse>?
): Parcelable

fun NewsResponse.toConvertedData(): List<News> {
    val outputList: MutableList<News> = mutableListOf()
    this.userTimeline?.forEach {  response ->
        outputList.add(response.toNews())
    }
    return outputList
}