package com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.Weapon
import com.ibrahimcanerdogan.valorantguideapp.data.remote.APIService
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class WeaponRemoteDataSourceImpl @Inject constructor(
    private val apiService: APIService
) : WeaponRemoteDataSource {

    override suspend fun getWeaponFromRemote(): Response<Weapon> {
        return apiService.getWeaponRemote()
    }
}