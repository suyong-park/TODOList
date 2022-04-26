package com.todo.presentation.ui.home

import androidx.fragment.app.viewModels
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentHomeBinding
import com.todo.presentation.ui.common.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun initView() {
    }

    override fun setBindingVariables() {
    }

    override fun initObserver() {
    }
}