package com.todo.presentation.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var binding: B

    abstract val layoutRes: Int
    abstract val viewModel: V

    abstract fun setBindingVariables()
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<B>(this, layoutRes).apply {
            lifecycleOwner = this@BaseActivity
        }

        setBindingVariables()
        initBaseObserver()
        initView()
    }

    private fun initBaseObserver() {
        with(viewModel) {

        }
    }
}