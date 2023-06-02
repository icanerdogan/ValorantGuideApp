package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.map

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.map.GetMapUseCase
import javax.inject.Inject

class MapViewModelFactory @Inject constructor(
    private val application: Application,
    private val getMapUseCase: GetMapUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MapViewModel(
            application,
            getMapUseCase
        ) as T
    }
}