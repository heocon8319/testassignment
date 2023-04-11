package com.viht.assignment.ui.news.view.portfolioimage

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.R
import com.viht.assignment.ui.base.adapter.AdapterListener
import com.viht.assignment.ui.base.adapter.Cell
import com.viht.assignment.ui.base.adapter.RecyclerItem

object PortfolioImageCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is PortfolioImage
    }

    override fun type(): Int {
        return R.layout.layout_item_portfolio_image
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PortfolioImageViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        listener: AdapterListener?
    ) {
        if (holder is PortfolioImageViewHolder && item is PortfolioImage) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                listener?.listen(item)
            }
        }
    }

}