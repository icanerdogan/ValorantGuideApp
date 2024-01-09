package com.ibrahimcanerdogan.valorantguideapp.view.adapter.map

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemMapBinding

class MapViewHolder(
    private val binding: ItemMapBinding,
    private val onMapItemClick : ((MapData) -> Unit)?
) : RecyclerView.ViewHolder(binding.root){

    fun bind(mapData: MapData){
        val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 50f
        circularProgressDrawable.start()

        binding.apply {
            Glide.with(root.context)
                .load(mapData.mapSplashIcon)
                .placeholder(circularProgressDrawable)
                .into(imageViewListMapIcon)

            textViewListMapName.text = mapData.mapDisplayName

            llListMapItem.setOnClickListener {
                onMapItemClick?.invoke(mapData)
            }
        }
    }
}