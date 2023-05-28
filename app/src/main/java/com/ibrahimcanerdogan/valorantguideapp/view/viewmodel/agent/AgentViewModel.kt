package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent.GetAgentUseCase
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(
    private val app : Application,
    private val getAgentUseCase: GetAgentUseCase
) : BaseViewModel(app) {

    private var agent = MutableLiveData<Resource<List<AgentData>>>()
    val agentData : LiveData<Resource<List<AgentData>>>
        get() = agent

    fun getAllAgentData() = viewModelScope.launch(Dispatchers.IO) {
        agent.postValue(Resource.Loading())

        try {
            val apiResult = getAgentUseCase.execute()
            agent.postValue(apiResult)
        } catch (e : Exception) {
            agent.postValue(Resource.Error(e.message.toString()))
        }
    }

}