package com.ibrahimcanerdogan.valorantguideapp.view.adapter.other.armor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemOtherArmorBinding

class ArmorAdapter : RecyclerView.Adapter<ArmorViewHolder>(){

    private val diffUtil = object : DiffUtil.ItemCallback<ArmorData>() {
        override fun areItemsTheSame(oldItem: ArmorData, newItem: ArmorData): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: ArmorData, newItem: ArmorData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffUtil)

    fun setData(newList : List<ArmorData>) {
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmorViewHolder {
        val binding = ItemOtherArmorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArmorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArmorViewHolder, position: Int) {
        differ.currentList[position]?.let {
            holder.bind(it)
        }
    }
}