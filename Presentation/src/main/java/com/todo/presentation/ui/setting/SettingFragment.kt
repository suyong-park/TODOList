package com.todo.presentation.ui.setting

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentSettingBinding
import com.todo.presentation.ui.common.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {

    override val layoutRes = R.layout.fragment_setting
    override val viewModel: SettingViewModel by viewModel()

    override fun initView() {
    }

    override fun setBindingVariables() {
    }

    override fun initObserver() {
    }
}