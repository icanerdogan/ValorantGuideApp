package com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon

import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemWeaponBinding

class WeaponViewHolder(
    private val binding: ItemWeaponBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(weaponData: WeaponData){
        binding.textViewWeaponDisplayName.text = weaponData.weaponShop?.shopCategory
    }
}