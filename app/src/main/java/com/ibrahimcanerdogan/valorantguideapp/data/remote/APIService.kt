package com.ibrahimcanerdogan.valorantguideapp.data.remote

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("v1/agents")
    suspend fun getAgentRemote() : Response<Agent>
}