package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent.GetAgentUseCase

class AgentViewModelFactory(
    private val application: Application,
    private val getAgentUseCase: GetAgentUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AgentViewModel(
            application,
            getAgentUseCase
        ) as T
    }
}