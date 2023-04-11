package com.viht.assignment.ui.news.view.checkinout

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.R
import com.viht.assignment.ui.base.adapter.Cell
import com.viht.assignment.ui.base.adapter.RecyclerItem

object CheckInOutCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is CheckInOut
    }

    override fun type(): Int {
        return R.layout.layout_item_check_in_out
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return CheckInOutViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClicked: (RecyclerItem) -> Unit
    ) {
        if (holder is CheckInOutViewHolder && item is CheckInOut) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClicked?.invoke(item)
            }
        }
    }

}