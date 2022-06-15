package com.example.valorant_agents_informations.di

import com.example.valorant_agents_informations.common.Constants
import com.example.valorant_agents_informations.data.remote.ValorantAgentsApi
import com.example.valorant_agents_informations.data.repository.AgentsRepositroyImpl
import com.example.valorant_agents_informations.domain.repository.AgentsRepository
import com.example.valorant_agents_informations.domain.use_case.GetAgentsDetailUseCase
import com.example.valorant_agents_informations.domain.use_case.GetListOfAgentsUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    fun provideAgentsApi(): ValorantAgentsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ValorantAgentsApi::class.java)
    }

    fun provideAgentRepository(
        api: ValorantAgentsApi
    ): AgentsRepository {
        return AgentsRepositroyImpl(api)
    }

    fun getAgentsUseCase(repository: AgentsRepository): GetListOfAgentsUseCase {
        return GetListOfAgentsUseCase(repository)
    }

    fun getDeatilUseCase(repository: AgentsRepository): GetAgentsDetailUseCase {
        return GetAgentsDetailUseCase(repository)
    }

    single { provideAgentRepository(get()) }
    single { getAgentsUseCase(get()) }
    single { getDeatilUseCase(get()) }
    single { provideAgentsApi() }

}
/*
val myIpInfoVm = module { viewModel { MyIpScreenViewModel(get()) } }
val ipByIpVm = module { viewModel { IpByIpScreenViewModel(get()) } }
 */