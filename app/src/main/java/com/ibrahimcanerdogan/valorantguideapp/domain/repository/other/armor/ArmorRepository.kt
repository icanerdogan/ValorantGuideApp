package com.ibrahimcanerdogan.valorantguideapp.domain.repository.other.armor

import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface ArmorRepository {

    suspend fun getAllArmorsFromRepository() : Resource<List<ArmorData>>

}