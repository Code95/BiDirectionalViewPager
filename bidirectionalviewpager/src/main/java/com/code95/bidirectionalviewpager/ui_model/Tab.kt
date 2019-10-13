package com.code95.bidirectionalviewpager.ui_model

import androidx.fragment.app.Fragment

/**
 * Hero is the Tab class used to define a fragment with title
 *
 * @author Amr Nabil
 * @param title the title of fragment
 * @param fragment the fragment to be a tab in viewpager
 */
class Tab(val title: String, val fragment: Fragment) {

    /**
     * Hero is the Tab class second constructor used to define a fragment with title
     *
     * @param menuId used as the menu recourse id item
     * @param fragment the fragment to be a tab in bottom navigation
     */
    constructor(menuId: Int, fragment: Fragment) : this("", fragment) {
        id = menuId
    }

    /**
     * This is recourse item id
     */
    var id = 0

    private var mTitle = title
        get() = field
        set(value) {
            field = value
        }
    private var mFragment = fragment
        get() = field
        set(value) {
            field = value
        }
}