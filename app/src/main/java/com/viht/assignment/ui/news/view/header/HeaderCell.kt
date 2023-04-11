package com.viht.assignment.ui.news.view.header

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.R
import com.viht.assignment.ui.base.adapter.Cell
import com.viht.assignment.ui.base.adapter.RecyclerItem

object HeaderCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is Header
    }

    override fun type(): Int {
        return R.layout.layout_item_header
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return HeaderViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClicked: (RecyclerItem) -> Unit
    ) {
        if (holder is HeaderViewHolder && item is Header) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClicked?.invoke(item)
            }
        }
    }

}