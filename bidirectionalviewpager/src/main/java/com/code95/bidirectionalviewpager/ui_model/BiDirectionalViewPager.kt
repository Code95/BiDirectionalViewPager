package com.code95.bidirectionalviewpager.ui_model

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * Hero is the BiDirectionalViewPager class used to define a ViewPager with RTL support
 *
 * @author Amr Nabil
 * @param context the Context of application
 * @param attrs the Attribute Set for viewpager
 */
open class BiDirectionalViewPager(context: Context, attrs: AttributeSet? = null) :
    ViewPager(context, attrs) {
    /**
     * Here we set a tag to BiDirectionalViewPager so we can found it in adapter
     * and force layout direction to be Left to Right
     */
    init {
        tag = "BiPager"
        layoutDirection = View.LAYOUT_DIRECTION_LTR
    }

    /**
     * Hero is the setLayoutDirection method override to force layout direction be Left to Right (LTR)
     */
    override fun setLayoutDirection(layoutDirection: Int) {
        super.setLayoutDirection(View.LAYOUT_DIRECTION_LTR)
    }
}