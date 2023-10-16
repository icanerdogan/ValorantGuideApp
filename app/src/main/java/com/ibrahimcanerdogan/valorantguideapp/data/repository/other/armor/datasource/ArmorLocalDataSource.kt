package com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface ArmorLocalDataSource {

    suspend fun saveArmorDataToLocal(listArmorData: List<ArmorData>)

    suspend fun getArmorDataFromLocal() : Resource<List<ArmorData>>
}