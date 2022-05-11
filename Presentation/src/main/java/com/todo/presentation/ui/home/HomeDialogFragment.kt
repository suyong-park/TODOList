package com.todo.presentation.ui.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.todo.presentation.R
import com.todo.presentation.databinding.DialogHomeAddTodoBinding

class HomeDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogHomeAddTodoBinding
    private val viewModel: HomeDialogViewModel by viewModels()

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_home_add_todo, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        dialog?.setCancelable(false)

        setBindingVariables()
        initObserver()

        return binding.root
    }

    private fun setBindingVariables() {
        binding.homeDialogViewModel = viewModel
    }

    private fun initObserver() {
        with(binding) {
            viewModel.isDone.observe(viewLifecycleOwner) {
                if (it) {
                    dismiss()
                }
            }
        }
    }


}