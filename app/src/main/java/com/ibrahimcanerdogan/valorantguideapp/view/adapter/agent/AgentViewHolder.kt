package com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemAgentBinding

class AgentViewHolder(
    private val binding: ItemAgentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(agent: AgentData) {
        // set background
        Glide.with(binding.imageViewAgentBackground.context)
            .load(agent.agentBackground)
            .into(binding.imageViewAgentBackground)
        // set portrait
        Glide.with(binding.imageViewAgentPortrait.context)
            .load(agent.agentFullPortrait)
            .into(binding.imageViewAgentPortrait)


    }
}