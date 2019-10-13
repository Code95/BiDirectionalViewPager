package com.code95.bidirectionalviewpager.ui_model

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.tabs.TabLayout

/**
 * Hero is the BiDirectionalTabLayout class used to define a TabLayout with RTL support
 *
 * @author Amr Nabil
 * @param context the Context of application
 * @param attrs the Attribute Set for viewpager
 */
class BiDirectionalTabLayout(context: Context, attrs: AttributeSet? = null) :
    TabLayout(context, attrs) {
    /**
     * here we force layout direction to be Left to Right in the initialize
     */
    init {
        layoutDirection = View.LAYOUT_DIRECTION_LTR
    }

    /**
     * Hero is the setLayoutDirection method override to force layout direction be Left to Right (LTR)
     */
    override fun setLayoutDirection(layoutDirection: Int) {
        super.setLayoutDirection(View.LAYOUT_DIRECTION_LTR)
    }
}