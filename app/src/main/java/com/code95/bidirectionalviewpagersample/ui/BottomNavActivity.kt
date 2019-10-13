package com.code95.bidirectionalviewpagersample.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.code95.bidirectionalviewpager.ui_model.BiDirectionalPagerAdapter
import com.code95.bidirectionalviewpager.ui_model.Tab
import com.code95.bidirectionalviewpagersample.R
import com.code95.bidirectionalviewpagersample.di.LocalDataManager
import kotlinx.android.synthetic.main.activity_bottom_nav.*
import kotlinx.android.synthetic.main.activity_bottom_nav.view_pager
import org.koin.android.ext.android.inject

class BottomNavActivity : AppCompatActivity() {
    val localDataManager: LocalDataManager by inject()

    companion object {
        fun buildIntent(context: Context): Intent {
            var intent = Intent(context, BottomNavActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        var adapter = BiDirectionalPagerAdapter(
            supportFragmentManager,
            localDataManager.getLang() == "ar",
            view_pager
        )

        adapter.addTab(
            Tab(
                R.id.menu_frag_1,
                MainFragment.NEW_INSTANCE(getString(R.string.frag_1))
            )
        )
        adapter.addTab(
            Tab(
                R.id.menu_frag_2,
                MainFragment.NEW_INSTANCE(getString(R.string.frag_2))
            )
        )
        adapter.addTab(
            Tab(
                R.id.menu_frag_3,
                MainFragment.NEW_INSTANCE(getString(R.string.frag_3))
            )
        )
        adapter.setupWithBottomNavView(bottom_navigation)

    }
}
