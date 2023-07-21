package com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.Weapon
import retrofit2.Response

interface WeaponRemoteDataSource {

    suspend fun getWeaponFromRemote() : Response<Weapon>
}