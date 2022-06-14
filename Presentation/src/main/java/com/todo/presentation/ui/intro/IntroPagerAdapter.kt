package com.todo.presentation.ui.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.todo.presentation.ui.calendar.CalendarFragment
import com.todo.presentation.ui.common.BasePagerAdapter
import com.todo.presentation.ui.home.HomeFragment
import com.todo.presentation.ui.setting.SettingFragment

class IntroPagerAdapter(fragmentActivity: FragmentManager, lifecycle: Lifecycle) :
    BasePagerAdapter(fragmentActivity, lifecycle) {
    override val fragmentCreators: Map<Int, () -> Fragment> = mapOf(
        HOME_FRAGMENT_INDEX to { HomeFragment() },
        CALENDAR_FRAGMENT_INDEX to { CalendarFragment() },
        SETTING_FRAGMENT_INDEX to { SettingFragment() }
    )

    companion object {
        const val HOME_FRAGMENT_INDEX = 0
        const val CALENDAR_FRAGMENT_INDEX = 1
        const val SETTING_FRAGMENT_INDEX = 2
    }
}