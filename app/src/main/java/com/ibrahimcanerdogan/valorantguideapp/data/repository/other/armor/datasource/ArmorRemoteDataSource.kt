package com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.Armor
import retrofit2.Response

interface ArmorRemoteDataSource {

    suspend fun getArmorFromRemote() : Response<Armor>

}