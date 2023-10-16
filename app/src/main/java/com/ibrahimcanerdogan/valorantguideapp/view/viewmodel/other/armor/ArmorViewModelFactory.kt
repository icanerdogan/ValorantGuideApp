package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.other.armor

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.other.armor.GetArmorUseCase
import javax.inject.Inject

class ArmorViewModelFactory @Inject constructor(
    private val application: Application,
    private val getArmorUseCase: GetArmorUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArmorViewModel(
            application,
            getArmorUseCase
        ) as T
    }
}