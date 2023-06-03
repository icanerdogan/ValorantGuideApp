package com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon

import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.Weapon
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.weapon.WeaponRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class WeaponRepositoryImpl @Inject constructor(
    private val weaponRemoteDataSource: WeaponRemoteDataSource
) : WeaponRepository {

    override suspend fun getAllWeaponsFromRepository(): Resource<List<WeaponData>> {
        return responseToResource(weaponRemoteDataSource.getWeaponFromRemote())
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