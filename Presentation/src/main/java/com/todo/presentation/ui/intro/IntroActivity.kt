package com.todo.presentation.ui.intro

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.todo.presentation.R
import com.todo.presentation.databinding.ActivityIntroBinding
import com.todo.presentation.ui.common.BaseActivity
import com.todo.presentation.ui.common.BaseViewModel

class IntroActivity : BaseActivity<ActivityIntroBinding, BaseViewModel>() {

    override val layoutRes = R.layout.activity_intro
    override val viewModel: BaseViewModel by viewModel()

    override fun setBindingVariables() {}
    override fun initView() {}
}