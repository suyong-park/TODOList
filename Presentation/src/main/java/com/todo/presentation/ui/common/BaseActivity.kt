package com.todo.presentation.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.todo.core.log.Logger
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    private val logger: Logger by inject()

    lateinit var binding: B

    abstract val layoutRes: Int
    abstract val viewModel: V

    abstract fun setBindingVariables()
    abstract fun initView()

    protected open fun handleEvent(event: BaseViewModel.Event) {}

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
            lifecycleScope.launch {
                toastEvent.collect { event ->
                    handleEvent(event)
                }
            }
        }
    }
}