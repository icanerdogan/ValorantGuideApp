package com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemWeaponBinding

class WeaponAdapter : RecyclerView.Adapter<WeaponViewHolder>(){

    private val diffUtil = object : DiffUtil.ItemCallback<WeaponData>() {
        override fun areItemsTheSame(oldItem: WeaponData, newItem: WeaponData): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: WeaponData, newItem: WeaponData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffUtil)

    fun setData(newList : List<WeaponData>) {
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        val binding = ItemWeaponBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeaponViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: WeaponViewHolder, position: Int) {
        differ.currentList[position]?.let {
            holder.bind(it)
        }
    }
}