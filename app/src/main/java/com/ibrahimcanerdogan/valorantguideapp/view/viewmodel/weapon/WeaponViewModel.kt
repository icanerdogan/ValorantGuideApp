package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.weapon.GetWeaponUseCase
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class WeaponViewModel @Inject constructor(
    app: Application,
    private val getWeaponUseCase: GetWeaponUseCase
) : BaseViewModel(app) {

    private var weapon = MutableLiveData<Resource<List<WeaponData>>>()
    val weaponData : LiveData<Resource<List<WeaponData>>>
        get() = weapon

    fun getAllWeaponData() = viewModelScope.launch(Dispatchers.IO) {
        weapon.postValue(Resource.Loading())

        try {
            val apiResult = getWeaponUseCase.execute()
            weapon.postValue(apiResult)
        } catch (e : Exception) {
            weapon.postValue(Resource.Error(e.message.toString()))
        }
    }
}