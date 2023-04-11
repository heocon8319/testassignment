package com.viht.assignment.ui.news

import com.viht.assignment.ui.base.adapter.AdapterListener
import com.viht.assignment.ui.base.adapter.BaseListAdapter
import com.viht.assignment.ui.news.view.checkinout.CheckInOutCell
import com.viht.assignment.ui.news.view.event.EventCell
import com.viht.assignment.ui.news.view.header.HeaderCell
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoadCell
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImageCell

class NewsAdapter(listener: AdapterListener) : BaseListAdapter(
    CheckInOutCell, EventCell, HeaderCell, PortfolioDownLoadCell, PortfolioImageCell,
    listener = listener
)