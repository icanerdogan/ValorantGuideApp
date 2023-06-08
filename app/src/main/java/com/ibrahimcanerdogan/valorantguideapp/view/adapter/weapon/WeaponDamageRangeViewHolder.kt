package com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon

import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.StatDamageRange
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemWeaponDamageRangeBinding

class WeaponDamageRangeViewHolder(
    private val binding: ItemWeaponDamageRangeBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(statDamageRange: StatDamageRange) {
        binding.apply {
            textViewWeaponDamageRangeMeter.text = "${statDamageRange.damageStartMeters} - ${statDamageRange.damageEndMeters} Meters"
            textViewWeaponDetailDamageBody.text = "B: ${statDamageRange.damageBody}"
            textViewWeaponDetailDamageHead.text = "H: ${statDamageRange.damageHead.toInt()}"
            textViewWeaponDetailDamageLeg.text = "L: ${statDamageRange.damageLeg.toInt()}"
        }
    }
}