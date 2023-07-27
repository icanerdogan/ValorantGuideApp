package com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.StatDamageRange
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemWeaponDamageRangeBinding

class WeaponDamageRangeAdapter : RecyclerView.Adapter<WeaponDamageRangeViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<StatDamageRange>() {
        override fun areItemsTheSame(oldItem: StatDamageRange, newItem: StatDamageRange): Boolean {
            return oldItem.damageRangeId == newItem.damageRangeId
        }

        override fun areContentsTheSame(oldItem: StatDamageRange, newItem: StatDamageRange): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffUtil)

    fun setData(newList : List<StatDamageRange?>?) {
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponDamageRangeViewHolder {
        val binding = ItemWeaponDamageRangeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeaponDamageRangeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: WeaponDamageRangeViewHolder, position: Int) {
        differ.currentList[position]?.let {
            holder.bind(it)
        }
    }
}