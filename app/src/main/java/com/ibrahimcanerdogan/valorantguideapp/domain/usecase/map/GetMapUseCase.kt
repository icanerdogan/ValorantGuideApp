package com.ibrahimcanerdogan.valorantguideapp.domain.usecase.map

import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.map.MapRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import javax.inject.Inject

class GetMapUseCase @Inject constructor(
    private val mapRepository: MapRepository
) {

    suspend fun execute() : Resource<List<MapData>> {
        return mapRepository.getAllMapsFromRepository()
    }

}