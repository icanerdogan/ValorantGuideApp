package com.ibrahimcanerdogan.valorantguideapp.view.adapter.map

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemMapBinding

class MapViewHolder(
    private val binding: ItemMapBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(mapData: MapData){
        Glide.with(binding.root.context)
            .load(mapData.mapListViewIcon)
            .into(binding.imageViewListMapIcon)

        binding.textViewListMapName.text = mapData.mapDisplayName

    }
}