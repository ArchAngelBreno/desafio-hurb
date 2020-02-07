package com.desafiohurb

import android.app.Application
import com.desafiohurb.core.di.module.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class DesafioHurbApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@DesafioHurbApplication)
            modules(allModules)
        }
    }
}

