package com.viht.assignment.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemHeaderBinding
import com.viht.assignment.model.News

enum class ViewType(val type: String) {
    EVENT("event"),
    CHECK_OUT("checkOut"),
    CHECK_IN("checkIn"),
    IMAGE("portfolioImage"),
    FILE("portfolioDownload")
}