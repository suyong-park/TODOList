package com.todo.presentation.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B: ViewDataBinding, V: BaseViewModel> : Fragment() {

    protected lateinit var binding: B

    abstract val layoutRes: Int
    abstract val viewModel: V

    abstract fun setBindingVariables()
    abstract fun initObserver()
    abstract fun initView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<B>(layoutInflater, layoutRes, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

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

        }
    }
}