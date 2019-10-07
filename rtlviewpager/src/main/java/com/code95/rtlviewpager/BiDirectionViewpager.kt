package com.code95.rtlviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager

class BiDirectionViewpager(context: Context, attrs: AttributeSet? = null) :
    ViewPager(context, attrs) {

    init {
        tag = "BiPager"
    }

    override fun setLayoutDirection(layoutDirection: Int) {
        super.setLayoutDirection(View.LAYOUT_DIRECTION_LTR)
    }

}