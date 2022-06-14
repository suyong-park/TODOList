package com.todo.presentation.ui.intro

import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.todo.presentation.R
import com.todo.presentation.databinding.ActivityIntroBinding
import com.todo.presentation.ui.common.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>() {

    override val layoutRes = R.layout.activity_intro
    override val viewModel: IntroViewModel by viewModel()

    override fun setBindingVariables() {}
    override fun initView() {
        initViewPagerAdapter()
        initTabMediator()
    }

    private fun initViewPagerAdapter() {
        with(binding.viewPager) {
            adapter = IntroPagerAdapter(supportFragmentManager, lifecycle)
            offscreenPageLimit = (adapter as IntroPagerAdapter).itemCount - 1
        }
    }

    private fun initTabMediator() {
        with(binding) {
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