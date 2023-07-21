package com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface WeaponLocalDataSource {

    suspend fun saveWeaponDataToLocal(weaponList: List<WeaponData>)

    suspend fun getWeaponDataFromLocal() : Resource<List<WeaponData>>
}