package com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent.GetAgentUseCase
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AgentViewModel(
    private val app : Application,
    private val getAgentUseCase: GetAgentUseCase
) : BaseViewModel(app) {

    private var agent = MutableLiveData<Resource<Agent>>()
    val agentData : LiveData<Resource<Agent>>
        get() = agent

    fun getAllAgentData() = viewModelScope.launch(Dispatchers.IO) {
        agent.postValue(Resource.Loading())

        try {
            if(isNetworkAvailable(app)) {
                val apiResult = getAgentUseCase.execute()
                agent.postValue(apiResult)
            } else {
                agent.postValue(Resource.Error("Internet Error!"))
            }
        } catch (e : Exception) {
            agent.postValue(Resource.Error(e.message.toString()))
        }
    }

}