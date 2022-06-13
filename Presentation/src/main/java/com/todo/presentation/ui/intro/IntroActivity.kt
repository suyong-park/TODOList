package com.todo.presentation.ui.intro

import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.todo.presentation.R
import com.todo.presentation.databinding.ActivityIntroBinding
import com.todo.presentation.ui.common.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>() {

    override val layoutRes = R.layout.activity_intro
    override val viewModel: IntroViewModel by viewModels()

    override fun setBindingVariables() {
    }

    override fun initView() {
        with(binding) {
            viewPager.apply {
                adapter = PagerAdapter(context as FragmentActivity)
            }

            TabLayoutMediator(tab, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = getString(R.string.home)
                    1 -> tab.text = getString(R.string.calendar)
                    2 -> tab.text = getString(R.string.setting)
                }
            }.attach()
        }
    }
}