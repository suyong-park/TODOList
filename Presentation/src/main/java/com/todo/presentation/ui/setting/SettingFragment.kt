package com.todo.presentation.ui.setting

import androidx.fragment.app.viewModels
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentSettingBinding
import com.todo.presentation.ui.common.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {

    override val layoutRes = R.layout.fragment_setting
    override val viewModel: SettingViewModel by viewModels()

    override fun initView() {
    }

    override fun setBindingVariables() {
    }

    override fun initObserver() {
    }
}