package com.viht.assignment.ui.news.view.checkinout

import com.viht.assignment.ui.base.adapter.RecyclerItem

data class CheckInOut(
    override val id: String,
    val name: String,
    val type: String,
    val time: String,
    val image: String
) : RecyclerItem