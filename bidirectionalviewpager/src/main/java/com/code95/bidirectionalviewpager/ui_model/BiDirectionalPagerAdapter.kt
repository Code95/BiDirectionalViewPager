package com.code95.bidirectionalviewpager.ui_model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

/**
 * Hero is the BiDirectionalPagerAdapter class used to define a FragmentPagerAdapter with RTL support
 *
 * @author Amr Nabil
 * @param fm the FragmentManager
 * @param isRtl Boolean check to be RTL or LTR
 * @param pager the BiDirectionalViewPager to be used with the adapter
 */
open class BiDirectionalPagerAdapter(
    fm: FragmentManager,
    var isRtl: Boolean,
    var pager: BiDirectionalViewPager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    /**
     * The list of Tabs to be used in BiDirectionalPagerAdapter
     */
    private val items: MutableList<Tab> = mutableListOf()

    /**
     * Override for getItem method to check if we are in RTL return the inverse item else return normal item
     */
    override fun getItem(position: Int): Fragment {
        if (isRtl) {
            return items[items.size - (position + 1)].fragment
        }
        return items[position].fragment
    }

    /**
     * Override for getPageTitle method to check if we are in RTL return the inverse item else return normal item
     */
    override fun getPageTitle(position: Int): CharSequence? {
        if (isRtl) {
            return items[items.size - (position + 1)].title
        }
        return items[position].title
    }

    /**
     * Override getCount method to return items size
     */
    override fun getCount(): Int {
        return items.size
    }

    /**
     * addTabs method used to add list of tabs to items
     * check if RTL then reverse items and add them in front of items
     * else use normal add at the end of items
     * then call getViewPagerItemPos method for data changed notifying
     *
     * @param tabs MutableList of tabs(Fragment , title)
     */
    fun addTabs(tabs: MutableList<Tab>) {
        if (isRtl) {
            items.addAll(0, tabs.asReversed())
        } else {
            items.addAll(tabs)
        }
        getViewPagerItemPos()
    }

    /**
     * addTab method used to add Tab to items
     * @param tab is a Tab (Fragment , title)
     */
    fun addTab(tab: Tab) {
        items.add(tab)
        getViewPagerItemPos()
    }

    /**
     * removeTab method used to remove tab from items
     * check if RTL then remove from inverse position
     * else use normal remove from position
     * then call getViewPagerItemPos method for data changed notifying
     *
     * @param position Integer value to position of tab
     */
    fun removeTab(position: Int) {
        if (isRtl) {
            items.removeAt((items.size - (position + 1)))
        } else {
            items.removeAt(position)
        }
        getViewPagerItemPos()
    }

    /**
     * getViewPagerItemPos method used to change current item and notifyDataSetChanged
     * based on check LTR and RTL flag
     */
    private fun getViewPagerItemPos() {
        val view =
            pager.findViewWithTag("BiPager") as BiDirectionalViewPager

        if (isRtl) {
            view.currentItem = items.size.minus(1)
        } else {
            view.currentItem = 0
        }
        notifyDataSetChanged()
    }

    /**
     * setupWithBottomNavView is used to setup the adapter with BiDirectionalBottomNavigation
     * @param bottom_navigation The object of BiDirectionalBottomNavigation to setup pager adapter with.
     */
    fun setupWithBottomNavView(bottom_navigation: BiDirectionalBottomNavigation) {
        pager.adapter = this
        setupNavItemSelectedListener(bottom_navigation)
        setupPageChangeListener(bottom_navigation)
    }

    /**
     * setupPageChangeListener is used to setup the page change listener with BiDirectionalBottomNavigation
     * @param bottom_navigation The object of BiDirectionalBottomNavigation to setup page change listener with.
     */
    private fun setupPageChangeListener(bottom_navigation: BiDirectionalBottomNavigation) {
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            /**
             * Override for onPageSelected method to check if we are in RTL select the reverse item else select normal item
             * @param position the position of selected item
             */
            override fun onPageSelected(position: Int) {
                if (isRtl) {
                    var rtlPos = items.size - 1 - position
                    bottom_navigation.menu.getItem(rtlPos).isChecked = true
                } else {
                    bottom_navigation.menu.getItem(position).isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    /**
     * setupNavItemSelectedListener is used to setup the item select listener with BiDirectionalBottomNavigation
     * @param bottom_navigation The object of BiDirectionalBottomNavigation to setup item select listener with.
     */
    private fun setupNavItemSelectedListener(
        bottom_navigation: BiDirectionalBottomNavigation
    ) {
        /**
         * check if we use RTL then make selected item the last one else make it first one.
         */
        if (isRtl) {
            pager.currentItem = items.size - 1
        } else {
            pager.currentItem = 0;
        }
        /**
         * set onNavigationItemSelected to check the selected item and
         * if we are using RTL then reverse with other one
         * else we keep it as selected.
         */
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            for (it in items) {
                if (it.id == item.itemId) {
                    if (isRtl) {
                        pager.currentItem = (items.size - 1 - items.indexOf(it))
                    } else {
                        pager.currentItem = items.indexOf(it)
                    }
                    bottom_navigation.menu.getItem(items.indexOf(it)).isChecked =
                        true
                    break
                }
            }
            false
        }
    }

}