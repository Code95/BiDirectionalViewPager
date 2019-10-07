package com.code95.rtlsampleproject.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.code95.rtlsampleproject.R
import com.code95.rtlsampleproject.utils.ContextWrapper
import com.code95.rtlsampleproject.utils.SharedPrefHelper
import com.code95.rtlviewpager.RTLPagerAdapter
import com.code95.rtlviewpager.Tab
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAB_NEWS = 1
    private val TAB_EVENTS = 2
    private val TAB_PHOTOS = 3

    var mTabsAdapter: RTLPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar_title.text = getString(R.string.language)
        toolbar_top.setOnClickListener { changeLanguage() }

        setUpAdapter()
        initTabs()
    }

    private fun initTabs() {
        mTabsAdapter?.addTab(Tab(getString(R.string.news), SampleFragment.newInstance(getString(R.string.news), TAB_NEWS)))

        mTabsAdapter?.addTabs(mutableListOf(
                Tab(getString(R.string.events), SampleFragment.newInstance(getString(R.string.events), TAB_EVENTS)),
                Tab(getString(R.string.gallery), SampleFragment.newInstance(getString(R.string.gallery), TAB_PHOTOS)))
        )

        //mTabsAdapter?.removeTab(2)
    }

    override fun attachBaseContext(newBase: Context?) {
        val newLocale = Locale(newBase?.let { SharedPrefHelper(it).getPrefLang() })
        val context = newBase?.let { ContextWrapper(it).wrap(newBase, newLocale) }
        super.attachBaseContext(context)
    }

    private fun setUpAdapter() {
        mTabsAdapter = if (SharedPrefHelper(this).getPrefLang() == "ar") {
            RTLPagerAdapter(supportFragmentManager, viewpager, true)
        } else {
            RTLPagerAdapter(supportFragmentManager, viewpager, false)
        }
        viewpager.adapter = mTabsAdapter
        tablayout.setupWithViewPager(viewpager)
    }

    private fun changeLanguage() {
        SharedPrefHelper(this).setPrefLang(getString(R.string.local))
        var lang = SharedPrefHelper(this).getPrefLang()
        var locale = Locale(lang)
        Locale.setDefault(locale)
        var res = this.baseContext.resources
        var conf = res.configuration
        conf.setLocale(locale)
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        this.startActivity(intent)
        this.finish()
    }
}
