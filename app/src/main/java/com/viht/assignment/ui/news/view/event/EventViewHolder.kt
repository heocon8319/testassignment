package com.viht.assignment.ui.news.view.event

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemEventBinding

class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemEventBinding.bind(view)
    fun bind(ob: Event) {
        binding.tvDescription.text = ob.text
    }

}