package com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.media.MediaPlayer
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemAgentBinding

class AgentViewHolder(
    private val binding: ItemAgentBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val context : Context = binding.frameLayoutItemAgent.context
    private var mediaPlayer: MediaPlayer? = null

    fun bind(agentData: AgentData) {
        // Agent Background
        Glide.with(binding.imageViewAgentBackground.context)
            .load(agentData.agentBackground)
            .into(binding.imageViewAgentBackground)
        // Agent Full Portrait
        Glide.with(binding.imageViewAgentPortrait.context)
            .load(agentData.agentFullPortrait)
            .into(binding.imageViewAgentPortrait)

        val agentGradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                ContextCompat.getColor(context, R.color.ValorantBlack),
                ContextCompat.getColor(context, R.color.ValorantDarkRed),
                ContextCompat.getColor(context, R.color.ValorantMatRed),
                ContextCompat.getColor(context, R.color.ValorantMatRed),
                ContextCompat.getColor(context, R.color.ValorantMatRed),
                ContextCompat.getColor(context, R.color.ValorantPinkRed),
                ContextCompat.getColor(context, R.color.ValorantBlack)
            )
        )
        binding.frameLayoutItemAgent.background = agentGradientDrawable

        // Agent Info
        setAgentInfoData(agentData, agentData.agentBackgroundGradientColors!!)
        // Agent Role
        setAgentRoleData(agentData)
        // Agent Ability
        setAgentAbilityData(agentData)
        // Agent Voice
        setAgentVoiceData(agentData)

    }

    private fun setAgentAbilityData(agentData: AgentData) {
        binding.agentItemAbility.textViewAgentAbilityName1.text = agentData.agentAbilities[0].abilityDisplayName
        binding.agentItemAbility.textViewAgentAbilityDescription1.text = agentData.agentAbilities[0].abilityDescription
        Glide.with(binding.agentItemAbility.imageViewAgentAbility1.context)
            .load(agentData.agentAbilities[0].abilityDisplayIcon)
            .into(binding.agentItemAbility.imageViewAgentAbility1)

        binding.agentItemAbility.textViewAgentAbilityName2.text = agentData.agentAbilities[1].abilityDisplayName
        binding.agentItemAbility.textViewAgentAbilityDescription2.text = agentData.agentAbilities[1].abilityDescription
        Glide.with(binding.agentItemAbility.imageViewAgentAbility2.context)
            .load(agentData.agentAbilities[1].abilityDisplayIcon)
            .into(binding.agentItemAbility.imageViewAgentAbility2)

        binding.agentItemAbility.textViewAgentAbilityName3.text = agentData.agentAbilities[2].abilityDisplayName
        binding.agentItemAbility.textViewAgentAbilityDescription3.text = agentData.agentAbilities[2].abilityDescription
        Glide.with(binding.agentItemAbility.imageViewAgentAbility3.context)
            .load(agentData.agentAbilities[2].abilityDisplayIcon)
            .into(binding.agentItemAbility.imageViewAgentAbility3)

        binding.agentItemAbility.textViewAgentAbilityName4.text = agentData.agentAbilities[3].abilityDisplayName
        binding.agentItemAbility.textViewAgentAbilityDescription4.text = agentData.agentAbilities[3].abilityDescription
        Glide.with(binding.agentItemAbility.imageViewAgentAbility4.context)
            .load(agentData.agentAbilities[3].abilityDisplayIcon)
            .into(binding.agentItemAbility.imageViewAgentAbility4)

        binding.agentItemAbility.frameLayoutItemAgentAbility.setOnClickListener {
            binding.agentItemAbility.root.visibility = View.INVISIBLE
        }
        binding.buttonAbility.setOnClickListener {
            binding.agentItemAbility.root.visibility = View.VISIBLE
        }
    }

    private fun setAgentRoleData(agentData: AgentData) {
        binding.agentItemRole.textViewAgentRoleName.text = agentData.agentRole?.displayName
        binding.agentItemRole.textViewAgentRoleDescription.text = agentData.agentRole?.description
        Glide.with(binding.agentItemRole.imageViewAgentRoleIcon.context)
            .load(agentData.agentRole?.displayIcon)
            .into(binding.agentItemRole.imageViewAgentRoleIcon)
        binding.agentItemRole.frameLayoutItemAgentRole.setOnClickListener {
            binding.agentItemRole.root.visibility = View.INVISIBLE
        }
        binding.buttonRole.setOnClickListener {
            binding.agentItemRole.root.visibility = View.VISIBLE
        }
    }

    private fun setAgentInfoData(
        agentData: AgentData,
        agentBackgroundGradientColors: List<String>
    ) {
        //binding.agentItemInfo.textViewAgentInfoName.text = agentData.agentDisplayName
        binding.agentItemInfo.textViewAgentInfoDescription.text = agentData.agentDescription
        Glide.with(binding.agentItemInfo.imageViewAgentInfoPortrait.context)
            .load(agentData.agentDisplayIcon)
            .into(binding.agentItemInfo.imageViewAgentInfoPortrait)

        val infoDialogBackground = GradientDrawable(
            GradientDrawable.Orientation.BOTTOM_TOP,
            intArrayOf(
                Color.parseColor("#" + agentData.agentBackgroundGradientColors!![0]),
                Color.parseColor("#" + agentBackgroundGradientColors[1]),
                Color.parseColor("#" + agentBackgroundGradientColors[2]),
                Color.parseColor("#" + agentBackgroundGradientColors[3]),
            )
        )
        val infoDialogBackground2 = GradientDrawable(
            GradientDrawable.Orientation.BOTTOM_TOP,
            intArrayOf(
                ContextCompat.getColor(context, R.color.ValorantBlack),
                ContextCompat.getColor(context, R.color.ValorantDarkRed),
                ContextCompat.getColor(context, R.color.ValorantMatRed),
                ContextCompat.getColor(context, R.color.ValorantPinkRed)
            )
        )
        binding.agentItemInfo.imageViewAgentInfoPortrait.background = infoDialogBackground2
        binding.agentItemInfo.frameLayoutItemAgentInfo.setOnClickListener {
            binding.agentItemInfo.root.visibility = View.INVISIBLE
        }
        binding.buttonInfo.setOnClickListener {
            binding.agentItemInfo.root.visibility = View.VISIBLE
        }
    }

    private fun setAgentVoiceData(agentData: AgentData) {
        binding.imageViewAgentPortrait.setOnClickListener {
            // Check if MediaPlayer is already playing
            if (mediaPlayer?.isPlaying == true) {
                stopMediaPlayer()
            } else {
                startMediaPlayer(agentData.agentVoiceLine.mediaList[0].mediaWave)
            }
        }
    }
    private fun startMediaPlayer(audioUrl: String) {
        mediaPlayer = MediaPlayer().apply {
            setDataSource(audioUrl)
            prepare()
            start()
        }
    }

    private fun stopMediaPlayer() {
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
    }
}