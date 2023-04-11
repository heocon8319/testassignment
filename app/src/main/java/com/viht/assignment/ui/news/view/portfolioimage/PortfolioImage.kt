package com.viht.assignment.ui.news.view.portfolioimage

import com.viht.assignment.ui.base.adapter.RecyclerItem

data class PortfolioImage(
    override val id: String,
    val title: String,
    val name: String,
    val image: String
) : RecyclerItem