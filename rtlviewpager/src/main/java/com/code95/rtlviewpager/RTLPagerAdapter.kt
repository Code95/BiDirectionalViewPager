package com.code95.rtlviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RTLPagerAdapter(
    fm: FragmentManager,
    var pager: BiDirectionViewpager,
    var isRtlOriented: Boolean
) :
    FragmentPagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    private var tabs: MutableList<Tab> = mutableListOf()


    override fun getItem(position: Int): Fragment {
        return tabs[position].fragment
    }

    override fun getCount(): Int {
        return tabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position].title
    }

    fun addTab(tab: Tab) {
        if (isRtlOriented) {
            this.tabs.add(0, tab)
        } else {
            this.tabs.add(tab)
        }
        getViewPagerItemPos()
    }

    fun addTabs(tabs: MutableList<Tab>) {
        if (isRtlOriented) {
            this.tabs.addAll(0, tabs.asReversed())
        } else {
            this.tabs.addAll(tabs)
        }
        getViewPagerItemPos()
    }

    fun removeTab(index: Int) {
        if (isRtlOriented) {
            tabs.removeAt(tabs.size.minus(index).minus(1))
        } else {
            tabs.removeAt(index)
        }
        getViewPagerItemPos()
    }

    private fun getViewPagerItemPos() {
        val view = pager.findViewWithTag("BiPager") as BiDirectionViewpager
        if (isRtlOriented) {
            view.currentItem = tabs.size.minus(1)
        }
        notifyDataSetChanged()
    }
}