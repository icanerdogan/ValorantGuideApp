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

    private var weaponList = MutableLiveData<Resource<List<WeaponData>>>()
    val weaponListData : LiveData<Resource<List<WeaponData>>>
        get() = weaponList

    private var weapon = MutableLiveData<Resource<WeaponData>>()
    val weaponData : LiveData<Resource<WeaponData>>
        get() = weapon

    fun getAllWeaponData(weaponCategory: String) = viewModelScope.launch(Dispatchers.IO) {
        weaponList.postValue(Resource.Loading())

        try {
            val apiResult = getWeaponUseCase.execute()
            val newList: ArrayList<WeaponData> = arrayListOf()
            for (i in apiResult.data!!.indices) {
                if (apiResult.data[i].weaponCategory.split("::")[1] == weaponCategory) {
                    newList.add(apiResult.data[i])
                }
            }
            weaponList.postValue(Resource.Success(newList))
        } catch (e : Exception) {
            weaponList.postValue(Resource.Error(e.message.toString()))
        }
    }

    fun getDetailWeaponData(uuid: String) = viewModelScope.launch(Dispatchers.IO) {
        weapon.postValue(Resource.Loading())

        try {
            val managerResult = getWeaponUseCase.execute()
            managerResult.data?.forEach { weaponData ->
                if (weaponData.uuid == uuid) {
                    weapon.postValue(Resource.Success(weaponData))
                }
            }
        } catch (e : Exception) {
            weapon.postValue(Resource.Error(e.message.toString()))
        }
    }
}