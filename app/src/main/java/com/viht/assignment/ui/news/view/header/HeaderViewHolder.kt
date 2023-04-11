package com.viht.assignment.ui.news.view.header

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemHeaderBinding

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemHeaderBinding.bind(view)
    fun bind(ob: Header) {
        binding.tvDate.text = ob.date
    }

}