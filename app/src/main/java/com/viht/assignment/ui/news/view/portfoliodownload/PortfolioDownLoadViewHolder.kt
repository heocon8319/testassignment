package com.viht.assignment.ui.news.view.portfoliodownload

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemPortfolioDownloadBinding

class PortfolioDownLoadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemPortfolioDownloadBinding.bind(view)
    fun bind(ob: PortfolioDownLoad) {

        //description
        val description = "You have a Story ${ob.type} to download ${ob.name}"
        binding.tvDescription.text = description
    }

}