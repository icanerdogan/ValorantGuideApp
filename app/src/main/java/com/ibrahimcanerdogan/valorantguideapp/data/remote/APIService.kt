package com.ibrahimcanerdogan.valorantguideapp.data.remote

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.Map
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.Weapon
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("v1/agents")
    suspend fun getAgentRemote() : Response<Agent>

    @GET("v1/maps")
    suspend fun getMapRemote() : Response<Map>

    @GET("v1/weapons")
    suspend fun getWeaponRemote() : Response<Weapon>
}