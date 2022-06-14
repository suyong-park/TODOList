package com.todo.presentation.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.todo.core.log.Logger
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import com.todo.presentation.ui.common.BaseViewModel.ToastEvent

abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel> : Fragment() {

    private val logger: Logger by inject()

    protected lateinit var binding: B

    abstract val layoutRes: Int
    abstract val viewModel: V

    abstract fun setBindingVariables()
    abstract fun initObserver()
    abstract fun initView()

    protected open fun handleEvent(event: ToastEvent) {}
    protected open fun navigation(navigation: BaseNavigation) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<B>(layoutInflater, layoutRes, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindingVariables()
        initBaseObserver()
        initObserver()
        initView()
    }

    private fun initBaseObserver() {
        with(viewModel) {
            lifecycleScope.launch {
                toastEvent.collect { event ->
                    handleEvent(event)
                }

                navigation.collect {
                    navigation(it)
                }
            }
        }
    }
}