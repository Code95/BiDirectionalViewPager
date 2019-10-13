package com.code95.bidirectionalviewpagersample.ui.base


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.code95.bidirectionalviewpagersample.di.LocalDataManager
import com.code95.bidirectionalviewpagersample.util.ContextWrapper
import org.koin.android.ext.android.inject
import java.util.*


abstract class BaseActivity : AppCompatActivity() {

    private val localDataManager: LocalDataManager by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

//        configScreenVisibility()
        configScreenDirection()
    }

    private fun configScreenVisibility() {
        if (Build.VERSION.SDK_INT < 16) {
            window.addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        } else {
            var decorView = getWindow().getDecorView();
            var uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            var actionBar = getActionBar();
            actionBar?.hide();
        }
    }


    private fun configScreenDirection() {
        if (localDataManager.getLang() == null || localDataManager.getLang().trim().isEmpty()) localDataManager.saveLang(
            "en"
        )
        if (localDataManager.getLang() == "ar") {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        } else {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            ContextWrapper.wrap(
                newBase,
                Locale(localDataManager?.getLang())
            )
        )
    }


}
