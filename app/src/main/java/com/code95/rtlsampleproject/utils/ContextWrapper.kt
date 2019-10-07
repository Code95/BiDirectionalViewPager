package com.code95.rtlsampleproject.utils

import android.content.Context
import android.os.LocaleList
import java.util.*


class ContextWrapper(base: Context) : android.content.ContextWrapper(base) {

    fun wrap(context: Context, newLocale: Locale): ContextWrapper {
        var context = context
        val res = context.resources
        val configuration = res.configuration

        if (BuildUtils.isAtLeast24Api()) {
            configuration.setLocale(newLocale)

            val localeList = LocaleList(newLocale)
            LocaleList.setDefault(localeList)
            configuration.locales = localeList

            context = context.createConfigurationContext(configuration)

        } else if (BuildUtils.isAtLeast17Api()) {
            configuration.setLocale(newLocale)
            context = context.createConfigurationContext(configuration)

        } else {
            configuration.locale = newLocale
            res.updateConfiguration(configuration, res.displayMetrics)
        }

        return ContextWrapper(context)
    }
}
