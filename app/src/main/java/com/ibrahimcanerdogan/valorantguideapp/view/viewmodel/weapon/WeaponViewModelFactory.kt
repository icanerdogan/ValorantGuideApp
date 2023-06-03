package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.weapon.GetWeaponUseCase
import javax.inject.Inject

class WeaponViewModelFactory @Inject constructor(
    private val application: Application,
    private val getWeaponUseCase: GetWeaponUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeaponViewModel(
            application,
            getWeaponUseCase
        ) as T
    }
}