package com.viht.assignment.ui.news.view.event

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemEventBinding

class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = LayoutItemEventBinding.bind(view)
    fun bind(ob: Event) {

        //description
        val createdText = " created an event "
        val description = "${ob.title}${createdText}${ob.name} on ${ob.dateTime}"
        val spannable: Spannable = SpannableString(description)
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            ob.title.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            ob.title.length + createdText.length,
            ob.title.length + createdText.length + ob.name.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvDescription.text = spannable
    }

}