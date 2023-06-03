package com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemWeaponBinding

class WeaponViewHolder(
    private val binding: ItemWeaponBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(weaponData: WeaponData){

        val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide.with(binding.root.context)
            .load(weaponData.weaponDisplayIcon)
            .placeholder(circularProgressDrawable)
            .into(binding.imageViewListWeaponIcon)

        binding.textViewWeaponName.text = weaponData.weaponDisplayName
    }
}