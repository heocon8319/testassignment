package com.viht.assignment.ui.news.view.portfoliodownload

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.R
import com.viht.assignment.ui.base.adapter.Cell
import com.viht.assignment.ui.base.adapter.RecyclerItem


object PortfolioDownLoadCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is PortfolioDownLoad
    }

    override fun type(): Int {
        return R.layout.layout_item_portfolio_download
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PortfolioDownLoadViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClicked: (RecyclerItem) -> Unit
    ) {
        if (holder is PortfolioDownLoadViewHolder && item is PortfolioDownLoad) {
            item.clickDownload = false
            holder.bind(item)

            holder.itemView.setOnClickListener {
                item.clickDownload = false
                onItemClicked?.invoke(item)
            }

            holder.binding.llDownload.setOnClickListener {
                item.clickDownload = true
                onItemClicked?.invoke(item)
            }
        }
    }

}