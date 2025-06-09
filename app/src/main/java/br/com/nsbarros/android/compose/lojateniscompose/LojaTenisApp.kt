package br.com.nsbarros.android.compose.lojateniscompose

import android.app.Application
import br.com.nsbarros.android.compose.lojateniscompose.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class LojaTenisApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LojaTenisApp)
            modules(appModule)
        }
    }
}