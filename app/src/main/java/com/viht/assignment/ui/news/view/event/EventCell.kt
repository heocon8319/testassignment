package com.viht.assignment.ui.news.view.event

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.R
import com.viht.assignment.ui.base.adapter.Cell
import com.viht.assignment.ui.base.adapter.RecyclerItem

object EventCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is Event
    }

    override fun type(): Int {
        return R.layout.layout_item_event
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return EventViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClicked: (RecyclerItem) -> Unit
    ) {
        if (holder is EventViewHolder && item is Event) {
            item.clickAdd = false
            holder.bind(item)

            holder.itemView.setOnClickListener {
                item.clickAdd = false
                onItemClicked?.invoke(item)
            }

            holder.binding.llAdd.setOnClickListener {
                item.clickAdd = true
                onItemClicked?.invoke(item)
            }
        }
    }

}