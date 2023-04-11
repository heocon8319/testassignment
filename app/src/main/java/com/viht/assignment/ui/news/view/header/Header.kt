package com.viht.assignment.ui.news.view.header

import com.viht.assignment.ui.base.adapter.AdapterClick
import com.viht.assignment.ui.base.adapter.RecyclerItem

data class Header(
    override val id: String,
    val date: String
) : RecyclerItem, AdapterClick