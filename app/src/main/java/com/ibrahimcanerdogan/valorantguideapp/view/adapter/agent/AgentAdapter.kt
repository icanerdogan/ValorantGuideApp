package com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemAgentBinding

class AgentAdapter : RecyclerView.Adapter<AgentViewHolder>(){

    private val diffUtil = object : DiffUtil.ItemCallback<AgentData>() {
        override fun areItemsTheSame(oldItem: AgentData, newItem: AgentData): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: AgentData, newItem: AgentData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffUtil)

    fun setData(newList : List<AgentData>) {
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val binding = ItemAgentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        differ.currentList[position]?.let {
            holder.bind(it)
        }
    }

}