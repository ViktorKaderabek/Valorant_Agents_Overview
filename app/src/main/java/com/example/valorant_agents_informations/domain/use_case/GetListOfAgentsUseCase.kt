package com.example.valorant_agents_informations.domain.use_case

import com.example.valorant_agents_informations.common.Resource
import com.example.valorant_agents_informations.data.remote.dto.AgentsListDtoItem
import com.example.valorant_agents_informations.data.remote.dto.toAgents
import com.example.valorant_agents_informations.domain.model.Agents
import com.example.valorant_agents_informations.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetListOfAgentsUseCase(
   private val repository: AgentsRepository
) {
    operator fun invoke() : Flow<Resource<List<Agents>>> = flow{
        try{
            emit(Resource.Loading())
            val agents = repository.getListOfAgents().map { it.toAgents() }
            emit(Resource.Success(agents))
        }catch (e : Exception){
            emit(Resource.Error("An Error has occurred"))
        }
    }
}