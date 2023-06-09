package com.example.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemBinding
import com.example.presentation.models.ResponseUI

class HomeAdapter(
    val onItemClick: (id: String) -> Unit
) : ListAdapter<ResponseUI, HomeAdapter.ViewHolder>(
    diffUtil
) {
    inner class ViewHolder(private val itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { it1 -> onItemClick(it1.id) }
            }
        }

        fun onBind(responseUI: ResponseUI) {
            itemBinding.textView.text = responseUI.title
            itemBinding.tvTitle.text = responseUI.originalTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseUI>() {
            override fun areItemsTheSame(oldItem: ResponseUI, newItem: ResponseUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResponseUI, newItem: ResponseUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}