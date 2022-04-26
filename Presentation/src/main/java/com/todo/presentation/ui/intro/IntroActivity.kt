package com.todo.presentation.ui.intro

import androidx.activity.viewModels
import com.todo.presentation.R
import com.todo.presentation.databinding.ActivityIntroBinding
import com.todo.presentation.ui.common.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>() {

    override val layoutRes = R.layout.activity_intro
    override val viewModel: IntroViewModel by viewModels()

    override fun setBindingVariables() {

    }

    override fun initView() {

    }
}