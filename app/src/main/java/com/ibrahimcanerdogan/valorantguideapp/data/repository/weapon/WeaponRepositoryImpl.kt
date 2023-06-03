package com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon

import android.util.Log
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.Weapon
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.MapRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.weapon.WeaponRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class WeaponRepositoryImpl @Inject constructor(
    private val weaponRemoteDataSource: WeaponRemoteDataSource,
    private val weaponLocalDataSource: WeaponLocalDataSource
) : WeaponRepository {

    override suspend fun getAllWeaponsFromRepository(): Resource<List<WeaponData>> {
        return getWeaponDataFromDatabase()
    }

    private suspend fun getWeaponDataFromDatabase() : Resource<List<WeaponData>> {
        lateinit var listWeaponData: Resource<List<WeaponData>>
        try {
            listWeaponData = weaponLocalDataSource.getWeaponDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (listWeaponData.data!!.isNotEmpty()) {
            return listWeaponData
        } else {
            listWeaponData = responseToResource(weaponRemoteDataSource.getWeaponFromRemote())
            weaponLocalDataSource.saveWeaponDataToLocal(listWeaponData.data!!)
        }

        return listWeaponData
    }


    private fun responseToResource(response: Response<Weapon>):Resource<List<WeaponData>>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result.weapons)
            }
        }
        return Resource.Error(response.message())
    }

    companion object {
        private val TAG = WeaponRepositoryImpl::class.java.toString()
    }
}