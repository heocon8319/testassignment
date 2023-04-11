package com.viht.assignment.ui.news.view.portfolioimage

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.viht.assignment.databinding.LayoutItemPortfolioImageBinding

class PortfolioImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemPortfolioImageBinding.bind(view)
    fun bind(ob: PortfolioImage) {

        //description
        val uploadText = " uploaded a new story "
        val description = "${ob.title}${uploadText}${ob.name}"
        val spannable: Spannable = SpannableString(description)
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            ob.title.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            ob.title.length + uploadText.length,
            ob.title.length + uploadText.length + ob.name.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvDescription.text = spannable

        //image
        Glide.with(itemView.context).load(ob.image).into(binding.ivImage)
    }

}