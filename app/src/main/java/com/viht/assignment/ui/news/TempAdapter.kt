package com.viht.assignment.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viht.assignment.databinding.LayoutItemHeaderBinding
import com.viht.assignment.model.News

class TempAdapter(private val onItemClick: (new: News) -> Unit) :
    ListAdapter<News, TempAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        currentList.getOrNull(position)?.let {
            with(holder) {
                val resource = binding.root.resources
                binding.tvDate.text = it.eventDate
//                binding.tvDescription.text =
//                    resource.getString(R.string.text_description, it.description)
            }
        }
    }

    override fun getItemCount(): Int = currentList.size

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News) =
                oldItem === newItem

            override fun areContentsTheSame(oldItem: News, newItem: News) =
                oldItem.areSameContent(newItem)
        }
    }


    inner class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding = LayoutItemHeaderBinding.bind(view)

        init {
            itemView.setOnClickListener {
                onItemClick.invoke(currentList[adapterPosition])
            }
        }
    }

}