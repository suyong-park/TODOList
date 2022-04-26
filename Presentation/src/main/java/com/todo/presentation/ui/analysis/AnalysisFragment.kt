package com.todo.presentation.ui.analysis

import androidx.fragment.app.viewModels
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentAnalysisBinding
import com.todo.presentation.ui.common.BaseFragment

class AnalysisFragment : BaseFragment<FragmentAnalysisBinding, AnalysisViewModel>() {

    override val layoutRes = R.layout.fragment_analysis
    override val viewModel: AnalysisViewModel by viewModels()

    override fun initView() {

    }

    override fun setBindingVariables() {

    }

    override fun initObserver() {

    }
}