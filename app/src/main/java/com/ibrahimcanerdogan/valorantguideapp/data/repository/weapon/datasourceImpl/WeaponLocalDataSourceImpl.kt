package com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.database.weapon.WeaponDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import javax.inject.Inject

class WeaponLocalDataSourceImpl @Inject constructor(
    private val weaponDao: WeaponDao
) : WeaponLocalDataSource {

    override suspend fun saveWeaponDataToLocal(weaponList: List<WeaponData>) {
        return weaponDao.saveWeaponDatabase(weaponList)
    }

    override suspend fun getWeaponDataFromLocal(): Resource<List<WeaponData>> {
        return Resource.Success(weaponDao.getWeaponListDatabase())
    }
}