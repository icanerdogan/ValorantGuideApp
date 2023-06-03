package com.ibrahimcanerdogan.valorantguideapp.domain.usecase.weapon

import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.weapon.WeaponRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import javax.inject.Inject

class GetWeaponUseCase @Inject constructor(
    private val weaponRepository: WeaponRepository
) {

    suspend fun execute() : Resource<List<WeaponData>> {
        return weaponRepository.getAllWeaponsFromRepository()
    }
}