package com.code95.bidirectionalviewpagersample.modules


import androidx.preference.PreferenceManager
import com.code95.bidirectionalviewpagersample.di.LocalDataManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val dataModule = module {
    single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
    single { LocalDataManager(get()) }
}