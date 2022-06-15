package com.todo.presentation.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.todo.core.log.Logger
import com.todo.presentation.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import com.todo.presentation.ui.common.BaseViewModel.ToastEvent

abstract class BaseBottomDialogFragment<B : ViewDataBinding, V : BaseViewModel> :
    BottomSheetDialogFragment() {

    protected val logger: Logger by inject()
    protected lateinit var binding: B

    abstract val layoutRes: Int
    abstract val viewModel: V

    abstract fun setBindingVariables()
    abstract fun initObserver()
    abstract fun initView()
    protected open fun handleEvent(event: ToastEvent) {}

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate<B>(inflater, layoutRes, container, false)
                .apply { lifecycleOwner = viewLifecycleOwner }

        setBindingVariables()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            }
        }
    }
}