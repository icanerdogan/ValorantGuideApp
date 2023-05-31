package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.map

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.map.GetMapUseCase
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val app: Application,
    private val getMapUseCase: GetMapUseCase
) : BaseViewModel(app) {

    private var map = MutableLiveData<Resource<List<MapData>>>()
    val mapData : LiveData<Resource<List<MapData>>>
        get() = map

    fun getAllMapData() = viewModelScope.launch(Dispatchers.IO) {
        map.postValue(Resource.Loading())

        try {
            val apiResult = getMapUseCase.execute()
            map.postValue(apiResult)
        } catch (e : Exception) {
            map.postValue(Resource.Error(e.message.toString()))
        }
    }
}