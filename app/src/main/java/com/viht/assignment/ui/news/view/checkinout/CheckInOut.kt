package com.viht.assignment.ui.news.view.checkinout

import com.viht.assignment.ui.base.adapter.AdapterClick
import com.viht.assignment.ui.base.adapter.RecyclerItem

data class CheckInOut(
    override val id: String,
    val text: String
) : RecyclerItem, AdapterClick