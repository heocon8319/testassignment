package com.viht.assignment.ui.news.view.portfolioimage

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemPortfolioImageBinding

class PortfolioImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemPortfolioImageBinding.bind(view)
    fun bind(ob: PortfolioImage) {
        binding.tvDescription.text = ob.text
    }

}