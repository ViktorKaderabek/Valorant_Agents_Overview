package com.example.valorant_agents_informations.presentation.DetailAgentScreen.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant_agents_informations.common.Resource
import com.example.valorant_agents_informations.domain.use_case.GetAgentsDetailUseCase
import com.example.valorant_agents_informations.presentation.DetailAgentScreen.view_model.view_model_state.DetailAgentScreenViewModelStete
import com.example.valorant_agents_informations.presentation.ListOfAgentsScreen.ListOfAgentsScreen
import com.example.valorant_agents_informations.presentation.Screen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DetailAgentScreenViewModel(
    private val useCase: GetAgentsDetailUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DetailAgentScreenViewModelStete())
    val state : State<DetailAgentScreenViewModelStete> = _state
    private val id : String = ListOfAgentsScreen.id.toString()

    init {
        getDetailAgent(id)
    }

    private fun getDetailAgent(id : String){
        useCase(id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = DetailAgentScreenViewModelStete(Agents = result.data)
                }

                is Resource.Loading -> {
                    _state.value = DetailAgentScreenViewModelStete(Loading = true)
                }

                is Resource.Error -> {
                    _state.value = DetailAgentScreenViewModelStete(Error = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}