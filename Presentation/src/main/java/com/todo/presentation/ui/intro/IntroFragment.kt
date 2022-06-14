package com.todo.presentation.ui.intro

import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentIntroBinding
import com.todo.presentation.ui.common.BaseFragment
import com.todo.presentation.ui.intro.IntroPagerAdapter.Companion.CALENDAR_FRAGMENT_INDEX
import com.todo.presentation.ui.intro.IntroPagerAdapter.Companion.HOME_FRAGMENT_INDEX
import com.todo.presentation.ui.intro.IntroPagerAdapter.Companion.SETTING_FRAGMENT_INDEX
import org.koin.androidx.viewmodel.ext.android.viewModel

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>() {
    override val layoutRes: Int = R.layout.fragment_intro
    override val viewModel: IntroViewModel by viewModel()

    override fun setBindingVariables() {}
    override fun initObserver() {}

    override fun initView() {
        initViewPagerAdapter()
        initBottomNavigationView()
    }

    private fun initViewPagerAdapter() {
        with(binding.viewPager) {
            adapter = IntroPagerAdapter(childFragmentManager, lifecycle)
            offscreenPageLimit = (adapter as IntroPagerAdapter).itemCount - 1
        }
    }

    private fun initBottomNavigationView() {
        with(binding.bottomNavigationView) {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.bottom_home -> {
                        binding.viewPager.currentItem = HOME_FRAGMENT_INDEX
                    }
                    R.id.bottom_calendar -> {
                        binding.viewPager.currentItem = CALENDAR_FRAGMENT_INDEX
                    }
                    R.id.bottom_setting -> {
                        binding.viewPager.currentItem = SETTING_FRAGMENT_INDEX
                    }
                }
                true
            }
        }
    }
}