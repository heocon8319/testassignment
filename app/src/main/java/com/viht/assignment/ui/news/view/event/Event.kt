package com.viht.assignment.ui.news.view.event

import com.viht.assignment.ui.base.adapter.AdapterClick
import com.viht.assignment.ui.base.adapter.RecyclerItem

data class Event(
    override val id: String,
    val text: String
) : RecyclerItem, AdapterClick