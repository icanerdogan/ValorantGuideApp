package com.ibrahimcanerdogan.valorantguideapp.view.adapter.map

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemMapBinding

class MapViewHolder(
    private val binding: ItemMapBinding,
    private val onMapItemClick : ((MapData) -> Unit)?
) : RecyclerView.ViewHolder(binding.root){

    fun bind(mapData: MapData){
        Glide.with(binding.root.context)
            .load(mapData.mapSplashIcon)
            .into(binding.imageViewListMapIcon)

        binding.textViewListMapName.text = mapData.mapDisplayName

        binding.llListMapItem.setOnClickListener {
            onMapItemClick?.invoke(mapData)
        }
    }
}