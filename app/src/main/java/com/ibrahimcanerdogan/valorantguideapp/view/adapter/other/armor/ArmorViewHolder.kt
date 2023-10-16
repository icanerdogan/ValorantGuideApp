package com.ibrahimcanerdogan.valorantguideapp.view.adapter.other.armor

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemOtherArmorBinding
import com.ibrahimcanerdogan.valorantguideapp.util.AnimationUtil

class ArmorViewHolder(
    private val binding: ItemOtherArmorBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(armorData: ArmorData){
        Glide.with(binding.root.context)
            .load(armorData.armorDisplayIcon)
            .into(binding.itemArmorDisplayIcon)

        binding.apply {
            itemArmorDisplayName.text = armorData.armorDisplayName
            itemArmorDisplayDesc.text = armorData.armorDescription
            itemArmorCost.text = "Cost: ${armorData.armorShopData?.armorShopCost}"

            // Flip Card
            cardItemArmor.setOnClickListener {
                AnimationUtil.flipAnimation(it, itemArmorLinearLayoutInfo)
            }
        }
    }
}