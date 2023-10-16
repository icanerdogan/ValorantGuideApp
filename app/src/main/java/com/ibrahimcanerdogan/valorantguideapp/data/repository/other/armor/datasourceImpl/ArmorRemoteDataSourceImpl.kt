package com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.Armor
import com.ibrahimcanerdogan.valorantguideapp.data.remote.APIService
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class ArmorRemoteDataSourceImpl @Inject constructor(
    private val apiService: APIService
) : ArmorRemoteDataSource {

    override suspend fun getArmorFromRemote(): Response<Armor> {
        return apiService.getArmorRemote()
    }
}