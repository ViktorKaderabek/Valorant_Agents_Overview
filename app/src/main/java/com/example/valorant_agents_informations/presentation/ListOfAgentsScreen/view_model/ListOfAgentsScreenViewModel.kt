package com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant_agents_informations.common.Resource
import com.example.valorant_agents_informations.domain.use_case.GetAgentsDetailUseCase
import com.example.valorant_agents_informations.domain.use_case.GetListOfAgentsUseCase
import com.example.valorant_agents_informations.presentation.DetailAgentScreen.view_model.view_model_state.DetailAgentScreenViewModelStete
import com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.view_model.view_model_state.ListOfAgentsScreenViewModelState
import com.example.valorant_agents_informations.presentation.Screen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListOfAgentsScreenViewModel (
    private val useCase: GetListOfAgentsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ListOfAgentsScreenViewModelState())
    val state : State<ListOfAgentsScreenViewModelState> = _state

    init{
        getListOfAgents()
    }

    private fun getListOfAgents(){
        useCase().onEach { result ->
            when(result){

                is Resource.Loading -> {
                    _state.value = ListOfAgentsScreenViewModelState(Loading = true)
                    Log.e("Loading","is Loading")
                }
                is Resource.Success -> {
                    _state.value = ListOfAgentsScreenViewModelState(Agents = result.data ?: emptyList())
                    Log.e("Success",result.data.toString())
                }

                is Resource.Error -> {
                    _state.value = ListOfAgentsScreenViewModelState(Error = result.message)
                    Log.e("Error",result.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}