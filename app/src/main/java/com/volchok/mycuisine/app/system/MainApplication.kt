package com.volchok.mycuisine.app.system

import android.app.Application
import com.volchok.mycuisine.app.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(applicationContext)
            modules(
                mainModule
            )
        }
        super.onCreate()
    }
}