package com.viht.assignment.ui.news.view.checkinout

import android.graphics.Typeface.BOLD
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.viht.assignment.R
import com.viht.assignment.databinding.LayoutItemCheckInOutBinding


class CheckInOutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemCheckInOutBinding.bind(view)
    fun bind(ob: CheckInOut) {

        //description
        val description = "${ob.name} ${ob.type} on ${ob.time}"
        val spannable: Spannable = SpannableString(description)
        spannable.setSpan(
            StyleSpan(BOLD),
            0,
            ob.name.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvDescription.text = spannable

        //image
        Glide.with(itemView.context)
            .load(ob.image)
            .transform(MultiTransformation(CenterCrop(), RoundedCorners(15)))
            .placeholder(R.drawable.bg_image)
            .error(R.drawable.bg_image)
            .override(500, 400)
            .apply(RequestOptions.centerCropTransform())
            .into(binding.ivImage)
    }

}