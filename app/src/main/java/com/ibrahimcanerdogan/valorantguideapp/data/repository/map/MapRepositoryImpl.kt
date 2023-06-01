package com.ibrahimcanerdogan.valorantguideapp.data.repository.map

import android.util.Log
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.Map
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.map.MapRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class MapRepositoryImpl @Inject constructor(
    private val mapRemoteDataSource: MapRemoteDataSource,
    private val mapLocalDataSource: MapLocalDataSource
) : MapRepository {

    override suspend fun getAllMapsFromRepository(): Resource<List<MapData>> {
        return getMapDataFromDatabase()
    }

    private suspend fun getMapDataFromDatabase() : Resource<List<MapData>> {
        lateinit var listMapData: Resource<List<MapData>>
        try {
            listMapData = mapLocalDataSource.getMapDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (listMapData.data!!.isNotEmpty()) {
            return listMapData
        } else {
            listMapData = responseToResource(mapRemoteDataSource.getMapFromRemote())
            mapLocalDataSource.saveMapDataToLocal(listMapData.data!!)
        }

        return listMapData
    }

    private fun responseToResource(response: Response<Map>):Resource<List<MapData>>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result.maps)
            }
        }
        return Resource.Error(response.message())
    }

    companion object {
        private val TAG = MapRepositoryImpl::class.java.toString()
    }
}