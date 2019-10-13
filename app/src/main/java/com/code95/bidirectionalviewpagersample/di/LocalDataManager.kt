package com.code95.bidirectionalviewpagersample.di


import android.content.SharedPreferences


class LocalDataManager(private val sharedPreferences: SharedPreferences) {

    private val KEY_LANGUAGE = "lang"


    val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveLang(lang: String) {
        editor.putString(KEY_LANGUAGE, lang)
        editor.apply()
    }

    fun getLang(): String = sharedPreferences.getString(KEY_LANGUAGE, "") ?: ""


}