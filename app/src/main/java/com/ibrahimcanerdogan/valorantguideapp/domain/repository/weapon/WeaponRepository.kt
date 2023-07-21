package com.ibrahimcanerdogan.valorantguideapp.domain.repository.weapon

import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface WeaponRepository {

    suspend fun getAllWeaponsFromRepository() : Resource<List<WeaponData>>

}