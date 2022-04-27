package com.todo.presentation.ui.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.todo.presentation.ui.analysis.AnalysisFragment
import com.todo.presentation.ui.calendar.CalendarFragment
import com.todo.presentation.ui.home.HomeFragment
import com.todo.presentation.ui.setting.SettingFragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = PAGES_NUM

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CalendarFragment()
            2 -> AnalysisFragment()
            else -> SettingFragment()
        }
    }

    companion object {
        private const val PAGES_NUM = 4
    }
}