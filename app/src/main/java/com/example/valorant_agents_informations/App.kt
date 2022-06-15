package com.example.valorant_agents_informations

import android.app.Application
import com.example.valorant_agents_informations.di.AppModule
import com.example.valorant_agents_informations.di.ipByIpVm
import com.example.valorant_agents_informations.di.myIpInfoVm
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(){
            androidContext(this@App)
            modules(listOf(AppModule, myIpInfoVm, ipByIpVm))
        }
    }
}