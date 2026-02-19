package com.example.findit

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.findit.data.Item
import com.example.findit.databinding.ItemLayoutBinding

class ItemAdapter : ListAdapter<Item, ItemAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvTitle.text = item.title
            binding.tvUserName.text = item.userName
            binding.tvLocation.text = item.location
            binding.tvDescription.text = item.description
            binding.tvType.text = item.type.uppercase()

            if (item.type.equals("LOST", ignoreCase = true)) {
                binding.tvType.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, R.color.tag_lost_bg))
                binding.tvType.setTextColor(ContextCompat.getColor(binding.root.context, R.color.tag_lost_text))
            } else {
                binding.tvType.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, R.color.tag_found_bg))
                binding.tvType.setTextColor(ContextCompat.getColor(binding.root.context, R.color.tag_found_text))
            }

            binding.btnContact.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${item.contactInfo}")
                }
                binding.root.context.startActivity(intent)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}
