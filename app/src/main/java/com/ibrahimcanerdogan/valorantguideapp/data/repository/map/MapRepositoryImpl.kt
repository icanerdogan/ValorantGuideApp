package com.ibrahimcanerdogan.valorantguideapp.data.repository.map

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.Map
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.map.MapRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class MapRepositoryImpl @Inject constructor(
    private val mapRemoteDataSource: MapRemoteDataSource
) : MapRepository {

    override suspend fun getAllMapsFromRepository(): Resource<List<MapData>> {
        return responseToResource(mapRemoteDataSource.getMapFromRemote())
    }

    private fun responseToResource(response: Response<Map>):Resource<List<MapData>>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result.maps)
            }
        }
        return Resource.Error(response.message())
    }
}