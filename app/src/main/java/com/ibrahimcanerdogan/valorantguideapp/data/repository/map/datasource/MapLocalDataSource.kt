package com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface MapLocalDataSource {

    suspend fun saveMapDataToLocal(listMapData: List<MapData>)

    suspend fun getMapDataFromLocal() : Resource<List<MapData>>
}