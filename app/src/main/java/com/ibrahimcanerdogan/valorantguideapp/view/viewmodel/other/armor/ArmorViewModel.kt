package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.other.armor

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.other.armor.GetArmorUseCase
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArmorViewModel @Inject constructor(
    private val app: Application,
    private val getArmorUseCase: GetArmorUseCase
) : BaseViewModel(app) {

    private var armor = MutableLiveData<Resource<List<ArmorData>>>()
    val armorData : LiveData<Resource<List<ArmorData>>>
        get() = armor

    fun getAllArmorData() = viewModelScope.launch(Dispatchers.IO) {
        armor.postValue(Resource.Loading())

        try {
            val apiResult = getArmorUseCase.execute()
            armor.postValue(apiResult)
        } catch (e : Exception) {
            armor.postValue(Resource.Error(e.message.toString()))
        }
    }
}