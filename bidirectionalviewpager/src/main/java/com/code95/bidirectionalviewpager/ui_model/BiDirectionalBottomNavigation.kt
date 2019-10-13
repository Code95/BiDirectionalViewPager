package com.code95.bidirectionalviewpager.ui_model

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Hero is the BiDirectionalBottomNavigation class used to define a BottomNavigationView with RTL support
 *
 * @author Amr Nabil
 * @param context the Context of application
 * @param attrs the Attribute Set for viewpager
 */
open class BiDirectionalBottomNavigation(context: Context, attrs: AttributeSet? = null) :
    BottomNavigationView(context, attrs) {
    /**
     * Here we set a tag to BiDirectionalBottomNavigation so we can found it in adapter
     */
    init {
        tag = "BiBottomNav"
    }

    /**
     * Hero is the setLayoutDirection method override to force layout direction be Left to Right (LTR)
     */
    override fun setLayoutDirection(layoutDirection: Int) {
        super.setLayoutDirection(View.LAYOUT_DIRECTION_LTR)
    }
}