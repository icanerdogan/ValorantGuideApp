package com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.database.other.ArmorDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import javax.inject.Inject

class ArmorLocalDataSourceImpl @Inject constructor(
    private val armorDao: ArmorDao
) : ArmorLocalDataSource {

    override suspend fun saveArmorDataToLocal(listArmorData: List<ArmorData>) {
        return armorDao.saveArmorDatabase(listArmorData)
    }

    override suspend fun getArmorDataFromLocal(): Resource<List<ArmorData>> {
        return Resource.Success(armorDao.getArmorListDatabase())
    }
}