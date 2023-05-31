package com.ibrahimcanerdogan.valorantguideapp.domain.repository.map

import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface MapRepository {

    suspend fun getAllMapsFromRepository() : Resource<List<MapData>>

}