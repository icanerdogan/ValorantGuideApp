package com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.media.MediaPlayer
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.databinding.ItemAgentBinding
import com.ibrahimcanerdogan.valorantguideapp.util.OnSwipeTouchListener


class AgentViewHolder(
    private val binding: ItemAgentBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val context : Context = binding.frameLayoutItemAgent.context

    @SuppressLint("ClickableViewAccessibility")
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
                ContextCompat.getColor(context, R.color.ValorantMatRed),
                ContextCompat.getColor(context, R.color.ValorantPinkRed),
                ContextCompat.getColor(context, R.color.ValorantMatRed),
                ContextCompat.getColor(context, R.color.ValorantBlack)
            )
        )
        binding.frameLayoutItemAgent.background = agentGradientDrawable


        binding.imageViewAgentPortrait.setOnTouchListener(object: OnSwipeTouchListener(context) {
            override fun onSwipeBottom() {
                super.onSwipeBottom()
                binding.agentItemAbility.root.visibility = View.VISIBLE
            }

            override fun onSwipeTop() {
                super.onSwipeTop()
                binding.agentItemRole.root.visibility = View.VISIBLE
            }
        })

        // Agent Info
        setAgentInfoData(agentData, agentData.agentBackgroundGradientColors!!)
        // Agent Role
        setAgentRoleData(agentData)
        // Agent Ability
        setAgentAbilityData(agentData)
    }

    private fun setAgentRoleData(agentData: AgentData) {
        binding.agentItemRole.apply {
            textViewAgentRoleName.text = agentData.agentRole?.displayName
            textViewAgentRoleDescription.text = agentData.agentRole?.description

            Glide.with(imageViewAgentRoleIcon.context)
                .load(agentData.agentRole?.displayIcon)
                .into(imageViewAgentRoleIcon)

            frameLayoutItemAgentRole.setOnClickListener {
                root.visibility = View.INVISIBLE
            }
        }
    }

    private fun setAgentAbilityData(agentData: AgentData) {
        binding.agentItemAbility.apply {
            textViewAgentAbilityName1.text = agentData.agentAbilities[0].abilityDisplayName
            textViewAgentAbilityDescription1.text =  agentData.agentAbilities[0].abilityDescription.replace("\n", "")
            textViewAgentAbilityDescription1.movementMethod = ScrollingMovementMethod()
            Glide.with(imageViewAgentAbility1.context)
                .load(agentData.agentAbilities[0].abilityDisplayIcon)
                .into(imageViewAgentAbility1)

            textViewAgentAbilityName2.text = agentData.agentAbilities[1].abilityDisplayName
            textViewAgentAbilityDescription2.text = agentData.agentAbilities[1].abilityDescription.replace("\n", "")
            textViewAgentAbilityDescription2.movementMethod = ScrollingMovementMethod()
            Glide.with(imageViewAgentAbility2.context)
                .load(agentData.agentAbilities[1].abilityDisplayIcon)
                .into(imageViewAgentAbility2)

            textViewAgentAbilityName3.text = agentData.agentAbilities[2].abilityDisplayName
            textViewAgentAbilityDescription3.text = agentData.agentAbilities[2].abilityDescription.replace("\n", "")
            textViewAgentAbilityDescription3.movementMethod = ScrollingMovementMethod()
            Glide.with(imageViewAgentAbility3.context)
                .load(agentData.agentAbilities[2].abilityDisplayIcon)
                .into(imageViewAgentAbility3)

            textViewAgentAbilityName4.text = agentData.agentAbilities[3].abilityDisplayName
            textViewAgentAbilityDescription4.text = agentData.agentAbilities[3].abilityDescription.replace("\n", "")
            textViewAgentAbilityDescription4.movementMethod = ScrollingMovementMethod()
            Glide.with(imageViewAgentAbility4.context)
                .load(agentData.agentAbilities[3].abilityDisplayIcon)
                .into(imageViewAgentAbility4)

            frameLayoutItemAgentAbility.setOnClickListener {
                root.visibility = View.INVISIBLE
            }
        }
    }

    private fun setAgentInfoData(
        agentData: AgentData,
        agentBackgroundGradientColors: List<String>
    ) {
        binding.agentItemInfo.apply {
            //textViewAgentInfoName.text = agentData.agentDisplayName
            textViewAgentInfoDescription.text = agentData.agentDescription
            Glide.with(imageViewAgentInfoPortrait.context)
                .load(agentData.agentDisplayIcon)
                .into(imageViewAgentInfoPortrait)

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
            imageViewAgentInfoPortrait.background = infoDialogBackground2
            frameLayoutItemAgentInfo.setOnClickListener {
                root.visibility = View.INVISIBLE
            }
            binding.buttonInfo.setOnClickListener {
                root.visibility = View.VISIBLE
            }
        }
    }
}