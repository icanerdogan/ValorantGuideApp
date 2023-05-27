package com.ibrahimcanerdogan.valorantguideapp.data.model.agent

import com.google.gson.annotations.SerializedName

data class Agent(
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val agents: List<AgentData>
)