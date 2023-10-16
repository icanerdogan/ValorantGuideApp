package com.ibrahimcanerdogan.valorantguideapp.domain.usecase.other.armor

import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.other.armor.ArmorRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import javax.inject.Inject

class GetArmorUseCase @Inject constructor(
    private val armorRepository: ArmorRepository
) {

    suspend fun execute() : Resource<List<ArmorData>> {
        return armorRepository.getAllArmorsFromRepository()
    }
}