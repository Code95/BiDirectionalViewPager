package com.code95.rtlsampleproject.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {

    var mSharedPreferences: SharedPreferences = context.getSharedPreferences("RTL_PREF", Context.MODE_PRIVATE)

    val KEY_LANG = "lang"


    fun setPrefLang(lang: String) {
        saveString(KEY_LANG, lang)
    }

    fun getPrefLang(): String? {
        return mSharedPreferences.getString(KEY_LANG, "en")
    }

    fun saveString(key: String, value: String) {
        val editor = mSharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}