package com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor

import android.util.Log
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.Armor
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.MapRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.other.armor.ArmorRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class ArmorRepositoryImpl @Inject constructor(
    private val armorRemoteDataSource: ArmorRemoteDataSource,
    private val armorLocalDataSource: ArmorLocalDataSource
) : ArmorRepository {

    override suspend fun getAllArmorsFromRepository(): Resource<List<ArmorData>> {
        return getArmorDataFromDatabase()
    }

    private suspend fun getArmorDataFromDatabase() : Resource<List<ArmorData>> {
        lateinit var listArmorData: Resource<List<ArmorData>>
        try {
            listArmorData = armorLocalDataSource.getArmorDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (listArmorData.data!!.isNotEmpty()) {
            return listArmorData
        } else {
            listArmorData = responseToResource(armorRemoteDataSource.getArmorFromRemote())
            armorLocalDataSource.saveArmorDataToLocal(listArmorData.data!!)
        }

        return listArmorData
    }

    private fun responseToResource(response: Response<Armor>):Resource<List<ArmorData>>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result.armors)
            }
        }
        return Resource.Error(response.message())
    }

    companion object {
        private val TAG = MapRepositoryImpl::class.java.toString()
    }
}