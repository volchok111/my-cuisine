package com.volchok.mycuisine.app.system

import android.app.Application
import com.volchok.mycuisine.app.di.mainModule
import com.volchok.mycuisine.feature.home.di.homeModule
import com.volchok.mycuisine.library.api.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(applicationContext)
            modules(
                mainModule,
                homeModule,
                apiModule
            )
        }
        super.onCreate()
    }
}