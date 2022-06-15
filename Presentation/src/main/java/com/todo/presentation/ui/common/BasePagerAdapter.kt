package com.todo.presentation.ui.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

abstract class BasePagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    abstract val fragmentCreators: Map<Int, () -> Fragment>
    override fun getItemCount(): Int = fragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return fragmentCreators[position]?.invoke()!!
    }
}