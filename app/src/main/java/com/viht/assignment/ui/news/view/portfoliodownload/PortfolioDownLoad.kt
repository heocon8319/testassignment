package com.viht.assignment.ui.news.view.portfoliodownload

import com.viht.assignment.ui.base.adapter.AdapterClick
import com.viht.assignment.ui.base.adapter.RecyclerItem

data class PortfolioDownLoad(
    override val id: String,
    val text: String
) : RecyclerItem, AdapterClick