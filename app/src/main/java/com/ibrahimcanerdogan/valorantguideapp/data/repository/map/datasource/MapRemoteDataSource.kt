package com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.map.Map
import retrofit2.Response

interface MapRemoteDataSource {

    suspend fun getMapFromRemote() : Response<Map>

}