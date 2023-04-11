package com.viht.assignment.ui.news.view.event

import com.viht.assignment.ui.base.adapter.RecyclerItem

data class Event(
    override val id: String,
    val title: String,
    val name: String,
    val dateTime: String,
    var clickAdd: Boolean
) : RecyclerItem