package com.code95.bidirectionalviewpagersample

import android.app.Application
import com.code95.bidirectionalviewpagersample.modules.dataModule
import org.koin.android.ext.android.startKoin

class MApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = listOf(dataModule)
        startKoin(this,modules)
    }
}