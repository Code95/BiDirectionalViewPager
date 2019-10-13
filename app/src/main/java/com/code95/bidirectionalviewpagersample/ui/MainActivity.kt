package com.code95.bidirectionalviewpagersample.ui

import android.content.Intent
import android.os.Bundle
import com.code95.bidirectionalviewpager.ui_model.BiDirectionalPagerAdapter
import com.code95.bidirectionalviewpager.ui_model.Tab
import com.code95.bidirectionalviewpagersample.R
import com.code95.bidirectionalviewpagersample.di.LocalDataManager
import com.code95.bidirectionalviewpagersample.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    val localDataManager: LocalDataManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLangAction()
        setNavAction()

        var adapter = BiDirectionalPagerAdapter(
            supportFragmentManager,
            localDataManager.getLang() == "ar",
            view_pager
        )
        view_pager.adapter = adapter
        tabs.setupWithViewPager(view_pager)


        adapter.addTab(
            Tab(
                getString(R.string.frag_1),
                MainFragment.NEW_INSTANCE(getString(R.string.frag_1))
            )
        )
        adapter.addTab(
            Tab(
                getString(R.string.frag_2),
                MainFragment.NEW_INSTANCE(getString(R.string.frag_2))
            )
        )
        adapter.addTab(
            Tab(
                getString(R.string.frag_3),
                MainFragment.NEW_INSTANCE(getString(R.string.frag_3))
            )
        )
    }

    private fun setNavAction() {
        nav.setOnClickListener {
            startActivity(BottomNavActivity.buildIntent(this))
        }
    }

    private fun setLangAction() {
        lang.text = if (localDataManager.getLang() == "ar") "English" else "عربي"
        lang.setOnClickListener {
            if (localDataManager.getLang() == "ar") {
                localDataManager.saveLang("en")
            } else {
                localDataManager.saveLang("ar")
            }
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
