package com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.model.map.Map
import com.ibrahimcanerdogan.valorantguideapp.data.remote.APIService
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MapRemoteDataSourceImpl @Inject constructor(
    private val apiService : APIService
) : MapRemoteDataSource {

    override suspend fun getMapFromRemote(): Response<Map> {
        return apiService.getMapRemote()
    }
}