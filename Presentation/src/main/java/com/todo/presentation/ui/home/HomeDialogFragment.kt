package com.todo.presentation.ui.home

import androidx.lifecycle.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.todo.presentation.R
import com.todo.presentation.databinding.DialogHomeAddTodoBinding
import com.todo.presentation.ui.common.BaseBottomDialogFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeDialogFragment : BaseBottomDialogFragment<DialogHomeAddTodoBinding, HomeDialogViewModel>() {

    override val layoutRes: Int = R.layout.dialog_home_add_todo
    override val viewModel: HomeDialogViewModel by viewModel()

    override fun initView() {}

    override fun setBindingVariables() {
        with(binding) {
            homeDialogViewModel = viewModel
        }
    }

    override fun initObserver() {
        with(viewModel) {
            lifecycleScope.launch {
                isDone.collect {
                    dismiss()
                }
            }
        }
    }

    companion object {
        const val TAG = "HomeDialogFragment"
    }
}