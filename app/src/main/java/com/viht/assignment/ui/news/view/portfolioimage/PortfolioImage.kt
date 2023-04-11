package com.viht.assignment.ui.news.view.portfolioimage

import com.viht.assignment.ui.base.adapter.AdapterClick
import com.viht.assignment.ui.base.adapter.RecyclerItem

data class PortfolioImage(
    override val id: String,
    val text: String
) : RecyclerItem, AdapterClick