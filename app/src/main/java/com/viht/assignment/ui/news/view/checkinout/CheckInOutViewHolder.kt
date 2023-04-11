package com.viht.assignment.ui.news.view.checkinout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemCheckInOutBinding

class CheckInOutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemCheckInOutBinding.bind(view)
    fun bind(ob: CheckInOut) {
        binding.tvDescription.text = ob.text
    }

}