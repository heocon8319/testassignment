package com.viht.assignment.ui.news.view.portfoliodownload

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemPortfolioDownloadBinding

class PortfolioDownLoadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemPortfolioDownloadBinding.bind(view)
    fun bind(ob: PortfolioDownLoad) {
        binding.tvDescription.text = ob.text
    }

}