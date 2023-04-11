package com.viht.assignment.ui.news

import com.viht.assignment.ui.base.adapter.BaseListAdapter
import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.checkinout.CheckInOutCell
import com.viht.assignment.ui.news.view.event.EventCell
import com.viht.assignment.ui.news.view.header.HeaderCell
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoadCell
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImageCell

class NewsAdapter(onItemClicked: (RecyclerItem) -> Unit) : BaseListAdapter(
    CheckInOutCell, EventCell, HeaderCell, PortfolioDownLoadCell, PortfolioImageCell,
    onItemClicked = onItemClicked
)