package com.code95.rtlsampleproject.utils

import android.os.Build

object BuildUtils {
    fun isAtLeast24Api(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    }

    fun isAtLeast17Api(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
    }
}